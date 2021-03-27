package com.ohayou.liteshop.service.impl;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.dto.ExpressResponseDTO;
import com.ohayou.liteshop.dto.ExpressResultDTO;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.ExpressTrackService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author liyan
 * @date 2021/3/25 下午10:44
 */
@Service
public class ExpressTrackServiceImpl implements ExpressTrackService {

    @Value(value = "${express.url}")
    private String url;

    @Value(value = "${express.appKey}")
    private String appKey;

    @Autowired
    ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressTrackServiceImpl.class);


    @Override
    public ExpressResultDTO getTrack(String expCode, String expNo,String mobile) throws Exception {
        String requestUrl = "";
        if (StringUtils.isBlank(mobile)) {
            requestUrl = url + "?" + "appkey=" + appKey + "&type=auto&number=" + expNo;
        } else {
            requestUrl = url + "?" + "appkey=" + appKey + "&type=auto&number=" + expNo + "&mobile=" + mobile;

        }
        String response = HttpUtil.get(requestUrl);
        try {
            ExpressResponseDTO expressResponseDTO = objectMapper.readValue(response, ExpressResponseDTO.class);
            if (expressResponseDTO.getStatus().equals(0)) {
                return expressResponseDTO.getResult();
            } else {
                LOGGER.error(expressResponseDTO.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(ErrorCodeMsg.QUERY_TRACK_ERROR);
        }

        return null;
    }

}
