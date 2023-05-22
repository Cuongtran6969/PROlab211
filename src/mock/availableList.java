/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import entity.Employee;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author HP
 */
public class availableList {
     private ArrayList<Employee> employeeList;
     /**
      * return avaliable list employee to test all function of program
      * @return 
      */
     public ArrayList availableList() {
     Employee employee1 = new Employee(1, "John", "Doe", "1234567890", "johndoe@example.com", "123 Main St, Anytown USA", new Date(), "Male", 50000.0, "ABC Agency");
     Employee employee2 = new Employee(2, "Jane", "Doe", "0987654321", "janedoe@example.com", "456 Oak St, Othertown USA", new Date(), "Female", 60000.0, "XYZ Agency");
     employeeList.add(employee1);
     employeeList.add(employee2);
     return employeeList;
     }
}
