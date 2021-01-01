package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.TopicDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MallTopic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.BannerVo;
import com.ohayou.liteshop.vo.FeaturedTopicVo;
import com.ohayou.liteshop.vo.TopicGoodsListVo;

import java.util.List;

/**
 * <p>
 * 专题表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallTopicService extends IService<MallTopic> {

    PageUtils queryPage(TopicDto topicDto, IPage<MallTopic> page);

    boolean changeShow(TopicDto topicDto);

    boolean addTopic(TopicDto topicDto);

    List<MallGoodsSpu> getGoodsList(Long topicId);

    boolean addTopicGoods(TopicDto topicDto);

    boolean deleteGoods(TopicDto topicDto);

    boolean deleteTopic(Long id);

    boolean saveOrUpdateContent(TopicDto topicDto);

    boolean updateTopic(TopicDto topicDto);

    List<BannerVo> getBanner();

    List<FeaturedTopicVo> getFeaturedTopic();

    TopicGoodsListVo getTopicGoodsListVo(Long topicId, int page, int size);
}
