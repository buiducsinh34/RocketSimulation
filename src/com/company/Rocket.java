package com.company;

public class Rocket implements SpaceShip{
    private int loadWeight;
    private int maxWeight;
    private int cost;
    private int weight;
    private double launchExplosionRate;
    private double landExplosionRate;

    Rocket(){}
    Rocket(int cost, int weight, int maxWeight, double launchExplosionRate, double landExplosionRate){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.launchExplosionRate = launchExplosionRate;
        this.landExplosionRate = landExplosionRate;
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight = loadWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getLaunchExplosionRate() {
        return launchExplosionRate;
    }

    public void setLaunchExplosionRate(double launchExplosionRate) {
        this.launchExplosionRate = launchExplosionRate;
    }

    public double getLandExplosionRate() {
        return landExplosionRate;
    }

    public void setLandExplosionRate(double landExplosionRate) {
        this.landExplosionRate = landExplosionRate;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.getWeight() + loadWeight + weight <= maxWeight){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void carry(Item item) {
            this.setLoadWeight(this.getLoadWeight()+item.getWeight());
    }
}
