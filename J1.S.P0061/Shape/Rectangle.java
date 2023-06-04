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
public class Rectangle extends Shape {
    private double width;
    private double length;

    /**
     * create a rectangle by width and length
     * 
     * @param width  width of rectangle
     * @param length length of rectangle
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * get area of rectangle equal width * length
     * @return area rectangle
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * get perimeter of rectangle equal (width + length)*2
     * 
     * @return perimeter of rectangle 
     */
    @Override
    public double getPerimeter() {
        return (width + length)*2;
    }

    /**
     * print information of rectangle include value of Width,
     * Length, Area, perimeter
     */
    @Override
    public void printResult() {
        System.out.println("Width: " + this.width);
        System.out.println("Length: " + this.length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
    
}
