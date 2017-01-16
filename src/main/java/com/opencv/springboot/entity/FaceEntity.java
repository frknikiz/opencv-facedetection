package com.opencv.springboot.entity;

/**
 * Created by frkn on 16/01/2017.
 */
public class FaceEntity {
    private int x;
    private int y;
    private int width;
    private int height;
    private double ratio;

    public FaceEntity(int x, int y, int width, int height, double ratio) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ratio = ratio;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
