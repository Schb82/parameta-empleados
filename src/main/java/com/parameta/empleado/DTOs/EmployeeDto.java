package com.parameta.empleado.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;
import java.util.Date;

@Data
public class EmployeeDto {

    @NotNull(message="El nombre es obligatorio")
    @JsonProperty("names")
    private String names;

    @NotNull(message="El Apellido es obligatorio")
    @JsonProperty("lastname")
    private String lastname;

    @NotNull(message="El Tipo de documento es obligatorio")
    @JsonProperty("typedocument")
    private String typedocument;

    @NotNull(message="El Número de documento es obligatorio")
    @JsonProperty("numberdocument")
    private String numberdocument;

    @NotNull(message="El Cargo laboral es obligatorio")
    @JsonProperty("jobtitle")
    private String jobtitle;

    @NotNull(message="El Salario es obligatorio")
    @JsonProperty("salary")
    private Double salary;

  /*  @NotNull(message="El Fecha de nacimiento es obligatorio")*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @birthdateConstraint(message = "El empleado debe ser mayor de edad")
    private Date birthdate;

    @NotNull(message="El Fecha de Vinculación con la compania es obligatorio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startdate;




}
