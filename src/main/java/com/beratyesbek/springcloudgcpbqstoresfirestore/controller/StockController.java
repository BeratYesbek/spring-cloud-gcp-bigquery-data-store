package com.beratyesbek.springcloudgcpbqstoresfirestore.controller;

import com.beratyesbek.springcloudgcpbqstoresfirestore.entity.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.spring.bigquery.core.BigQueryTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stocks")
public class StockController {

    private final BigQueryTemplate bigQueryTemplate;
    private final ObjectMapper objectMapper;

    @Value("${spring.cloud.gcp.bigquery.project-id}")
    private String projectId;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String datasetName;

    @Value("${spring.cloud.gcp.bigquery.table-name}")
    private String tableName;

    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody Stock stock) throws JsonProcessingException {

        String stockJson = objectMapper.writeValueAsString(stock) + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stockJson.getBytes(StandardCharsets.UTF_8));
        CompletableFuture<Job> jobFuture = bigQueryTemplate.writeDataToTable(
                tableName,
                inputStream,
                FormatOptions.json()
        );
        jobFuture.join();

        return ResponseEntity.ok(stock);
    }

    @PostMapping("/csv")
    public ResponseEntity<String> insertCsv(@RequestParam MultipartFile file) throws IOException {
        String fullyQualifiedTableName = String.format("%s.%s.%s", projectId, datasetName, tableName);
        bigQueryTemplate.writeDataToTable(
                fullyQualifiedTableName,
                file.getInputStream(),
                FormatOptions.csv()
        );
        return ResponseEntity.ok("CSV data inserted successfully");
    }
}