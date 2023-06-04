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
public class Circle extends Shape{
    private double radius;
    
    /**
     * construct to create a circle with radius
     * @param radius radius to create a circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    
    /**
     * get area of circle equal radius*radius*PI
     * @return area circle
     */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * get perimeter of circle equal 2*radius*PI
     * 
     * @return perimeter of circle 
     */
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * print information of circle, radius, area, perimeter
     */
    @Override
    public void printResult() {
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    /**
     * circle of circle when user create
     * 
     * @return radius of circle
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
        
}
