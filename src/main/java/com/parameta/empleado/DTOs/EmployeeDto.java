package com.parameta.empleado.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {

    @NotNull(message="El nombre es obligatorio")
    @JsonProperty("names")
    private String names;


}
