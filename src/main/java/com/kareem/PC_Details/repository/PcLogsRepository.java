package com.kareem.PC_Details.repository;


import com.kareem.PC_Details.entity.PcLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcLogsRepository extends JpaRepository<PcLogs,Integer> {
}
