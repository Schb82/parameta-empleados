package com.parameta.empleado.services;

import com.parameta.empleado.commons.InvalidDataException;
import com.parameta.empleado.entities.Employee;
import com.parameta.empleado.entities.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import com.parameta.empleado.DTOs.EmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;


@RestController
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping(value = "/empleado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto guardarEmpleado(@Valid  @RequestBody EmployeeDto input, BindingResult errors){
        if(errors.hasErrors()) {
            throw new InvalidDataException(errors);
        }

        List<Employee> lista = repository.findEmployeeByTypeDocumentAndNumberDocument(input.getTypedocument(),input.getNumberdocument());
        Employee emp;
        if(Objects.nonNull(lista) && !lista.isEmpty()){
            //update
            emp = lista.get(0);
        }else{
            //insert
            emp = new Employee();
            emp.setTypeDocument(input.getTypedocument());
            emp.setNumberDocument(input.getNumberdocument());
        }
        emp.setNames(input.getNames());
        emp.setLastname(input.getLastname());
        emp.setJobTitle(input.getJobtitle());
        emp.setSalary(input.getSalary());
        emp.setBirthdate(input.getBirthdate());
        emp.setStartDate(input.getStartdate());

        repository.save(emp);
        input.setJobLifetime(this.getLifetimeMessage(input.getStartdate(), LocalDate.now()));
        input.setAge(this.getAgeMessage(input.getBirthdate(),LocalDate.now()));
        return input;

    }

    private String getLifetimeMessage(Date d1, LocalDate date2){
        LocalDate date1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(date1, date2);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        return years+" Años, "+months+" Meses, "+days+" Dias";
    }

    private String getAgeMessage(Date d1, LocalDate date2){
        LocalDate date1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(date1, date2);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        return years+" Años, "+months+" Meses, "+days+" Dias";
    }

}
