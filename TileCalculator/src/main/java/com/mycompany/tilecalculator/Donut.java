/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tilecalculator;

/**
 *
 * @author leo
 */
public class Donut extends Shape{

    @Override
    public double getArea() {
        return Math.PI*Math.pow(dimentionsList[0], 2)- Math.PI*Math.pow(dimentionsList[1], 2);
    }
    @Override
    public void setDimentionsList(double[] dimentionsList) {
        this.dimentionsList = dimentionsList;
    }
    
}
