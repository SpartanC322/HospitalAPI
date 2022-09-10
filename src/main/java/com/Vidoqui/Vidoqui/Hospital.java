package com.Vidoqui.Vidoqui;

import java.awt.*;

public class Hospital {
    private String name;
    private Point location;

    public Hospital(String name, int x, int y) {
        this.name = name;
        this.location = new Point(x, y);
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
}