package com.ipolo.healthmonitor;

public class VitalSign {
    private int weight;
    private int steps;

    public VitalSign(int weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public int getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Вес: " + weight +
                ", Шагов: " + steps;
    }
}
