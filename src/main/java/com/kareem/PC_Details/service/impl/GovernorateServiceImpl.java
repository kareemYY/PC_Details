package com.kareem.PC_Details.service.impl;


import com.kareem.PC_Details.dto.governorate.GovernorateDto;
import com.kareem.PC_Details.entity.Governorate;
import com.kareem.PC_Details.exception.ResourceNotFound;
import com.kareem.PC_Details.repository.GovernorateRepository;
import com.kareem.PC_Details.service.GovernorateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GovernorateServiceImpl implements GovernorateService {

    private GovernorateRepository governorateRepository;
    private ModelMapper mapper;

    @Autowired
    public GovernorateServiceImpl(GovernorateRepository governorateRepository, ModelMapper mapper) {
        this.governorateRepository = governorateRepository;
        this.mapper = mapper;
    }

    @Override
    public GovernorateDto getOneGovernorate(int id) {
        Governorate governorate=governorateRepository.findById(id).
                orElseThrow(() -> new ResourceNotFound("Governorate Id Not Found "));


        GovernorateDto governorateDto = mapper.map(governorate,GovernorateDto.class);
        return governorateDto;
    }
}
