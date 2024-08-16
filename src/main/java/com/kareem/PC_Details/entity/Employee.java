package com.kareem.PC_Details.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int EmployeeId;

    @Column(name = "company_employee_id")
    private int companyEmployeeId;

    @Column(name = "full_name_english")
    private String fullNameEnglish;

    @Column(name = "full_name_arabic")
    private String fullNameArabic;

    @Column(name = "department")
    private String department;

    @Column(name = "national_id")
    private String nationalID;

    @Column(name= "phone_number")
    private String phoneNum;

    @Column(name = "address")
    private String address;


    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "branchId")
    private Branch branch;


    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    private PcDetails pcDetails;

}
