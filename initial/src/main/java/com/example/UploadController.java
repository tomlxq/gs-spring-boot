package com.example;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class UploadController extends BaseController {
    public static final String DIR = FilenameUtils.getPathNoEndSeparator(UploadController.class.getClassLoader().getResource("templates").getFile());


    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "fileupload";
    }

    //接受多个文件上传使用@RequestParam("file") MultipartFile[] files
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String upload(@RequestParam("file") MultipartFile file) {
        String path = DIR + File.separator + file.getOriginalFilename();
        logger.debug("上传path {}", path);
        try {
            FileUtils.writeByteArrayToFile(new File(path),
                    file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }


    }


}
