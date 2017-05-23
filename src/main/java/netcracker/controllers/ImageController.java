package netcracker.controllers;

import netcracker.domain.entities.Images;
import netcracker.services.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sivko on 22.05.2017.
 */
@Controller
@RequestMapping("/myImage")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long imageId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {

        Images image = imageService.findById(imageId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(image.getImage());
        response.getOutputStream().close();
    }
}