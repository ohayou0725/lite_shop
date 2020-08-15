package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.UploadService;
import com.ohayou.liteshop.upload.QiniuUpload;
import com.ohayou.liteshop.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 上传组件
 * @author liyan
 * @date 2020/8/12 下午10:31
 */

@Service
public class QiniuUploadServiceImpl implements UploadService {

    @Autowired
    QiniuUpload qiniuUpload;


    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new GlobalException(ErrorCodeMsg.UPLOAD_ERROR);
        }
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String fileName = FileUtils.generateUploadFileName(originalFilename);
            String url = qiniuUpload.upload(inputStream,fileName);
            return url;
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.UPLOAD_ERROR);
        }
    }
}
