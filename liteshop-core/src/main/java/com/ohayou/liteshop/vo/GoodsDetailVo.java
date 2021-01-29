package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2021/1/1 下午9:36
 */
public class GoodsDetailVo {


    private CommentVo comment;

    private GoodsInfoVo goodsInfo;

    private SkuVo skuVo;

    private List<GoodsAttrVo> attrList;

    public SkuVo getSkuVo() {
        return skuVo;
    }

    public List<CouponVo> coupons;

    public void setSkuVo(SkuVo skuVo) {
        this.skuVo = skuVo;
    }

    public GoodsInfoVo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfoVo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public CommentVo getComment() {
        return comment;
    }



    public void setComment(CommentVo comment) {
        this.comment = comment;
    }

    public List<GoodsAttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<GoodsAttrVo> attrList) {


        this.attrList = attrList;
    }

    public List<CouponVo> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponVo> coupons) {
        this.coupons = coupons;
    }
}
