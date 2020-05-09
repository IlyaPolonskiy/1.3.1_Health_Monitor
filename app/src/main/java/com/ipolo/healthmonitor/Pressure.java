package com.ipolo.healthmonitor;

import java.util.Date;

public class Pressure {
    private int topPressure;
    private int lowPressure;
    private int heartRate;
    private boolean tachycardia;
    private Date measureTime;

    public Pressure(int topPressure, int lowPressure, int heartRate, boolean tachycardia, Date measureTime) {
        this.topPressure = topPressure;
        this.lowPressure = lowPressure;
        this.heartRate = heartRate;
        this.tachycardia = tachycardia;
        this.measureTime = measureTime;
    }

    public int getTopPressure() {
        return topPressure;
    }

    public int getLowPressure() {
        return lowPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    @Override
    public String toString() {
        return "Давление: " +
                "верхнее - " + topPressure +
                ", нижнее - " + lowPressure +
                ", пульс - " + heartRate +
                ", тахикардия: " + tachycardia +
                ", Время: " + measureTime;
    }
}
