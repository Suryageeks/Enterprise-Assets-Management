package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.SummaryProcessDto;
import com.eam.Fixed.Assets.service.workflow.SummaryProcessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/workflow")
public class SummaryProcessController {
    private SummaryProcessService summaryProcessService;

    @PatchMapping("/approve")
    public ResponseEntity<String> setWorkflow(@RequestBody List<Object[]> assets){
        try {
            summaryProcessService.bulkInsertOrUpdateAssets(assets);
            return new ResponseEntity<>("Data processed successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Data processing failed, Error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/send-back")
    public ResponseEntity<String> setWorkflowSendBack(@RequestBody List<Object[]> assets){
        try {
            summaryProcessService.batchUpdateAssetsInSendBack(assets);
            return new ResponseEntity<>("Data processed successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Data processing failed, Error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-assets/{month}/{year}")
    public ResponseEntity<List<Object[]>> getAssetByStatusAsPerRole(@PathVariable("month") String month,
                                                                    @PathVariable("year") String year){
        List<Object[]> getAssets = summaryProcessService.getAssetsByStatus(month, year);
        if(getAssets.isEmpty() || getAssets == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(getAssets);
    }
}
