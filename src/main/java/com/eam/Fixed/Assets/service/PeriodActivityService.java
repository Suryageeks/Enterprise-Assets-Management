package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.PeriodActivityDto;

import java.util.List;

public interface PeriodActivityService {
    PeriodActivityDto createPeriodActivity(PeriodActivityDto periodActivityDto);
    List<PeriodActivityDto> getPeriodActivity();
    PeriodActivityDto updatePeriodActivity(String month,String year,PeriodActivityDto periodActivityDto);
    PeriodActivityDto getSinglePeriodActivity();
}
