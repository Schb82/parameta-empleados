package com.parameta.empleado.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.parameta.empleado.DTOs.birthdateConstraint;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="employee")
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names")
    private String names;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "typedocument")
    private String typeDocument;

    @Column(name = "numberdocument")
    private String numberDocument;

    @Column(name = "jobtitle")
    private String jobTitle;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "startdate")
    private Date startDate;

}
