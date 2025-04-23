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
    private static final String EMPLOYEES_DESTINATION_JSON = "employees_gross_pay.json";

    public static void main(String[] args) {
        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH_OF_SOURCE + EMPLOYEES_SOURCE);
        List<Employee> employeeList = getEmployeeList(fileReaderUtils);
        printEmployeeList(employeeList);
        writeEmployeeListInCvsFile(employeeList);
        writeEmployeeListInJsonFile(employeeList);
    }

    private static void writeEmployeeListInJsonFile(List<Employee> employeeList) {
        try (FileWriterUtils fileWriterUtils = new FileWriterUtils(PATH_OF_DESTINATION + EMPLOYEES_DESTINATION_JSON)) {
            fileWriterUtils.writeLine("[\n");
            int i = 0;
            for (var e : employeeList) {
                fileWriterUtils.writeLine(e.toJsonLine());
                if (i < employeeList.size() - 1) {
                    fileWriterUtils.writeLine(",\n");
                }
                i++;
            }
            fileWriterUtils.writeLine("\n]");
            System.out.printf("Json file successfully created, %d rows.\n", i);
        }
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
            System.out.printf("CSV file successfully created, %d rows.\n", i);
        }
    }


    private static void writeHeader(FileWriterUtils fileWriterUtils) {
        fileWriterUtils.writeLine("id|name|gross pay\n");
    }
}