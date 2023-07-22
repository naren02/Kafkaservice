package com.narentech.kafkaservice.service;

import com.narentech.kafkaservice.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

        public Map<String, List<Employee>> saveAll(List<Employee> employees){
           return  employees.stream().collect(Collectors.groupingBy(Employee::getDeptName));
        }
}
