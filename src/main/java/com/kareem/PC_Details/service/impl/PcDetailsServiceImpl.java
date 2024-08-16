package com.kareem.PC_Details.service.impl;


import com.kareem.PC_Details.dto.pc.PcDetailsDTO;
import com.kareem.PC_Details.dto.pc.PcDetailsDTOAllData;
import com.kareem.PC_Details.dto.pc.PcDetailsDtoUpdate;
import com.kareem.PC_Details.entity.Employee;
import com.kareem.PC_Details.entity.PcDetails;
import com.kareem.PC_Details.exception.ResourceNotFound;
import com.kareem.PC_Details.repository.EmployeeRepository;
import com.kareem.PC_Details.repository.PcDetailsRepository;
import com.kareem.PC_Details.service.PcDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PcDetailsServiceImpl implements PcDetailsService {

    private PcDetailsRepository pcRepository;
    private ModelMapper mapper;
    private EmployeeRepository employeeRepository;

    @Autowired
    public PcDetailsServiceImpl(PcDetailsRepository pcRepository,
                                ModelMapper mapper,
                                EmployeeRepository employeeRepository) {
        this.pcRepository = pcRepository;
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public PcDetailsDTO createPcDetails(PcDetailsDTO pcDetailsDTO) {


        PcDetails pcDetails =mapper.map(pcDetailsDTO,PcDetails.class);
        pcRepository.save(pcDetails);

        return mapper.map(pcDetails,PcDetailsDTO.class);
    }

    @Override
    public List<PcDetailsDTOAllData> getAllPcDetails() {
        List<PcDetails> pcDetails = pcRepository.findAll();
        List <PcDetailsDTOAllData> pcDetailsDTOAllData =pcDetails.stream().map(pcDetails1 ->
                mapper.map(pcDetails1,PcDetailsDTOAllData.class)).collect(Collectors.toList());

//        pcDetailsDTOAllData.stream().forEach(pcDetailsDTOAllData1 ->
//                pcDetailsDTOAllData1.setGenerateQrCode("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="
//                        +pcDetailsDTOAllData1.getCpuFullName().replace(" ","%20")
//                        +"%0ARam:%20"+pcDetailsDTOAllData1.getRam()+"%20GB%0AHard%20"+pcDetailsDTOAllData1.getSsd()
//                        +"%20SSD,%20"+pcDetailsDTOAllData1.getHdd()+"%20HDD%0ATW_PC_"+pcDetailsDTOAllData1.getId()));
    return pcDetailsDTOAllData;
    }

    @Override
    public PcDetailsDTOAllData getOnePcData(int id) {
        PcDetails pcDetails=pcRepository.findById(id).orElseThrow(() -> new ResourceNotFound("This ID Not Found"));
        return mapper.map(pcDetails, PcDetailsDTOAllData.class);
    }

    @Override
    public String deletePcData(int id) {
        PcDetails pcDetails=pcRepository.findById(id).orElseThrow(() -> new ResourceNotFound("This ID Not Found"));

        pcDetails.getEmployee().setPcDetails(null);
        pcRepository.delete(pcDetails);
        return "The PC Data Is Deleted Successfully  : " +id ;

    }

    @Override
    public PcDetailsDTOAllData upDatePcDetails(PcDetailsDtoUpdate pcDetailsDtoUpdate, int pcId) {
        PcDetails pcDetails= pcRepository.findById(pcId)
                .orElseThrow(() -> new ResourceNotFound("this Id Not Found "));
        Employee getEmployee = employeeRepository.findById(pcDetailsDtoUpdate.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFound("Employee Id not Found"));

        pcDetails.setHdd(pcDetailsDtoUpdate.getHdd());
        pcDetails.setRam(pcDetailsDtoUpdate.getRam());
        pcDetails.setSsd(pcDetailsDtoUpdate.getSsd());
        pcDetails.setCpuFullName(pcDetailsDtoUpdate.getCpuFullName());
        pcDetails.setEmployee(getEmployee);
        pcRepository.save(pcDetails);

        return mapper.map(pcDetails,PcDetailsDTOAllData.class);
    }


}
