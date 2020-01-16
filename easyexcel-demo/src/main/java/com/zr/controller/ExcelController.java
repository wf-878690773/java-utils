package com.zr.controller;

import com.alibaba.excel.EasyExcel;
import com.zr.mapper.UserMapper;
import com.zr.domain.User;
import com.zr.lister.UploadDataLister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExcelController {


    @Autowired
    private UserMapper userMapper;
    /**
     * 上传
     */
    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {

        EasyExcel.read(file.getInputStream(), User.class,new UploadDataLister(userMapper)).sheet().doRead();

        return "success";

    }

    /**
     * 下载
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(data());

    }

    private List<User> data() {

        return userMapper.selectAll();
    }
}
