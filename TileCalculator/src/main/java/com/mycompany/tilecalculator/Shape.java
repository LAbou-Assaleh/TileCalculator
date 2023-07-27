/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tilecalculator;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author leo
 */
public abstract class Shape {
    protected static double unitPrice;
    protected double[] dimentionsList;

    public double[] getDimentionsList() {
        return dimentionsList;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public abstract void setDimentionsList(double[] dimentionsList);

    public static void setUnitPrice(double newUnitPrice) {
        unitPrice = newUnitPrice;
    }
    
    public abstract double getArea();
    
    public double getPrice(){
        return getArea()*unitPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
