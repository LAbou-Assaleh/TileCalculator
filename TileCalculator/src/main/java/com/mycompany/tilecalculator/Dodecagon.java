/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tilecalculator;

/**
 *
 * @author leo
 */
public class Dodecagon extends Shape{

    @Override
    public double getArea() {
        return 3*Math.pow(dimentionsList[0], 2)*(2+ Math.sqrt(3));
    }
    @Override
    public void setDimentionsList(double[] dimentionsList) {
        this.dimentionsList = dimentionsList;
    }
    
}
