package com.Vidoqui.Vidoqui;

import java.awt.*;

public class Hospital {
    private String name;
    private Point location;
    private double distance;

    public Hospital()
    {
        this.name = "";
        this.location = new Point(0,0);
        this.distance = 0;
    }

    public Hospital(String name, Point location) {
        this.name = name;
        this.location = location;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
