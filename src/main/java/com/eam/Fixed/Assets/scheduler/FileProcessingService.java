package com.eam.Fixed.Assets.scheduler;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessingService.class);

    private final RabbitMQPublisher rabbitMQPublisher;
    private final WebClient.Builder webClientBuilder;

    public FileProcessingService(RabbitMQPublisher rabbitMQPublisher, WebClient.Builder webClientBuilder) {
        this.rabbitMQPublisher = rabbitMQPublisher;
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Void> processFile(Path path) {
        return Mono.fromRunnable(() -> {
            try(FileInputStream inputStream = new FileInputStream(path.toFile())){
                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                List<Object[]> records = processExcelSheet(sheet);
                //TODO: Send record to queue
            } catch (Exception e){
                logger.error("Error processing file: {}",path.getFileName(),e);
            }
        }).doOnTerminate(() -> {
            logger.info("File processing completed for: {}", path.getFileName());
        })
    }

    private List<Object[]> processExcelSheet(Sheet sheet){
        List<Object[]> records = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            //TODO: Excel validation to be added
        } else {
           return null;;
        }
    }

    private ExcelRecord
}
