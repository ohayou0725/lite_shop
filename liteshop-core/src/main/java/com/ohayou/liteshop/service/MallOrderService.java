package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.MallOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.payment.wechat.NotifyDTO;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品订单表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallOrderService extends IService<MallOrder> {

    PageUtils queryPage(OrderDto orderDto, IPage<MallOrder> page);

    OrderDetailDto getOrderDetail(Long orderId);

    boolean ship(OrderDetailDto orderDetailDto);

    boolean deleteOrder(Long orderId);

    List<Map<String, String>> queryExpressTrack(Long orderId);

    PageUtils afterSalePage(OrderAfterSaleDto afterSaleDto, IPage<MallOrder> page);

    AfterSaleDetailDto afterSaleDetail(Long orderId);

    boolean approvedOrder(Long orderId);

    boolean refuseOrder(Long orderId);

    List<OrderStatisticsDto> getOrderStatistics(LocalDate startTime, LocalDate endTime);

    OrderConfirmVo getOrderConfirm(List<OrderConfirmItemVo> orderConfirmItems,Long userId);

    BigDecimal useCoupon(String orderSn, Long couponId, Long id);

    String settleOrder(String orderSn, Long addressId, Long userId);

    boolean cancelOrder(String orderSn);

    OrderDetailVo getOrderDetailByOrderSn(String orderSn, Long userId);

    Long getRemainingTime(String orderSn, Long userId);

    String doPay(String orderSn, Integer payType, Long id);

    boolean doPayed(NotifyDTO notifyDTO);

    boolean cancelOrder(Long orderId, Long id,String message);

    List<OrderListItemVo> queryOrderList(int page, int size, int status,Long userId);

    boolean deleteByMember(Long orderId, Long id);

    OrderCountVo getOrderCount(Long id);

    ShipTraceVo getOrderTrace(Long orderId, Long userId);

    boolean cancelOrderOnPaid(Long orderId, Long userId, String message);

    boolean confirm(Long orderId,Long userId);

    boolean confirm(Long orderId);

    List<OrderItemVo> getNotCommentedItem(Long orderId,Long userId);
}


