/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import bo.StudentManager;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====== Collection Sort Program ======");
        System.out.println("Please input student information ");
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent();
        studentManager.printListStudent();
        System.out.println("Student list sorted Student by name from A - Z");
        studentManager.sortStudentAlphabet();
        studentManager.printListStudent();
    }
}
