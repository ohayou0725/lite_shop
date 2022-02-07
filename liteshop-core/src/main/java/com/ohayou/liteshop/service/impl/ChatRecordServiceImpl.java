package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ohayou.liteshop.entity.ChatRecord;
import com.ohayou.liteshop.dao.ChatRecordMapper;
import com.ohayou.liteshop.service.ChatRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.vo.UserMessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2021-05-13
 */
@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements ChatRecordService {

    @Autowired
    MemUserService userService;

    @Autowired
    MallOrderService orderService;

    @Override
    public void readChatRecord(Long orderId) {

        LambdaUpdateWrapper<ChatRecord> set = new LambdaUpdateWrapper<ChatRecord>().eq(ChatRecord::getOrderId, orderId)
                .set(ChatRecord::getAck, 1);
        this.update(set);
    }

    @Override
    public List<UserMessageVo> chatRecordListByAdminId(long adminUserId) {
        LambdaQueryWrapper<ChatRecord> eq = new LambdaQueryWrapper<ChatRecord>().eq(ChatRecord::getAdminId, adminUserId);
        List<ChatRecord> records = this.list(eq);
        Map<Long, List<ChatRecord>> collect = records.stream()
                .filter(chatRecord -> {
                    return StringUtils.isNotBlank(chatRecord.getUserMobile());
                })
                .collect(Collectors.groupingBy(ChatRecord::getOrderId));
        List<UserMessageVo> list = new ArrayList<>();

        if (CollectionUtil.isNotEmpty(collect)) {
            collect.forEach((orderId, chatRecords) -> {
                UserMessageVo userMessageVo = new UserMessageVo();
                userMessageVo.setUserMobile(chatRecords.get(0).getUserMobile());
                userMessageVo.setOrderId(orderId);
                userMessageVo.setOrderSn(orderService.getById(orderId).getOrderSn());
                userMessageVo.setUserNickname(chatRecords.get(0).getUserNickname());
                userMessageVo.setRecords(chatRecords);
                userMessageVo.setAvatar(userService.getUserByMobile(userMessageVo.getUserMobile()).getAvatar());
                userMessageVo.setUnReadCount(chatRecords.stream().filter(chatRecord -> {
                    return chatRecord.getAck() < 1 && chatRecord.getAdminSend() > 0;
                }).count());
                list.add(userMessageVo);
            });
        }

        return list;
    }
}


