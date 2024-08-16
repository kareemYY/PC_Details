package com.kareem.PC_Details.repository;

import com.kareem.PC_Details.entity.PcDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcDetailsRepository  extends JpaRepository<PcDetails, Integer> {

    //boolean existsById();
}
