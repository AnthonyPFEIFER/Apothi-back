package com.apothicaires.api.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import com.apothicaires.api.model.Photo;
import com.apothicaires.api.model.Tatouage;
import com.apothicaires.api.service.PhotoService;
import com.apothicaires.api.service.TatouageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class UploadRestController implements ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    PhotoService photoService;
    @Autowired
    TatouageService tatouageService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                System.out.println("File name: " + file.getOriginalFilename());
                System.out.println("File size: " + file.getSize());
                System.out.println("File type: " + file.getContentType());
                System.out.println("---------------------------");
                save(file);
            }
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    private String save(MultipartFile file) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
            String newFileName = simpleDateFormat.format(new Date()) + file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.servletContext.getRealPath("/uploads/images/" + newFileName));
            Files.write(path, bytes);
            System.out.println("Successfully uploaded " + newFileName + " !");
            return newFileName;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
