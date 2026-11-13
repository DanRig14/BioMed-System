package com.biomedsystems.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Paitent {
    private final UUID Id;
    private int MedicalRecordNumber;
    private String FirstName;
    private String LastName;
    private LocalDate DateOfBirth;

    //constructor
    public Paitent(UUID id, int medical_record_number, String first_name, String last_name, LocalDate date_of_birth){
        this.Id = id;
        this.MedicalRecordNumber = medical_record_number;
        this.FirstName = first_name;
        this.LastName = last_name;
        this.DateOfBirth = date_of_birth;
    }

//Getters

    //Getter for medical record
    public int Get_medical_record_number(){
        return MedicalRecordNumber;
    }
    //Getter for first name
    public String getFirstName(){
        return FirstName;
    }
    //Getter for last name
    public String getLastName(){
        return LastName;
    }
    //Getter for DOB
    public LocalDate getDateOfBirth(){
        return DateOfBirth;
    }
//Setters
    public void setFirstName(String first){
        this.FirstName = first;
    }
    public void setLastName(String last){
        this.LastName = last;
    }
    public void setDateOfBirth(LocalDate dob){
        this.DateOfBirth = dob;
    }

//Other
    public String getFullName(){
        return LastName + ", " + FirstName;
    }

    public int getAge(){
        LocalDate now = LocalDate.now();
        int age = calculateAge(DateOfBirth, now);
        return age;
    }
    private int calculateAge(LocalDate birth, LocalDate now){
        Period period = Period.between(birth, now);
        return period.getYears();
    }

}


