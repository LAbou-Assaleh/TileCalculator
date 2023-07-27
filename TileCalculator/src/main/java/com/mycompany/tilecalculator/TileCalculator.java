/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tilecalculator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leo
 */

/*
Class to run the main program and allow the user to calculate the area of a 
tiled floor made of diffrent shapes of their choosing.
*/
public class TileCalculator {
    // Define global variables.
    static ArrayList <Shape> tiles = new ArrayList <Shape>();
    static Scanner input = new Scanner(System.in);
    // Check if the input is an integer.
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Check if input is a double.
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Remove a shape from the arrayList tiles.
    public static void remove(){
        // Define local variables.
        String removed = "";
        int index = -1;
        // Check if the arrayList is empty
        if(tiles.size() == 0){
            System.out.println("There are no shapes to delete.");
            return;
        }
        // Ensure the user provides the correct input and remove the selected shape.
        while(index < 0 || index >= tiles.size()){
            removed = "";
            while(!isInteger(removed)){
                for(int i = 0; i < tiles.size(); i++){
                    System.out.println(i + ": " + tiles.get(i).toString());
                }
                removed = input.nextLine();
            }
            index = Integer.parseInt(removed);
            if(index >= 0 && index < tiles.size()){
                tiles.remove(index);
                return;
            }
        }
    }
    // List shapes in arrayList tiles.
    public static void list(){
        for(int i = 0; i < tiles.size(); i++){
           System.out.println(tiles.get(i).toString());
        }
    }
    // Add shapes to arrayList tiles.
    public static void add(){
        // Define local variables.
        double addition;
        String values = "";
        double[] dimensions = new double[2];
        String choice = "";
        // Check for correct input and add the selected shape.
        while(!isDouble(choice)){
            System.out.println("""
                               Which shape would you like to create
                               1: Triangle
                               2: Rectangle
                               3: Circle
                               4: Donut
                               5: Kite
                               6: Parallelogram
                               7: Dodecagon""");
            choice = input.nextLine();
        }
        addition = Integer.parseInt(choice);
        if(addition == 1){
            Triangle triangle = new Triangle();
            while(!isDouble(values)){
                System.out.println("Enter the base of the triangle.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            values = "";
            while(!isDouble(values)){
                System.out.println("Enter the height of the triangle.");
                values = input.nextLine();
            }
            dimensions[1] = Double.parseDouble(values);
            triangle.setDimentionsList(dimensions);
            tiles.add(triangle);
        }
        if(addition == 2){
            Rectangle rect = new Rectangle();
            while(!isDouble(values)){
                System.out.println("Enter the height of the rectangle.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            values = "";
            while(!isDouble(values)){
                System.out.println("Enter the width of the rectangle.");
                values = input.nextLine();
            }
            dimensions[1] = Double.parseDouble(values);
            rect.setDimentionsList(dimensions);
            tiles.add(rect);
        }
        if(addition == 3){
            Circle circle = new Circle();
            while(!isDouble(values)){
                System.out.println("Enter the radius of the circle.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);        
            circle.setDimentionsList(dimensions);
            tiles.add(circle);
        }
        if(addition == 4){
            Donut donut = new Donut();
            while(!isDouble(values)){
                System.out.println("Enter the radius of the outer ring of the donut.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            values = "";
            while(!isDouble(values)){
                System.out.println("Enter the width of the inner circle of the donut.");
                values = input.nextLine();
            }
            dimensions[1] = Double.parseDouble(values);
            donut.setDimentionsList(dimensions);
            tiles.add(donut);
            
        }
        if(addition == 5){
            Kite kite = new Kite();
            while(!isDouble(values)){
                System.out.println("Enter the length of one of the diagonals of the kite.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            values = "";
            while(!isDouble(values)){
                System.out.println("Enter the length of the other diagonal of the kite.");
                values = input.nextLine();
            }
            dimensions[1] = Double.parseDouble(values);
            kite.setDimentionsList(dimensions);
            tiles.add(kite);
        }
        if(addition == 6){
            Parallelogram parallelogram = new Parallelogram();
            while(!isDouble(values)){
                System.out.println("Enter the height of the parallelogram.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            values = "";
            while(!isDouble(values)){
                System.out.println("Enter the base of the parallelogram.");
                values = input.nextLine();
            }
            dimensions[1] = Double.parseDouble(values);
            parallelogram.setDimentionsList(dimensions);
            tiles.add(parallelogram);
        }
        if(addition == 7){
           Dodecagon dodeca = new Dodecagon(); 
           while(!isDouble(values)){
                System.out.println("Enter the side length of the dodecagon.");
                values = input.nextLine();
            }
            dimensions[0] = Double.parseDouble(values);
            dodeca.setDimentionsList(dimensions);
            tiles.add(dodeca);
        }
    }
    // Calculate the totalCost based on the area of the shapes in arrayList tiles and the unit price.
    public static double totalCost(){
        // Define local variables.
        double total = 0.0;
        for(Shape i: tiles){
            total += i.getPrice();
        }
        return total;
    }
    // Calculate the totalArea based on the area of the shapes in arrayList.
    public static double totalArea(){
        // Define local variables.
        double total = 0.0;
        for(Shape i: tiles){
            total += i.getArea();
        }
        return total;
    }
    // Clear the console/
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    // Create the menu and run the program.
    public static void main(String[] args) {
        // Define local variables.
        String action = "";
        String unit = "";
        // Check for correct input and perform the selected function.
        // Periodicaly clean the console.
        while(!isDouble(unit)){
            System.out.println("What is the price per square unit");
            unit = input.nextLine();
        }
        Shape.setUnitPrice(Double.parseDouble(unit));
        while(!action.equals("8")){
            System.out.println("""
                               1: Create a new shape
                               2: Delete an existing shape
                               3: Display a list of existing shapes with details of each shape
                               4: Enter the price per square unit
                               5: Calculate the total cost of the floor
                               6: Calculate the total area of the floor
                               7: Clear the the list of shapes
                               8: Exit the program""");
            action = input.nextLine();
            clearConsole();  
            if(action.equals("1")){
                add();
            }
            if(action.equals("2")){
                remove();
            }
            if(action.equals("3")){
                list();
            }
            if(action.equals("4")){
                unit = "";
                while(!isDouble(unit)){
                    System.out.println("What is the price per square unit");
                    unit = input.nextLine();
                }
                Shape.setUnitPrice(Double.parseDouble(unit));
            }
            if(action.equals("5")){
                System.out.println(totalCost());
            }
            if(action.equals("6")){
                System.out.println(totalArea());
            }
            if(action.equals("7")){
                tiles.clear();
            }
            if(action.equals("8")){
                break;
            }
        }
        
    }
}

