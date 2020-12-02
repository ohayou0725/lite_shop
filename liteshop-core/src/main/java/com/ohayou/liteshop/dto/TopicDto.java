package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.MallGoodsSpu;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2020/9/27 下午9:20
 */
public class TopicDto {

    public interface AddTopicDto{}

    public interface UpdateTopicDto {}

    @NotNull(message = "主题id不能为空",groups = {UpdateTopicDto.class})
    @Min(value = 1,message = "id必须为数字", groups = {UpdateTopicDto.class})
    private Long id;

    @NotBlank(message = "专题标题不能为空",groups = {AddTopicDto.class})
    private String title;

    @NotBlank(message = "专题子标题不能为空",groups = {AddTopicDto.class})
    private String subtitle;

    private String content;

    private BigDecimal price;

    private Integer ReadCount;

    private Long brandId;

    @NotBlank(message = "专题图片不能为空",groups = {AddTopicDto.class})
    private String imgs;

    @Max(value = Integer.MAX_VALUE,message = "排序号必须为数字类型",groups = {AddTopicDto.class})
    private Integer sort;

    @NotNull(message = "主题状态不能为空")
    @Min(value = 0,message = "非法参数")
    @Max(value = 1,message = "非法参数")
    private Integer isShow;

    private Integer position;

    private List<MallGoodsSpu> goodsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getReadCount() {
        return ReadCount;
    }

    public void setReadCount(Integer readCount) {
        ReadCount = readCount;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public List<MallGoodsSpu> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<MallGoodsSpu> goodsList) {

        this.goodsList = goodsList;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
