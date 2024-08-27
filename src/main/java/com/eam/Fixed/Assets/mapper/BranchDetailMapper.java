package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.BranchDetailsDto;
import com.eam.Fixed.Assets.entity.BranchDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchDetailMapper {
    BranchDetailMapper MAPPER = Mappers.getMapper(BranchDetailMapper.class);
    BranchDetailsDto mapToBranchDto(BranchDetails branchDetails);
    BranchDetails mapToBranch(BranchDetailsDto branchDetailsDto);
}
