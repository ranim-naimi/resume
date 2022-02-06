package com.talan.resume.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName ;
    private String lastName ;
    private String dateOfBirth;
    private String city;
    private String country;
    private String phone ;
    private String email;
    private String address;
    private String graduation ;
    private String university;
    private String degree ;
    private String companyName;
    private String jobPosition;
    private String fromDate;
    private String toDate;
    private String skills;
    private String motivation;

}
