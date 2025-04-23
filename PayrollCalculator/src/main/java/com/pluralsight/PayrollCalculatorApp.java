package com.pluralsight;

import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

public class PayrollCalculatorApp {
    private static final String PATH = "DataFiles/";
    private static final String FILE_NAME = "employees.csv";


    public static void main(String[] args) {
        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH + FILE_NAME);
        List<Employee> employeeList = getEmployeeList(fileReaderUtils);
        printEmployeeList(employeeList);
    }

    private static List<Employee> getEmployeeList(FileReaderUtils fileReaderUtils) {
        String header = fileReaderUtils.readLine(); // skip header
        List<Employee> employees = new LinkedList<>();
        while (true){
            String line = fileReaderUtils.readLine();
            if (line == null)
                break;
            employees.add(new Employee(line));
        }
        return employees;
    }

    private static void printEmployeeList(List<Employee> employeeList){
        System.out.println("-".repeat(150));
        for (var e : employeeList) {
            System.out.println(e);
            System.out.println("-".repeat(150));
        }
    }
}