package com.parameta.empleado.services;

import com.parameta.empleado.commons.CommomExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;

import com.parameta.empleado.DTOs.EmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.spi.CalendarNameProvider;

import static java.time.temporal.ChronoUnit.*;


@RestController
public class EmployeeService {

    @GetMapping(value = "/empleado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarEmpleado(@Valid  @RequestBody EmployeeDto input){

        return "Exitoso";

    }



}
