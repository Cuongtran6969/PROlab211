/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Iconstant;
import entity.Employee;
import java.util.ArrayList;
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
     * empty ArrayList as the initial list of employees
     */
    public EmployeeManagement() {
        this.employeeList = new ArrayList<>();
    }

    /**
     * add new employee to list employee, create variable is properties of
     * employee, each variable check valid value input after all value valid
     * will create new employee have all this properties and add new employee to
     * the employee list
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
        Date dob = getValidInput.getDate(
                "Enter DOB: ",
                "DOB invalid",
                "dd/MM/yyyy"
        );
        String sex = getValidInput.getStringByRegex(
                "Enter sex: ",
                "Sex invalid",
                "^(male|female)$"
        );
        double salary = getValidInput.getDouble(
                "Enter salary: ",
                "Salary invalid",
                0, Double.MAX_VALUE);
        String agency = getValidInput.getString(
                "Enter agency: ",
                "Agency invalid"
        );
        Employee employee = new Employee(
                ID, firstName, lastName, phone,
                email, address, dob, sex,
                salary, agency);
        employeeList.add(employee);
    }

    /**
     * User input ID and get employee have this ID and access input new value
     * to set new value of all properties for employee
     */
    public void updateEmployee() {
        if (employeeList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        int Id = getValidInput.getInt(
                "Enter Id: ",
                "Id out of range: ",
                "Invalid id",
                1, Integer.MAX_VALUE);
        if (getIndexOfId(Id) == -1) {
            System.err.println("Employee ID not found");
            return;
        }
        System.out.println("Enter new information of Employee");
        Employee employee = employeeList.get(getIndexOfId(Id));
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
     * check employee Id have in list, if have in list will remove this employee
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
     * find an employee by first name or last name or a part of name,
     * if have in list will print this employee to screen else will print not
     * found
     */
    public void searchEmployee() {
        if (employeeList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        String nameSearch = getValidInput.getString(
                "Enter search name: ",
                "Name invalide");
        int count = 0;
        for (Employee employee : employeeList) {
            String fullName;
            fullName = employee.getFirstName() + " " + employee.getLastName();
            if (fullName.contains(nameSearch)) {
                if (count == 0) {
                    displayFormat();
                }
                System.out.println(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No found this student");
        }
    }
    
    /**
     * Sort list employee follow Salary and type sort
     * 
     * @param TYPE_SORT the type sort can ascending or descending
     */
    public void sortListEmployee(final String TYPE_SORT) {
        if (employeeList.isEmpty()) {
            System.err.println("Empty list");
            return;
        }
        switch (TYPE_SORT) {
            case Iconstant.ASC:
                Collections.sort(employeeList, (
                  Employee employee1, Employee employee2)
                  -> (int) employee1.getSalary() - (int) employee2.getSalary());
                break;
            case Iconstant.DESC:
                Collections.sort(employeeList, (
                  Employee employee1, Employee employee2)
                  -> (int) employee2.getSalary() - (int) employee1.getSalary());
                break;
        }

    }

    /**
     * Print properties accord format with number of space
     */
    public void displayFormat() {
        System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-10s%-15s%-15s\n"
                ,"id", "firstName", "lastName", "lastName", "phone", "email",
                "address", "dob", "sex", "salary", "agency");
    }

    /**
     * return index occur Id, if don't find will return -1
     *
     * @param Id to check Id have in list
     * @return index if found else return -1 if not found
     */
    public int getIndexOfId(int Id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == Id) {
                return i;
            }
        }
        return -1;
    }
    
}
