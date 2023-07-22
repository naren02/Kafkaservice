package com.narentech.kafkaservice.controller;

import com.narentech.kafkaservice.component.EmployeeProducer;
import com.narentech.kafkaservice.component.TopicConsumer;
import com.narentech.kafkaservice.component.TopicProducer;
import com.narentech.kafkaservice.pojo.Employee;
import com.narentech.kafkaservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka/employee")
public class KafkaEmployeeController {

    @Autowired
    public TopicProducer topicProducer;

    @Autowired
    public TopicConsumer topicConsumer;
    @Autowired
    public EmployeeProducer employeeProducer;

    @Autowired
    public EmployeeService employeeService;

    @PostMapping(value = "/send")
    public Integer sendMessage(@RequestBody Employee employee){

         return employeeProducer.send(employee);
    }

    @PostMapping(value = "/saveall")
    public Map<String, List<Employee>> saveEmp(@Valid @RequestBody  List<Employee> employees){

        return employeeService.saveAll(employees);
    }

    @PostMapping("/add")
    ResponseEntity<String> addUser(@Valid @RequestBody Employee user) {
        // persisting the user
        return ResponseEntity.ok("Employee is valid");
    }



}
