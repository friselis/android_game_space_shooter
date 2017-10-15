package com.geek.spaceshooter.game;


public class LevelInfo {
    private int level;
    private float asteroidGenerationTime;
    private int asteroidHpMin;
    private int asteroidHpMax;
    private float asteroidSpeedMin;
    private float asteroidSpeedMax;
    private float botGenerationTime;

    public int getLevel() {
        return level;
    }

    public float getAsteroidGenerationTime() {
        return asteroidGenerationTime;
    }

    public int getAsteroidHpMin() {
        return asteroidHpMin;
    }

    public int getAsteroidHpMax() {
        return asteroidHpMax;
    }

    public float getAsteroidSpeedMin() {
        return asteroidSpeedMin;
    }

    public float getAsteroidSpeedMax() {
        return asteroidSpeedMax;
    }

    public float getBotGenerationTime() {
        return botGenerationTime;
    }

    public LevelInfo(int level, float asteroidGenerationTime, int asteroidHpMin, int asteroidHpMax, float asteroidSpeedMin, float asteroidSpeedMax, float botGenerationTime) {
        this.level = level;
        this.asteroidGenerationTime = asteroidGenerationTime;
        this.asteroidHpMin = asteroidHpMin;
        this.asteroidHpMax = asteroidHpMax;
        this.asteroidSpeedMin = asteroidSpeedMin;
        this.asteroidSpeedMax = asteroidSpeedMax;
        this.botGenerationTime = botGenerationTime;
    }
}
