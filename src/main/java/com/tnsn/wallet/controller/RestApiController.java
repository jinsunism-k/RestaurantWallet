package com.tnsn.wallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@RestController
public class RestApiController {

    @RequestMapping(value = "/wallet/upload", method = RequestMethod.POST)
    public ResponseEntity<String> Test(@RequestParam("file") MultipartFile multipartFile) {

        try {
            String savePath = "/home/ec2-user/image/";
            String saveFileName = multipartFile.getOriginalFilename();

            byte[] data = multipartFile.getBytes();
            FileOutputStream fos = new FileOutputStream(savePath + "/" + saveFileName);
            fos.write(data);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload Fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Upload Success", HttpStatus.OK);
    }
}
