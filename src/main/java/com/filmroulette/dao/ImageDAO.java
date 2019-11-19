package com.filmroulette.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Base64;

@Component
public class ImageDAO implements IImageDAO {

    @Autowired
    private NetworkDAO networkDAO;

    // Changeable URL
    public String getImage(String img) throws Exception {
        URL url = networkDAO.requestImage(img);
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        String encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        return encodedImage;
    }

    // Static URL for testing purposes
    public String getImage() throws Exception{
        // Image sizes available: w92, w154, w185, w342, w500, w780, original
        URL url = new URL("http://image.tmdb.org/t/p/w185/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg");
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        String encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        return encodedImage;
    }
}

