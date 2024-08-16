package com.kareem.PC_Details.controller;


import com.kareem.PC_Details.dto.pc.PcDetailsDTO;
import com.kareem.PC_Details.dto.pc.PcDetailsDTOAllData;
import com.kareem.PC_Details.dto.pc.PcDetailsDtoUpdate;
import com.kareem.PC_Details.service.PcDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pc")
public class PcDetailsController {
    private PcDetailsService pcDetailsService;

    public PcDetailsController(PcDetailsService pcDetailsService) {
        this.pcDetailsService = pcDetailsService;
    }

    @PostMapping
    public PcDetailsDTO createPc(@RequestBody PcDetailsDTO pcDetailsDTO){
        return pcDetailsService.createPcDetails(pcDetailsDTO);
        
    }

    @GetMapping
    public List<PcDetailsDTOAllData> getAllData(){
        return pcDetailsService.getAllPcDetails();
    }

    @GetMapping("/{id}")
    public PcDetailsDTOAllData getOneData(@PathVariable (name = "id") int id){

        return pcDetailsService.getOnePcData(id);
    }

    @DeleteMapping("/{id}")
    public String deletePCData(@PathVariable (name = "id") int id){
        return pcDetailsService.deletePcData(id);
    }


    @PutMapping("/{id}")
    public PcDetailsDTOAllData updatePcDetails(@PathVariable (name = "id") int id ,
                                               @RequestBody PcDetailsDtoUpdate pcDetailsDtoUpdate){
      return   pcDetailsService.upDatePcDetails(pcDetailsDtoUpdate, id);
    }


}
