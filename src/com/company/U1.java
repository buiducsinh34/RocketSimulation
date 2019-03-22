package com.company;

public class U1 extends Rocket {

    U1(){
        super(100, 10000, 18000, 0.05, 0.01);
    }

    private int loadLimit = super.getMaxWeight() - super.getWeight();

    @Override
    public boolean launch() {
        if (Math.random()<super.getLaunchExplosionRate()*((double)super.getLoadWeight()/(double)loadLimit)){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean land() {
        if (Math.random()<super.getLandExplosionRate()*((double)super.getLoadWeight()/(double)loadLimit)){
            return false;
        }
        else{
            return true;
        }
    }
}
