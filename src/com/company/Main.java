package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Simulation simulation = new Simulation();
        ArrayList<Item> phase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("phase-2.txt");
        int budget = 0;
        int budget_2 = 0;
        int simulationTime = 10;

        for (int i=0; i<simulationTime; i++) {
            ArrayList<Rocket> fleetU1 = simulation.loadU1(phase1);
            System.out.println("Number of U1 rockets for phase 1: " + fleetU1.size());
            budget += simulation.runSimulation(fleetU1);
            System.out.println("budget for phase 1 of U1: " + budget);


            ArrayList<Rocket> fleetU2 = simulation.loadU2(phase1);
            System.out.println("\nNumber of U2 rockets for phase 1: " + fleetU2.size());
            budget_2 += simulation.runSimulation(fleetU2);
            System.out.println("budget for phase 1 of U2: " + budget_2);

            ArrayList<Rocket> fleetU1phase2 = simulation.loadU1(phase2);
            System.out.println("\nNumber of U1 rockets for phase 2: " + fleetU1phase2.size());
            budget += simulation.runSimulation(fleetU1phase2);

            ArrayList<Rocket> fleetU2phase2 = simulation.loadU2(phase2);
            System.out.println("Number of U2 rockets for phase 2: " + fleetU2phase2.size());
            budget_2 += simulation.runSimulation(fleetU2phase2);

        }

        System.out.println("\n\nTotal budget for U1: " + (double)budget/simulationTime);
        System.out.println("Total budget for U2: " + (double)budget_2/simulationTime);
    }
}
