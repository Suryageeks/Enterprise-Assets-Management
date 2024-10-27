package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.PeriodActivityDto;
import com.eam.Fixed.Assets.entity.PeriodActivity;
import com.eam.Fixed.Assets.mapper.PeriodActivityMapper;
import com.eam.Fixed.Assets.repository.PeriodActivityRepository;
import com.eam.Fixed.Assets.service.PeriodActivityService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class PeriodActivityimpl implements PeriodActivityService {
    private PeriodActivityRepository periodActivityRepository;
    @Override
    public PeriodActivityDto createPeriodActivity(PeriodActivityDto periodActivityDto) {
        PeriodActivity createPeriodActivity = PeriodActivityMapper.MAPPER.mapToPeriodActivity(periodActivityDto);
        periodActivityRepository.save(createPeriodActivity);
        return PeriodActivityMapper.MAPPER.mapToPeriodActivityDto(createPeriodActivity);
    }

    @Override
    public List<PeriodActivityDto> getPeriodActivity() {
        List<PeriodActivity> getAllPeriod = periodActivityRepository.findAll();
        if(getAllPeriod.size() == 0 || getAllPeriod == null){
            return null;
        }
        else{
            return getAllPeriod.stream().map(PeriodActivityMapper.MAPPER::mapToPeriodActivityDto).collect(Collectors.toList());
        }
    }

    @Override
    public PeriodActivityDto updatePeriodActivity(String month, String year, PeriodActivityDto periodActivityDto) {
        Optional<PeriodActivity> getPeriod = periodActivityRepository.findByProcessMonthAndProcessYear(month,year);
        if(getPeriod.isPresent()){
            PeriodActivity getPeriodStatus = getPeriod.get();
            getPeriodStatus.setPeriodStatus(periodActivityDto.getPeriodStatus());
            periodActivityRepository.save(getPeriodStatus);
            return PeriodActivityMapper.MAPPER.mapToPeriodActivityDto(getPeriodStatus);
        }
        else{
            throw new RuntimeException("Period Not Available");
        }
    }
}
