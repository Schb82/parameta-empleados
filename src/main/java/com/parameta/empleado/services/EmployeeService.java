package com.parameta.empleado.services;

import com.parameta.empleado.DTOs.EmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeService {

    @GetMapping(value = "/empleado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto guardarEmpleado(@Validated EmployeeDto input){

        System.out.println("hola");
        return input;
    }

}
