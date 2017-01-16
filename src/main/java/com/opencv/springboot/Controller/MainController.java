package com.opencv.springboot.Controller;

import com.opencv.springboot.Service.FaceDetectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * Created by frkn on 15/01/2017.
 */
@RestController
public class MainController {

    private final FaceDetectionService faceDetectionService;

    @Autowired
    public MainController(FaceDetectionService faceDetectionService) {
        this.faceDetectionService = faceDetectionService;
    }


    @ResponseBody
    @RequestMapping(value = "/faceDetect", method = RequestMethod.POST, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] detectFace(@RequestParam("file") MultipartFile file) throws IOException {

       if ( !validateImage(file))
       {
          return new byte[1];
       }

        return faceDetectionService.detectFace(file).toImage();
    }

    private Boolean validateImage(MultipartFile image) {
        return image.getContentType().equals("image/jpeg");
    }


}
