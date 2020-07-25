package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.dto.ResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseDto save(Employee employee) {
        ResponseDto responseDto = ResponseDto.builder ().status ( false ).message ( "employee fail" ).build ();
        Long id = employeeRepository.save ( employee ).getId ();
        responseDto.setMessage ( "employee saved successfully" );
        responseDto.setData ( id );
        responseDto.setStatus ( true );
        return responseDto;
    }

    public ResponseDto getEmployee(Long id) {
        ResponseDto responseDto = ResponseDto.builder ().status ( false ).message ( "error" ).build ();
        //Optional<Employee> employee = employeeRepository.findById ( id );

        Employee employee = employeeRepository.findById ( id ).orElseThrow ( () -> new EntityNotFoundException ( "Employee", id ) );
        responseDto.setMessage ( "employee retrieved" );
        responseDto.setData ( employee );
        responseDto.setStatus ( true );
        return responseDto;
    }
}
