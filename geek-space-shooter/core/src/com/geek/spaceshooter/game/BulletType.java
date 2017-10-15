package com.geek.spaceshooter.game;


public enum BulletType {
    FIREBALL(0), GREENRAY(1);

    private int index;

    public int getIndex() {
        return index;
    }

    BulletType(int index) {
        this.index = index;
    }
}
