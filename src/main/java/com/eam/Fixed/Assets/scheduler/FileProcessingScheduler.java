package com.eam.Fixed.Assets.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.File;

@Component
public class FileProcessingScheduler {
    private final FileProcessingService fileProcessingService;

    @Value("${file.processing.temp-folder}")
    private String tempFolder;

    public FileProcessingScheduler(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void processFile() {
        Flux.
    }
}
