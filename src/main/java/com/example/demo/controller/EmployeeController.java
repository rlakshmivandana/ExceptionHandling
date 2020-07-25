package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Employee employee) {
        return ok(employeeService.save(employee));    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> get(@PathVariable Long id) {
        return ok(employeeService.getEmployee(id));
    }
}
