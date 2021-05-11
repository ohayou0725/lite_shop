package com.ohayou.liteshop.es.service;

import cn.hutool.core.collection.CollectionUtil;
import com.ohayou.liteshop.es.ChatRecord;
import com.ohayou.liteshop.es.repository.ChatRecordRepository;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.vo.UserMessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liyan
 * @date 2021/5/2 下午8:48
 */
@Service
public class ChatRecordServiceImpl implements ChatRecordService {
    @Autowired
    @Qualifier("elasticsearchTemplate")
    ElasticsearchRestTemplate esTemplate;

    @Autowired
    ChatRecordRepository recordRepository;

    @Autowired
    MemUserService userService;

    @Override
    public List<UserMessageVo> chatRecordListByAdminId(Long adminId) {
        List<ChatRecord> records = this.recordRepository.getChatRecordsByAdminIdEquals(adminId);
        Map<String, List<ChatRecord>> collect = records.stream()
                .filter(chatRecord -> {return StringUtils.isNotBlank(chatRecord.getUserMobile());})
                .collect(Collectors.groupingBy(ChatRecord::getUserMobile));
        List<UserMessageVo> list = new ArrayList<>();

        if (CollectionUtil.isNotEmpty(collect)) {
            collect.forEach((s, chatRecords) -> {
                UserMessageVo userMessageVo = new UserMessageVo();
                userMessageVo.setUserMobile(s);
                userMessageVo.setUserNickname(chatRecords.get(0).getUserNickname());
                userMessageVo.setRecords(chatRecords);
                userMessageVo.setAvatar(userService.getUserByMobile(s).getAvatar());
                userMessageVo.setUnReadCount(chatRecords.stream().filter(chatRecord -> {
                    return !chatRecord.isAck();
                }).count());
                list.add(userMessageVo);
            });
        }

        return list;
    }

    @Override
    public void updateRecordHaveRead(long adminId, String userMobile) {
        List<ChatRecord> records = this.recordRepository.getChatRecordsByAdminIdAndUserMobile(adminId, userMobile);
        List<ChatRecord> collect = records.stream().peek(record -> {
            record.setAck(true);
        }).collect(Collectors.toList());

        esTemplate.save(collect);

    }

    @Override
    public List<ChatRecord> chatRecordListByUserMobileAndOrderId(String userMobile, Long orderId) {

        return this.recordRepository.getChatRecordsByUserMobileAndOrderId(userMobile,orderId);
    }

    @Override
    public List<ChatRecord> chatRecordListByOrderId(Long orderId) {
        return  this.recordRepository.getChatRecordsByOrderIdEquals(orderId);
    }

    @Override
    public void deleteRecordByOrderId(Long orderId) {
        this.recordRepository.deleteChatRecordByOrderIdEquals(orderId);
    }

    @Override
    public void save(ChatRecord chatRecord) {

        esTemplate.save(chatRecord);
    }
}
