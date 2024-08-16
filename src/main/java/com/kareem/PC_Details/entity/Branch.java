package com.kareem.PC_Details.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int branchId;

    @Column(name = "company_branch_id")
    private int companyBranchId;

    @Column(name = ("branch_name_english"))
    private String branchNameEnglish;

    @Column(name = "branch_name_arabic")
    private String branchNameArabic;


    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER,
            mappedBy = "branch")
    List<Employee> employees;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE},
    fetch = FetchType.EAGER)
    @JoinColumn(name = "supervisorId")
    private Supervisor supervisor;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "governorateId")
    private Governorate governorate;


}
