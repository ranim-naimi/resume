package com.talan.resume.service;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserRequest {
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
