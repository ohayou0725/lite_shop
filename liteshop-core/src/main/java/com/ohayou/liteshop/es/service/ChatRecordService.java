package com.ohayou.liteshop.es.service;

import com.ohayou.liteshop.es.ChatRecord;
import com.ohayou.liteshop.vo.UserMessageVo;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/5/2 下午8:46
 */
public interface ChatRecordService {

    void save(ChatRecord chatRecord);

    List<UserMessageVo> chatRecordListByAdminId(Long adminId);

    void updateRecordHaveRead(long id, String userMobile);

    List<ChatRecord> chatRecordListByUserMobileAndOrderId(String userMobile, Long orderId);

    List<ChatRecord> chatRecordListByOrderId(Long orderId);

    void deleteRecordByOrderId(Long orderId);
}
