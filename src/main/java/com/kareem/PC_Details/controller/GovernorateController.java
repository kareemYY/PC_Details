package com.kareem.PC_Details.controller;



import com.kareem.PC_Details.dto.governorate.GovernorateDto;
import com.kareem.PC_Details.service.GovernorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/governorate")
public class GovernorateController {

    private GovernorateService governorateService;

    @Autowired
    public GovernorateController(GovernorateService governorateService) {
        this.governorateService = governorateService;
    }

    @GetMapping("/{id}")
    public GovernorateDto getOneGovernorate(@PathVariable("id") int id){
        return  governorateService.getOneGovernorate(id);
    }

}
