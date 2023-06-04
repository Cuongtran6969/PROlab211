/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import logic.manageStudentMark;
/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args) {
        System.out.println("====== Management Student Program ======");
        List<student> listStudent = new ArrayList<>();
        manageStudentMark.addStudentInfo(listStudent);
        manageStudentMark.displayListStudent(listStudent);
        HashMap<String,Double> listStatistic;
        listStatistic = manageStudentMark.getTypeStatistit(listStudent);
        System.out.println("--------Classification Info -----");
        manageStudentMark.displayTypeStatistit(listStatistic);
    }
}
