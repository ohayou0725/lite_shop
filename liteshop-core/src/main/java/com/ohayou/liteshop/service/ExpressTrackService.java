package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.ExpressResultDTO;

/**
 * @author liyan
 * @date 2020/9/24 下午2:22
 */
//快读查询接口
public interface ExpressTrackService {

    ExpressResultDTO getTrack(String expCode, String expNo,String mobile) throws Exception;
}
