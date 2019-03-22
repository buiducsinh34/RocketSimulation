package com.company;

public class U2 extends Rocket{
    U2(){
        super(120, 18000, 29000, 0.04, 0.08);
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
