package com.pluralsight;

import com.pluralsight.domain.Employee;
import com.pluralsight.utils.FileReaderUtils;
import com.pluralsight.utils.FileWriterUtils;

import java.util.LinkedList;
import java.util.List;

public class PayrollCalculatorApp {
    private static final String PATH_OF_SOURCE = "DataFiles/";
    private static final String EMPLOYEES_SOURCE = "employees.csv";
    private static final String EMPLOYEES_DESTINATION = "employees_gross_pay.cvs";
    private static final String PATH_OF_DESTINATION = "output/";


    public static void main(String[] args) {
        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH_OF_SOURCE + EMPLOYEES_SOURCE);
        List<Employee> employeeList = getEmployeeList(fileReaderUtils);
        printEmployeeList(employeeList);
        writeEmployeeListInCvsFile(employeeList);
    }

    private static List<Employee> getEmployeeList(FileReaderUtils fileReaderUtils) {
        String header = fileReaderUtils.readLine(); // skip header
        List<Employee> employees = new LinkedList<>();
        while (true) {
            String line = fileReaderUtils.readLine();
            if (line == null)
                break;
            employees.add(new Employee(line));
        }
        return employees;
    }

    private static void printEmployeeList(List<Employee> employeeList) {
        System.out.println("-".repeat(150));
        for (var e : employeeList) {
            System.out.println(e);
            System.out.println("-".repeat(150));
        }
    }

    private static void writeEmployeeListInCvsFile(List<Employee> employeeList) {
        try (FileWriterUtils fileWriterUtils = new FileWriterUtils(PATH_OF_DESTINATION + EMPLOYEES_DESTINATION)) {
            writeHeader(fileWriterUtils);
            int i = 0;
            for (var e : employeeList) {
                fileWriterUtils.writeLine(e.getCsvLine());
                i++;
            }
            System.out.printf("File successfully created, %d rows.\n", i);
        }
    }


    private static void writeHeader(FileWriterUtils fileWriterUtils) {
        fileWriterUtils.writeLine("id|name|gross pay\n");
    }
}