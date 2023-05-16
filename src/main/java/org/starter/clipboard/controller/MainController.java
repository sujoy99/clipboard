package org.starter.clipboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String getForm(){
        logger.info("::----get controller-----::");
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFiles(@RequestParam("bonding_file_custom[]") MultipartFile[] files) {
        logger.info("::----post controller-----::");
        String message = "";
        try {
            Arrays.asList(files).stream().forEach(file -> {
                logger.info("::----file name-----::" + file.getOriginalFilename());
            });

            message = "Uploaded the files successfully: ";
            return "redirect:/";
        } catch (Exception e) {
            message = "Fail to upload files!";
            return "redirect:/";
        }
    }
}
