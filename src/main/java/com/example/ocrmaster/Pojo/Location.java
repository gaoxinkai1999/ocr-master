package com.example.ocrmaster.Pojo;

import org.springframework.stereotype.Component;

@Component
public class Location {
    public int X;
    public int Y;
    public int Width;
    public int Height;

    @Override
    public String toString() {
        return "Location{" +
                "X=" + X +
                ", Y=" + Y +
                ", Width=" + Width +
                ", Height=" + Height +
                '}';
    }
}
