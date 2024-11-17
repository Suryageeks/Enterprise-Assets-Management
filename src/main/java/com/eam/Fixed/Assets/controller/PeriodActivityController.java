package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.PeriodActivityDto;
import com.eam.Fixed.Assets.service.PeriodActivityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/period")
public class PeriodActivityController  {
    private final PeriodActivityService periodActivityService;

    @PostMapping
    public ResponseEntity<PeriodActivityDto> createPeriodActivity(@Valid @RequestBody PeriodActivityDto periodActivityDto) {
        PeriodActivityDto result = periodActivityService.createPeriodActivity(periodActivityDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/all-period")
    public ResponseEntity<List<PeriodActivityDto>> getAllPeriodActivity() {
        List<PeriodActivityDto> getAllPeriod = periodActivityService.getPeriodActivity();
        return new ResponseEntity<>(getAllPeriod, HttpStatus.OK);
    }
    @PutMapping("/update-period/{month}/{year}")
    public ResponseEntity<PeriodActivityDto> updatePeriodActivity(@PathVariable("month") String month,@PathVariable("year") String year,@Valid @RequestBody PeriodActivityDto periodActivityDto) {
        PeriodActivityDto result = periodActivityService.updatePeriodActivity(month,year,periodActivityDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/single-period")
    public ResponseEntity<PeriodActivityDto> getOnePeriod(){
        PeriodActivityDto getOnePeriod = periodActivityService.getSinglePeriodActivity();
        return new ResponseEntity<>(getOnePeriod, HttpStatus.OK);
    }
}
