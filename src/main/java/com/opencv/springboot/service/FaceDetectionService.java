package com.opencv.springboot.service;

import com.opencv.springboot.entity.FaceEntity;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frkn on 16/01/2017.
 */

@Service
public class FaceDetectionService {


    private Resource faceResource = new ClassPathResource("haarcascades/haarcascade_frontalface_alt.xml");

    private List<FaceEntity> faceEntities;
    private Mat image;

    public FaceDetectionService detectFace(MultipartFile file) throws IOException {

        faceEntities=new ArrayList<>();
        MatOfRect faceDetections = new MatOfRect();
        CascadeClassifier faceDetector = new CascadeClassifier(faceResource.getFile().getAbsolutePath());


        image = Imgcodecs.imdecode(new MatOfByte(file.getBytes()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        for (Rect rect : faceDetections.toArray()) {
            faceEntities.add(new FaceEntity(rect.x, rect.y, rect.width, rect.height, 0));
        }

        return this;
    }

    public List<FaceEntity> toList() {
        return faceEntities;
    }


    public byte[] toImage() {
        for (FaceEntity fc : faceEntities) {
            Imgproc.rectangle(image, new Point(fc.getX(), fc.getY()), new Point(fc.getX() + fc.getWidth(), fc.getY() + fc.getHeight()), new Scalar(0, 255, 0));
        }
        return mat2Image(image);
    }

    private byte[] mat2Image(Mat frame) {
        MatOfByte buffer = new MatOfByte();
        Imgcodecs.imencode(".jpg", frame, buffer);
        return buffer.toArray();
    }
}
