package com.ohayou.liteshop.service;

import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/24 下午2:22
 */
//快读查询接口
public interface ExpressTrackService {

    Map<String,Object> getTrack(String expCode, String expNo) throws Exception;
}
