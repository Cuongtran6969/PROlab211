/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Employee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import util.getValidInput;

/**
 *
 * @author HP
 */
public class EmployeeManagement {
    final ArrayList<Employee> employeeList;

    /**
     * instantiate a new object of class EmployeeManagement with an 
     * empty ArrayList as the initial list of employees.
     */
    public EmployeeManagement() {
        this.employeeList = new ArrayList<>();
    }
    
    /**
     * add new employee to list employee, create variable is properties of 
     * employee, each variable check valid value input 
     * after all value valid will create new employee have all this properties
     * and add new employee to the employee list
     */
    public void addNewEmployee() {
        int ID;
        while (true) {
            ID = getValidInput.getInt(
                    "Enter Id: ",
                    "Id out of range: ",
                    "Invalid id",
                    1, Integer.MAX_VALUE);
            if (getIndexOfId(ID) == -1) {
                break;
            } else {
                System.err.println("ID duplicated");
            }
        }
        String firstName = getValidInput.getString(
                "Enter first name: ",
                "Full name is not valid"
        );
        String lastName = getValidInput.getString(
                "Enter last name: ",
                "Full name is not valid"
        );
        String phone = getValidInput.getStringByRegex(
                "Enter phone number: ",
                "Phone number invalid",
                "^0\\d{9}$"
        );
                
        String email = getValidInput.getStringByRegex(
                "Enter email: ",
                "Email invalid",
                "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$"
        );
        String address = getValidInput.getString(
                "Enter Address: ",
                "Invalid Address"
        );
        Date dob = getValidInput.getDate("Enter DOB: ", "DOB invalid", "dd/MM/yyyy");
        String sex = getValidInput.getStringByRegex("Enter sex: ", "Sex invalid", "^(male|female)$");
        double salary = getValidInput.getDouble("Enter salary: ", "Salary invalid", 0, Double.MAX_VALUE);
        String agency = getValidInput.getString("Enter agency: ", "Agency invalid");
        Employee employee = new Employee(ID, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        employeeList.add(employee);
    }

    /**
     * User input ID and get employee have this ID and access input new value of all properties
     * of this employee and set new value for employee
     */
    public void updateEmployee() {
      if(employeeList.isEmpty()) {
          System.err.println("Empty list");
          return;
      }
      int Id =  getValidInput.getInt(
                    "Enter Id: ",
                    "Id out of range: ",
                    "Invalid id",
                    1, Integer.MAX_VALUE);
      if(getIndexOfId(Id)==-1) {
          System.err.println("Employee ID not found");
          return ;
      }
        System.out.println("Enter new information of Employee");
        
        Employee employee = employeeList.get(getIndexOfId(Id));
        //input new id if id duplaicate will throw message and input util not
        //duplicate
        String firstName = getValidInput.getString(
                "Enter first name: ",
                "Full name is not valid"
        );
        String lastName = getValidInput.getString(
                "Enter last name: ",
                "Full name is not valid"
        );
        String phone = getValidInput.getStringByRegex(
                "Enter phone number: ",
                "Phone number invalid",
                "^0\\d{9}$"
        );
                
        String email = getValidInput.getStringByRegex(
                "Enter email: ",
                "Email invalid",
                "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$"
        );
        String address = getValidInput.getString(
                "Enter Address: ",
                "Invalid Address"
        );
        Date dob = getValidInput.getDate("Enter DOB: ", "DOB invalid", "dd/MM/yyyy");
        String sex = getValidInput.getStringByRegex("Enter sex: ", "Sex invalid", "^(male|female)$");
        double salary = getValidInput.getDouble("Enter salary: ", "Salary invalid", 0, Double.MAX_VALUE);
        String agency = getValidInput.getString("Enter agency: ", "Agency invalid");
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setDob(dob);
        employee.setSex(sex);
        employee.setSalary(salary);
        employee.setAgency(agency);
        System.out.println("Employee has update done");
    }
    
    /**
     * remove employee by Id, user input Id , use method get index of Id and 
     * remove employee in list by this index
     */
    public void removeEmployee() {
      if(employeeList.isEmpty()) {
          System.err.println("Empty list");
          return;
      }
      int Id =  getValidInput.getInt(
                    "Enter Id need remove: ",
                    "Id out of range: ",
                    "Invalid id",
                    1, Integer.MAX_VALUE);
      if(getIndexOfId(Id)==-1) {
          System.err.println("Employee ID not found");
          return ;
      }
      int indexOfId = getIndexOfId(Id);
      employeeList.remove(indexOfId);
      System.out.println("Employee has been removed");
    }
    
    /**
     * find an employee by Name (First Name or Last Name) or a part of name.
     */
    public void searchEmployee() {
      String nameSearch = getValidInput.getString(
              "Enter search name: ",
              "Name invalide");
      int count = 0;
      for(Employee employee : employeeList) {
        String fullName = employee.getFirstName()+" "+employee.getLastName();
        if(fullName.contains(nameSearch)) {
            if(count==0) {
                displayFormat();
            }
            System.out.println(employee);
            count++;
        }
      } 
      if(count==0) {
          System.out.println("No found this student");
      }
     }
    
    /**
     * Sort list employee follow Salary
     */
    public void sortListEmployee() {
      if(employeeList.isEmpty()) {
          System.err.println("Empty list");
          return;
      }
      for(int i=0; i<employeeList.size()-1; i++) {
       for(int j=i+1; j<employeeList.size(); j++) {
         if(employeeList.get(i).getSalary()>employeeList.get(j).getSalary()) {
          Employee employeeTemp = employeeList.get(i);
          employeeList.set(i, employeeList.get(j));
          employeeList.set(j, employeeTemp);
         }
       }
      }
    } 
    
    /**
     * Print properties accord format with number of space
     */
    public void displayFormat() {
     System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-10s%-15s%-15s\n",
            "id", "firstName", "lastName", "lastName", "phone", "email", "address", "dob", "sex", "salary", "agency");
     }
    
    /**
     * return index occur Id, if don't find will return -1
     * @param Id
     * @return 
     */
    public int getIndexOfId(int Id) {
      for(int i=0; i<employeeList.size(); i++) {
        if(employeeList.get(i).getId()== Id) {
          return i;
        }
      }
      return -1;
    }
    
}
