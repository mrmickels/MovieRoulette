package com.filmroulette.service;

import com.filmroulette.dao.IImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// This class isn't needed, just using as a test class to only display images
public class ImageService implements IImageService {
    @Autowired
    IImageDAO imageDAO;

    @Override
    public byte[] fetchImage() throws Exception{

        // Switch between (image/image2) in byte array to do either a static URL request or manual request
        String image = imageDAO.getImage("udDclJoHjfjb8Ekgsd4FDteOkCU.jpg");
        String image2 = imageDAO.getImage();

        byte[] result = image.getBytes();
        return result;

    }
}
