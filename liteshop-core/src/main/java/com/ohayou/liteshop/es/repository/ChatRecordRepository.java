package com.ohayou.liteshop.es.repository;

import com.ohayou.liteshop.es.ChatRecord;
import com.ohayou.liteshop.vo.UserMessageVo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyan
 * @date 2021/5/2 下午8:44
 */
@Repository
public interface ChatRecordRepository extends ElasticsearchRepository<ChatRecord,Long> {
    List<ChatRecord> getChatRecordsByAdminIdEquals(Long adminId);

    List<ChatRecord> getChatRecordsByAdminIdAndUserMobile(Long adminId, String userMobile);

    List<ChatRecord> getChatRecordsByUserMobileAndOrderId(String userMobile, Long orderId);

    List<ChatRecord> getChatRecordsByOrderIdEquals(Long orderId);

    void deleteChatRecordByOrderIdEquals(Long orderId);
}
