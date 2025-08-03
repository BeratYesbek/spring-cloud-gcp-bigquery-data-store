package com.beratyesbek.springcloudgcpbqstoresfirestore.controller;

import com.beratyesbek.springcloudgcpbqstoresfirestore.entity.Notification;
import com.beratyesbek.springcloudgcpbqstoresfirestore.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationRepository repository;

    @PostMapping()
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = repository.save(notification);
        return ResponseEntity.ok(savedNotification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable String id){
        repository.deleteById(id);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return (List<Notification>) repository.findAll();
    }
}
