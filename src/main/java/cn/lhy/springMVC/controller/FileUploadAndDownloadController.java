package cn.lhy.springMVC.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传和下载
 */
@Controller
@RequestMapping("/uploadAndDownload")
public class FileUploadAndDownloadController {
    @RequestMapping("/prepare")
    public String prepare(){
        return "fileUploadAndDownload/prepareView";
    }

    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("mark")String mark,
                             @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        System.out.println("mark = " + mark);
        if (!multipartFile.isEmpty()){
            // 文件保存的绝对路径（文件操作需要绝对路径），是webapp下面的路径
            String path = request.getServletContext().getRealPath("/uploadFiles/");
            String fileName = multipartFile.getOriginalFilename();
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdirs();
                System.out.println("该文件夹不存在，新建文件夹");
            }
            // 写出文件到硬盘上，文件在以下位置，idea中可能看不到
            multipartFile.transferTo(targetFile);
        }
        System.out.println("上传成功。。。。。。。。");
        return "redirect:/uploadAndDownload/prepare";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName,
                                           HttpServletRequest request) throws IOException {

        String filePath = request.getServletContext().getRealPath("/uploadFiles/");
        File targetFile = new File(filePath + File.separator + fileName);
        HttpHeaders httpHeaders = new HttpHeaders();
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment", downloadFileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] targetFileBytes = FileUtils.readFileToByteArray(targetFile);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(targetFileBytes, httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }
}
