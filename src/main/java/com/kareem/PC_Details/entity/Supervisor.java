package com.kareem.PC_Details.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "supervisor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int supervisorId;

    @Column(name = "company_supervisor_id")
    private int companySuperVisorId;

    @Column(name = "full_name_english" )
    private String fullNameEnglish;

    @Column(name = "full_name_arabic")
    private String fullNameArabic;

    @Column(name = "national_id")
    private String nationalID;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "supervisor",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Branch> branches;

}
