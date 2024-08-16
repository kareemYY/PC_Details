package com.kareem.PC_Details.service;


import com.kareem.PC_Details.dto.pc.PcDetailsDTO;
import com.kareem.PC_Details.dto.pc.PcDetailsDTOAllData;
import com.kareem.PC_Details.dto.pc.PcDetailsDtoUpdate;

import java.util.List;

public interface PcDetailsService {

    PcDetailsDTO createPcDetails(PcDetailsDTO pcDetailsDTO);

    List<PcDetailsDTOAllData> getAllPcDetails ();

    PcDetailsDTOAllData getOnePcData(int id);

    String deletePcData(int id);

    PcDetailsDTOAllData upDatePcDetails(PcDetailsDtoUpdate pcDetailsDtoUpdate, int pcId);
}
