package com.filmroulette.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;

public class ImageDTO extends InputStream {
    @SerializedName("image")
    @Expose
    private String imageString;

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
