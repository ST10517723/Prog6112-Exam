/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    private String[] productNames;
    private int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }
// Here we are simply overriding everymethod from IProduct interface class and adding necessary loops for code efficiency
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }
// Here we are simply overriding everymethod from IProduct interface class and adding necessary loops for code efficiency
    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count += sales[i].length;
        }
        return (double) GetTotalProductsSold() / count;
    }
// Overriding methods and adding lopops
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = 0;
        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > bestTotal) {
                bestTotal = productTotal;
                bestIndex = i;
            }
        }
        int bestMonth = 0;
        for (int j = 0; j < sales[bestIndex].length; j++) {
            if (sales[bestIndex][j] > bestMonth) {
                bestMonth = sales[bestIndex][j];
            }
        }
        return productNames[bestIndex] + "(" + bestMonth + ")";
    }
}