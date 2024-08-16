package com.kareem.PC_Details.service;


import com.kareem.PC_Details.dto.aopDto.PcLogsDto;

public interface PcLogsService {

 void createPcLogs(PcLogsDto pcLogsDto);

 PcLogsDto prepareDate(int id);
}
