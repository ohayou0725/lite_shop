package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.dto.MallGoodsAttrDto;
import com.ohayou.liteshop.entity.MallAttrGroup;
import com.ohayou.liteshop.entity.MallAttrGroupRelation;
import com.ohayou.liteshop.entity.MallCategory;
import com.ohayou.liteshop.entity.MallGoodsAttr;
import com.ohayou.liteshop.dao.MallGoodsAttrMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallAttrGroupRelationService;
import com.ohayou.liteshop.service.MallAttrGroupService;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallGoodsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品参数表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MallGoodsAttrServiceImpl extends ServiceImpl<MallGoodsAttrMapper, MallGoodsAttr> implements MallGoodsAttrService {
    @Autowired
    MallCategoryService mallCategoryService;

    @Autowired
    MallAttrGroupService attrGroupService;

    @Autowired
    MallAttrGroupRelationService attrGroupRelationService;

    /**
     * 查询分类下所有属性
     *
     * @param attrGroupId
     * @param id
     * @return
     */
    @Override
    public List<MallGoodsAttrDto> listAttrByGroupId(Long attrGroupId, Long id) {
        if (null == attrGroupId || 0 == attrGroupId) {
            return null;
        }
        List<MallGoodsAttrDto> collect = baseMapper.listAttrByGroupId(attrGroupId)
                .stream()
                .sorted(Comparator.comparing(MallGoodsAttr::getSort))
                .map(mallGoodsAttr -> {
                    MallGoodsAttrDto mallGoodsAttrDto = new MallGoodsAttrDto();
                    BeanUtils.copyProperties(mallGoodsAttr, mallGoodsAttrDto);
                    mallGoodsAttrDto.setCategoryId(id);
                    return mallGoodsAttrDto;
                })
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * 为商品分类添加属性
     *
     * @param mallGoodsAttrDto
     */
    @Override
    public void addGoodsAttr(MallGoodsAttrDto mallGoodsAttrDto) {
        Long categoryId = mallGoodsAttrDto.getCategoryId();
        if (null == categoryId || categoryId <= 0) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        //查询该分类是否存在
        MallCategory category = mallCategoryService.getById(categoryId);
        if (null == category) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        //先得到该分类的属性分组id
        Long attrGroupId = category.getAttrGroupId();
        if (null == attrGroupId || attrGroupId == 0) {
            // 如果没有分组id则说明该分类还没有添加过任何属性
            //为该分类建立属性分组信息
            MallAttrGroup attrGroup = new MallAttrGroup();
            attrGroup.setName(category.getName());
            attrGroupService.save(attrGroup);
            category.setAttrGroupId(attrGroup.getId());
            mallCategoryService.updateById(category);
        }
        //有分组ID，说明已有属性只需进行添加,不新建分组
        //查看该分类下是否已有同名属性
        boolean hasAttr = false;
        List<MallGoodsAttrDto> attrList = this.listAttrByGroupId(attrGroupId,categoryId );
        if (null != attrList && attrList.size() > 0) {
            hasAttr = attrList.stream().anyMatch(mallGoodsAttr -> {
                return mallGoodsAttrDto.getAttrName().equals(mallGoodsAttr.getAttrName());
            });
        }

        if (hasAttr) {
            throw new GlobalException(ErrorCodeMsg.GOODS_ATTR_EXIST);
        }
        MallGoodsAttr goodsAttr = new MallGoodsAttr();
        goodsAttr.setAttrName(mallGoodsAttrDto.getAttrName());
        goodsAttr.setSort(mallGoodsAttrDto.getSort());
        this.save(goodsAttr);
        MallAttrGroupRelation mallAttrGroupRelation = new MallAttrGroupRelation();
        mallAttrGroupRelation.setAttrId(goodsAttr.getId());
        mallAttrGroupRelation.setAttrGroupId(category.getAttrGroupId());
        attrGroupRelationService.save(mallAttrGroupRelation);
    }

    /**
     * 更新分类属性
     * @param mallGoodsAttrDto
     * @return
     */
    @Override
    public boolean updateAttr(MallGoodsAttrDto mallGoodsAttrDto) {
        Long id = mallGoodsAttrDto.getId();
        if (null == id || id <= 0) {
            throw new GlobalException(ErrorCodeMsg.GOODS_ATTR_NOT_FOUND);
        }
        MallGoodsAttr mallGoodsAttr = new MallGoodsAttr();
        BeanUtils.copyProperties(mallGoodsAttrDto,mallGoodsAttr);
        return this.updateById(mallGoodsAttr);
    }

    /**
     * 删除分类属性
     * @param mallGoodsAttrDto
     * @return
     */
    @Override
    public boolean deleteAttr(MallGoodsAttrDto mallGoodsAttrDto) {
        Long id = mallGoodsAttrDto.getId();
        Long categoryId = mallGoodsAttrDto.getCategoryId();
        if (id == null || id <=0 || categoryId == null || categoryId <= 0) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        //先删除分类属性关联
        MallCategory category = mallCategoryService.getById(categoryId);
        Long attrGroupId = category.getAttrGroupId();
        boolean remove = attrGroupRelationService.remove(new LambdaQueryWrapper<MallAttrGroupRelation>()
                .eq(MallAttrGroupRelation::getAttrGroupId, attrGroupId)
                .eq(MallAttrGroupRelation::getAttrId, id));
        if (remove) {
            //删除分类信息
            return this.removeById(id);
        }
        return false;
    }

    @Override
    public List<String> attrList() {
        List<MallGoodsAttr> list = this.list();
        if (null != list && list.size() > 0) {
            List<String> collect = list.stream()
                    .map(MallGoodsAttr::getAttrName)
                    .distinct()
                    .collect(Collectors.toList());
            return collect;
        }
        return null;
    }
}
