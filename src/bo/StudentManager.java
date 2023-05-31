/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;
import java.util.ArrayList;
import entity.Student;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import util.Validate;
/**
 *
 * @author HP
 */
public class StudentManager {

    final ArrayList<Student> listStudent;

    public StudentManager() {
        this.listStudent = new ArrayList<>();
    }
    final static Scanner SCANNER = new Scanner(System.in);

    public void addStudent() {
        boolean continueChoice = true;
        while (continueChoice) {
            String name = Validate.getValidString(
                    "Name: ",
                    "Invalid Name, please input again!");
            String classes = Validate.getValidString(
                    "Classes: ",
                    "Invalid Class, please input again!");
            float mark = Validate.getFloat(
                    "Mark: ",
                    "Mark out of range!",
                    "Invalid mark",
                    0, 100);
            Student newStudent = new Student(name, mark, classes);
            listStudent.add(newStudent);
            continueChoice = Validate.getUserYesNoChoice(
                    "Do you want to enter more student information?(Y/N): ",
                    "Invalid choice!");
        }
    }

    public void printListStudent() {
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println("-------------Student " + (i + 1) + "-------------");
            System.out.println("Name: " + listStudent.get(i).getName());
            System.out.println("Classes: " + listStudent.get(i).getClasses());
            System.out.println("Mark: " + listStudent.get(i).getMark());
        }
    }

    public void sortStudentAlphabet() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }
}
