/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.Shape;

/**
 *
 * @author HP
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    
    /**
     * construct create a triangle with three side
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * get area of triangle by Heron's formula
     * @return area of triangle
     */
    @Override
    public double getArea() {
        double P = (a+b+c)/2;
        return Math.sqrt(P*(P-a)*(P-b)*(P-c));
    }

    /**
     * get perimeter of triangle by sum three side
     * @return perimeter of triangle
     */
    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    /**
     * print information of triangle include value of three side,
     * area, perimeter
     */
    @Override
    public void printResult() {
        System.out.println("Side A: " + this.a);
        System.out.println("Side A: " + this.b);
        System.out.println("Side A: " + this.c);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
    
    
    
    
    
    
}
