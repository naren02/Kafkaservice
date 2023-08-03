package com.narentech.kafkaservice.service;

import com.narentech.kafkaservice.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Service
public class EmployeeService {

        public Map<String, List<Employee>> saveAll(List<Employee> employees){
           return  employees.stream().collect(groupingBy(Employee::getDeptName));
        }

        public Double getAverageSalary(List<Employee> employees){
           return  employees.stream().mapToLong(Employee :: getSalary).average().getAsDouble();
        }

        public Map<String, Double> getAveragePerDept(List<Employee> employees){
           // employees.stream().filter(emp -> emp.getSalary() > 1000).forEach(employee -> employee.getName().equalsIgnoreCase());
            return employees.stream().collect(groupingBy(Employee::getDeptName , TreeMap :: new ,averagingDouble(Employee ::getSalary)));
        }

        public Map<String, Object> getMaxSalaryPerDept(List<Employee> employees){
            return  employees.stream().collect(groupingBy(Employee::getDeptName, collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee ::getSalary)), Optional :: get))));
        }
}
