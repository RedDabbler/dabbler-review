package com.redDabbler.review.pattern.strategy.compare;

public class Dog implements Comparable<Dog> {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Dog dog) {
        return this.getHeight() - dog.getHeight();
    }
}
