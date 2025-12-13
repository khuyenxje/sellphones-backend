package com.sellphones.utils;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@ConfigurationProperties(prefix = "spring.backend")
public class ImageNameToImageUrlConverter {

    private static String url;

    public static List<String> convertAll(List<String> imageNames, String folderName){
        return imageNames.stream()
                .map(in -> url + "/uploads/" + folderName + "/" + in)
                .toList();
    }

    public static String convert(String imageName, String folderName){
        return url + folderName + "/" + imageName;
    }
}

