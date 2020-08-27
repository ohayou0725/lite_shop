package com.ohayou.liteshop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liyan
 * @date 2020/8/12 下午10:33
 */
public interface UploadService {

    String upload(MultipartFile file,String filePath);
}
