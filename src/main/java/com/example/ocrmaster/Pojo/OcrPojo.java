package com.example.ocrmaster.Pojo;

import org.springframework.stereotype.Component;

@Component
public class OcrPojo {
    public String DetectedText;
    public Location ItemPolygon;

    @Override
    public String toString() {
        return "OcrPojo{" +
                "DetectedText='" + DetectedText + '\'' +
                ", ItemPolygon=" + ItemPolygon +
                '}';
    }
}
