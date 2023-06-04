/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.student;
import java.util.HashMap;
import java.util.List;
import util.validate;

/**
 *
 * @author HP
 */
public class manageStudentMark {
    
    /**
     * add student include information about name, class, math mark,
     * chemistry mark, chemistryMark, average mark, type of rank
     * 
     * @param listStudent is a List contain list student
     */
    public static void addStudentInfo(List<student> listStudent) {
     boolean continueCreate = true;
     while(continueCreate) {
     String name = validate.getString("Name: ", "No empty!");
     String className = validate.getString("Classes: ", "No empty!");
     double mathMark = validate.getDouble(
             "Maths: ",
             "Maths is greate than equal zero",
             "Maths less than equal ten",
             "Maths is digits", 0, 10);
     double chemistryMark = validate.getDouble(
             "Chemistry: ",
             "Chemistry is greate than equal zero",
             "Chemistry less than equal ten",
             "Chemistry is digits", 0, 10);
     
     double physicalMark = validate.getDouble(
             "Physics: ",
             "Physics is greate than equal zero",
             "Physics less than equal ten",
             "Physics is digits", 0, 10);
     double averageCaculate = (mathMark+chemistryMark+physicalMark)/3;
     double average = Math.floor(averageCaculate * 100) / 100;
     char type = getKindRank(average);
     student newStudent = new student(
             name, className, mathMark,
             physicalMark, chemistryMark, average,
             type);
     listStudent.add(newStudent);
     continueCreate = validate.checkYesNo(
             "Do you want to enter more student information?(Y/N):",
             "No empty!",
             "Invalid choice, you must choice ((Y, y) or (N, n)");
     }
    }
    
    /**
     * return kind of rank include A, B, C, D
     * 
     * @param average is average of all subject
     * @return kind of rank is character A, B, C or D
     */
    public static char getKindRank(double average) {
        if (average > 7.5) {
            return 'A';
        } else if (average >= 6 && average <= 7.5) {
            return 'B';
        } else if (average >= 4 && average < 6) {
            return 'C';
        } else {
            return 'D';
        }
    }
    
    /**
     * display information of list student include name, classes, average mark,
     * type rank
     * 
     * @param listStudent list student want to display information
     */
    public static void displayListStudent(List<student> listStudent) {
     for(int i=0; i<listStudent.size(); i++) {
         System.out.println("------ Student"+(i+1)+" Info ------");
         System.out.println("Name: "+listStudent.get(i).getName());
         System.out.println("Classes: "+listStudent.get(i).getClassName());
         System.out.println("AVG: "+listStudent.get(i).getAverage());
         System.out.println("Type: "+listStudent.get(i).getType());
     }
    }
    
    /**
     * create a list list type rank include A, B, C, D, calculate the ratio of 
     * that rank to all the students
     * 
     * @param listStudent is list contain student
     * @return a HashMap contain a couple key is type rank and percent
     * of this type rank
     */
    public static HashMap<String, Double> getTypeStatistit(
            List<student> listStudent
    ) {
        HashMap<String, Double> listStatistic = new HashMap<>();
        double numberTypeA = 0;
        double numberTypeB = 0;
        double numberTypeC = 0;
        double numberTypeD = 0;
        int numberStudent = listStudent.size();
        for (student currenStudent : listStudent) {
            if (currenStudent.getType() == 'A') {
                numberTypeA++;
            }
            if ((currenStudent.getType()) == 'B') {
                numberTypeB++;
            }
            if ((currenStudent.getType()) == 'C') {
                numberTypeC++;
            }
            if ((currenStudent.getType()) == 'D') {
                numberTypeD++;
            }
        }
        double percenTypeA = numberTypeA / numberStudent * 100;
        double percenTypeB = numberTypeB / numberStudent * 100;
        double percenTypeC = numberTypeC / numberStudent * 100;
        double percenTypeD = numberTypeD / numberStudent * 100;
        
        listStatistic.put("A", Math.floor(percenTypeA * 100) / 100);
        listStatistic.put("B", Math.floor(percenTypeB * 100) / 100);
        listStatistic.put("C", Math.floor(percenTypeC * 100) / 100);
        listStatistic.put("D", Math.floor(percenTypeD * 100) / 100);
        return listStatistic;
    }
    
    /**
     * display percent of all type rank include A, B, C, D
     * @param listStatistic list contain couple key is type rank and value if
     * percent of type rank 
     */
    public static void displayTypeStatistit(HashMap<String, Double> listStatistic) {
        listStatistic.keySet().forEach((key) -> {
            System.out.println(key+": "+listStatistic.get(key)+"%");
        });
    }
}
