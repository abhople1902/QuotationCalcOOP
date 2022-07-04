/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ta2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author DELL
 */
public class Duplex {
    String cityName;
    int tier;
    long plotSize;
    BufferedReader in;
    int days = 30;
    String s[];
    double BmachCost;
    double LabourCost;
    double MaterialCost;
    double FinishingCost;
    double ResourcesCost;
    Duplex(String cityName,int tier,long plotSize,FileReader f){
        this.in = new BufferedReader(f);
        this.cityName = cityName;
        this.tier = tier;
        this.plotSize = plotSize;
    }
    void getInfo(){
        System.out.println("Ciry Name: " + this.cityName + "\n" + "Tier: " + this.tier + "\n" + "Plot Size" + this.plotSize);
    }
    String str;
    
    void extractCosts() throws IOException,Exception{
        try{
            while((str = in.readLine())!=null){
                s = str.split("    ");
                if(s[0].equals(this.cityName) && "Duplex".equals(s[7])){     
                this.BmachCost = Double.parseDouble(s[1]);
                this.FinishingCost = Double.parseDouble(s[2]);
                this.LabourCost = Double.parseDouble(s[3]);
                this.MaterialCost = Double.parseDouble(s[4]);
                }
            }
        }catch(IOException | NumberFormatException e){
            System.out.println(e);
        }
    }
    
    void calculatecosts(){
        this.BmachCost = this.BmachCost*this.days;
        this.FinishingCost = this.FinishingCost*this.days;
        this.LabourCost = this.LabourCost*this.days*Double.parseDouble(s[5]);
        this.MaterialCost = this.MaterialCost*this.days*Double.parseDouble(s[6]);
        this.ResourcesCost = this.ResourcesCost*this.days;
}
    
    long totalEstimate(){
        long total;
        calculatecosts();
        System.out.println("Type of house: " + "Duplex");
        System.out.println("Location: " + this.cityName);
        System.out.println("Plot size: " + this.plotSize);
        System.out.println("Basic machinary cost: "+ this.BmachCost);
        System.out.println("Total Finishing cost: " + this.FinishingCost);
        System.out.println("Total Labour cost: " + this.LabourCost);
        System.out.println("Total Material Cost: " + this.MaterialCost);
        System.out.println("Total resource cost: " + this.ResourcesCost);
        total = (long) (this.BmachCost+ this.FinishingCost + this.LabourCost + this.MaterialCost + this.ResourcesCost);
        return total;
    }
}
