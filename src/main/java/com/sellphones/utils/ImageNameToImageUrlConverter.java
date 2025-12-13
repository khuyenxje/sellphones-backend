package com.sellphones.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageNameToImageUrlConverter {

    private static String baseUrl;

    @Value("${app.base-url}")
    public void setBaseUrl(String url) {
        baseUrl = url;
    }

    public static List<String> convertAll(List<String> imageNames, String folderName){
        return imageNames.stream()
                .map(in -> baseUrl + "/uploads/" + folderName + "/" + in)
                .toList();
    }

    public static String convert(String imageName, String folderName){
        return baseUrl + folderName + "/" + imageName;
    }
}

