package com.ohayou.liteshop.scheduleTask;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.RefundKey;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.payment.PayService;
import com.ohayou.liteshop.service.MallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2021/4/1 下午9:24
 */
@Configuration
@EnableScheduling
public class RefundScheduleTask {

    @Autowired
    private RedisService redisService;

    @Autowired
    private PayService payService;

    @Autowired
    private MallOrderService orderService;

    @Scheduled(cron = "0 0/5 * * * ?")
    //每隔五分钟执行一次
    private void configureTasks() {
        //从redis里获取退款列表 遍历列表如果未能成功退款则加入到队列末尾，成功则直接删除

        RefundKey refundKey = new RefundKey();

        Long size = redisService.lGetListSize(refundKey.getPrefix());
        if (redisService.hasKey(refundKey.getPrefix()) && size > 0) {
            while (size > 0) {
                Object o = redisService.lPop(refundKey.getPrefix());
                if (null != o) {
                    String payId = String.valueOf(o);

                    boolean result = payService.refund(payId);

                    MallOrder one = orderService.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getPayId, payId));
                    one.setPayTime(LocalDateTime.now());
                    orderService.updateById(one);
                    if (!result) {
                        redisService.lSet(refundKey.getPrefix(),payId);
                    }
                }
                size --;
            }
        }
    }

}
