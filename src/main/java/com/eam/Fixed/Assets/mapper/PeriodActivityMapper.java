package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.PeriodActivityDto;
import com.eam.Fixed.Assets.entity.PeriodActivity;
import org.mapstruct.factory.Mappers;

public interface PeriodActivityMapper{
    PeriodActivityMapper MAPPER = Mappers.getMapper(PeriodActivityMapper.class);
    PeriodActivityDto mapToPeriodActivityDto(PeriodActivity periodActivity);
    PeriodActivity mapToPeriodActivity(PeriodActivityDto periodActivityDto);
}
