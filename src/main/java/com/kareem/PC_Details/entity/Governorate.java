package com.kareem.PC_Details.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "governorate")
@AllArgsConstructor
@NoArgsConstructor
public class Governorate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GovernorateId ;



    private String name;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "governorate")
    private List<Branch> branches;
}
