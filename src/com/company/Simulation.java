package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    Simulation(){}

    public ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while(fileScanner.hasNextLine()){
            String str = fileScanner.nextLine();
            String [] arrOfStr = str.split("=");
            String name = arrOfStr[0];
            int weight = Integer.parseInt(arrOfStr[1]);
            items.add(new Item(name, weight));
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items){
        ArrayList<Rocket> listU1 = new ArrayList<>();
        listU1.add(new U1());
        int index = 0;
        for (Item item : items){
            if(listU1.get(index).canCarry(item)){
                listU1.get(index).carry(item);
            }
            else{
                listU1.add(new U1());
                index++;
                listU1.get(index).carry(item);
            }
        }
        return listU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> listU2 = new ArrayList<>();
        listU2.add(new U2());
        int index = 0;
        for (Item item : items){
            if(listU2.get(index).canCarry(item)){
                listU2.get(index).carry(item);
            }
            else{
                listU2.add(new U2());
                index++;
                listU2.get(index).carry(item);
            }
        }
        return listU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int budget = 0;
        for (Rocket rocket: rockets){
            boolean success = false;
            while(!success) {
                budget += rocket.getCost();
                if(rocket.launch() && rocket.land()){
                    success = true;
                }
            }
        }
        return budget;
    }
}
