package com.kareem.PC_Details.service.impl;


import com.kareem.PC_Details.dto.aopDto.PcDetailsDTOAop;
import com.kareem.PC_Details.dto.aopDto.PcLogsDto;
import com.kareem.PC_Details.entity.PcDetails;
import com.kareem.PC_Details.entity.PcLogs;
import com.kareem.PC_Details.repository.PcDetailsRepository;
import com.kareem.PC_Details.repository.PcLogsRepository;
import com.kareem.PC_Details.service.PcLogsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PcLogsServiceImpl implements PcLogsService {

    private PcLogsRepository pcLogsRepository;
    private PcDetailsRepository pcDetailsRepository;
    private ModelMapper mapper;


    public PcLogsServiceImpl(PcLogsRepository pcLogsRepository,
                             PcDetailsRepository pcDetailsRepository,
                             ModelMapper mapper) {
        this.pcLogsRepository = pcLogsRepository;
        this.pcDetailsRepository = pcDetailsRepository;
        this.mapper = mapper;
    }

    @Override
    public void createPcLogs(PcLogsDto pcLogsDto) {

        pcLogsRepository.save(mapper.map(pcLogsDto, PcLogs.class));

        //System.out.println(pcLogs);

    }

    @Override
    public PcLogsDto prepareDate(int id) {
        if(!pcDetailsRepository.existsById(id)){
            return null;}
        PcDetails pcDetails = pcDetailsRepository.findById(id).get();

        PcDetailsDTOAop pcDetailsDTOAop = mapper.map(pcDetails,PcDetailsDTOAop.class);


        PcLogsDto pcLogsDto = new PcLogsDto();

        pcLogsDto.setPcId(pcDetailsDTOAop.getId());
        pcLogsDto.setCpuFullName(pcDetailsDTOAop.getCpuFullName());
        pcLogsDto.setRam(pcDetailsDTOAop.getRam());
        pcLogsDto.setSsd(pcDetailsDTOAop.getSsd());
        pcLogsDto.setHdd(pcDetailsDTOAop.getHdd());
        pcLogsDto.setDateStart(pcDetailsDTOAop.getDateCreated());



        if (pcDetailsDTOAop.getEmployee()==null){
            pcLogsDto.setEmployeeId(0);
            pcLogsDto.setBranchId(0);

        }else {
            pcLogsDto.setEmployeeId(pcDetailsDTOAop.getEmployee().getCompanyEmployeeId());
            pcLogsDto.setBranchId(pcDetailsDTOAop.getEmployee().getBranch().getCompanyBranchId());
        }
        return pcLogsDto;
    }


}
