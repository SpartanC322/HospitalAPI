package com.Vidoqui.Vidoqui;

import java.awt.*;

public class Ambulance {
    private Point location;

    public Ambulance()
    {
        this.location = new Point(0,0);
    }

    public Ambulance(Point location)
    {
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
