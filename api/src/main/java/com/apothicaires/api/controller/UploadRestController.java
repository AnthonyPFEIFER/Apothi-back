package com.apothicaires.api.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class UploadRestController implements ServletContextAware {

    private ServletContext servletContext;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile[] files) {
        try {
            System.out.println("File List");
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
            System.out.println(path + " is path and ce sera le nom " + newFileName);
            System.out.println("Step 1!");
            Files.write(path, bytes);
            System.out.println("Step 2!");
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
