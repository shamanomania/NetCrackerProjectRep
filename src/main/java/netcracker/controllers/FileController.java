package netcracker.controllers;

import netcracker.domain.entities.Images;
import netcracker.services.impl.ImageService;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import org.h2.engine.Session;
import org.hibernate.Hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by sivko on 21.05.2017.
 */

@Controller
public class FileController {

    @Autowired
    ImageService imageService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/uploadImage", method = RequestMethod.GET)
    public String uploadPage(){
        return "fileUploader";
    }

    @RequestMapping(value = "/uploadImage1", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {// имена параметров (тут - "file") - из формы JSP.

        String name = null;

        if (!file.isEmpty()) {

            try {
                byte[] bytes = file.getBytes();

                Images image = new Images();
                image.setImage(bytes);
           //     image.setId((long) 12);
                imageService.save(image);
                name = file.getOriginalFilename();

                return "You successfully uploaded file=" + name;

            } catch (IOException e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
