package com.ohayou.liteshop.service;

import com.ohayou.liteshop.entity.ChatRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.vo.UserMessageVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ohayou
 * @since 2021-05-13
 */
public interface ChatRecordService extends IService<ChatRecord> {

    void readChatRecord(Long orderId);

    List<UserMessageVo> chatRecordListByAdminId(long adminUserId);
}
