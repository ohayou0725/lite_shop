package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.TopicDto;
import com.ohayou.liteshop.entity.MallTopic;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/27 下午9:15
 */

@RestController
@RequestMapping("/operation/topic")
public class MallTopicController {

    @Autowired
    MallTopicService topicService;


    @ApiDesc("查询主题列表")
    @GetMapping("/list")
    public Result list(TopicDto topicDto, Map<String,Object> queryParam) {
        PageQuery<MallTopic> pageQuery = new PageQuery<>();
        IPage<MallTopic> page = pageQuery.getPage(queryParam);
        PageUtils pageUtils = topicService.queryPage(topicDto,page);
        return Result.success("page",pageUtils);
    }

    @ApiDesc("查询专题商品")
    @GetMapping("/allGoods/{id}")
    public Result goodsList(@PathVariable("id") Long topicId) {
        if (null == topicId || topicId < 0) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        return Result.success("list",topicService.getGoodsList(topicId));
    }

    @ApiDesc("更改主题上线状态")
    @PostMapping("/changeShow")
    public Result changeShow(@RequestBody @Valid TopicDto topicDto) {

        boolean result = topicService.changeShow(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_CHANGE_ERROR);
    }

    @ApiDesc("添加专题")
    @PostMapping("/add")
    public Result addTopic(@RequestBody @Validated(value = TopicDto.AddTopicDto.class) TopicDto topicDto) {
        boolean result = topicService.addTopic(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_ADD_ERROR);
    }

    @ApiDesc("专题添加相关商品")
    @PostMapping("/addGoods")
    public Result addTopicGoods(@RequestBody @Validated(value = TopicDto.UpdateTopicDto.class) TopicDto topicDto) {
        if (CollectionUtil.isEmpty(topicDto.getGoodsList())) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = topicService.addTopicGoods(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_ADD_GOODS_ERROR);
    }

    @ApiDesc("删除专题相关商品")
    @PostMapping("/deleteGoods")
    public Result deleteGoods(@RequestBody @Validated(value = TopicDto.UpdateTopicDto.class) TopicDto topicDto) {
        if (CollectionUtil.isEmpty(topicDto.getGoodsList())) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = topicService.deleteGoods(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_DELETE_GOODS_ERROR   );
    }


    @ApiDesc("删除专题")
    @PostMapping("/delete/{id}")
    public Result deleteTopic(@PathVariable("id") Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = topicService.deleteTopic(id);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_DELETE_ERROR);
    }

    @ApiDesc("新增或修改专题详情")
    @PostMapping("/content")
    public Result saveContent(@RequestBody @Validated(value = TopicDto.UpdateTopicDto.class) TopicDto topicDto) {
        boolean result = topicService.saveOrUpdateContent(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_UPDATE_ERROR);
    }

    @ApiDesc("修改专题")
    @PostMapping("/update")
    public Result updateTopic(@RequestBody @Validated(value = TopicDto.UpdateTopicDto.class)TopicDto topicDto) {
        boolean result = topicService.updateTopic(topicDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.TOPIC_UPDATE_ERROR);
    }
}
