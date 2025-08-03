package com.beratyesbek.springcloudgcpbqstoresfirestore.controller;

import com.beratyesbek.springcloudgcpbqstoresfirestore.entity.Device;
import com.beratyesbek.springcloudgcpbqstoresfirestore.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceRepository repository;

    @PostMapping
    public ResponseEntity<Device> create(@RequestBody Device device){
        Device savedDevice = repository.save(device).block();
        return ResponseEntity.ok(savedDevice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id).block();
    }


}
