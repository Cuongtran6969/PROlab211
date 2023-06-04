/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HP
 */
public class student {
    String name;
    String className;
    double mathMark, physicalMark, chemistryMark;
    double average;
    char type;

    public student(
            String name, String className, double mathMark,
            double physicalMark, double chemistryMark, double average,
            char type) {
        this.name = name;
        this.className = className;
        this.mathMark = mathMark;
        this.physicalMark = physicalMark;
        this.chemistryMark = chemistryMark;
        this.average = average;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicalMark() {
        return physicalMark;
    }

    public void setPhysicalMark(double physicalMark) {
        this.physicalMark = physicalMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
