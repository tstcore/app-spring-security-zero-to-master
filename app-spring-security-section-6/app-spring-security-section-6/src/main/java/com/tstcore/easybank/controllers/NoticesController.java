package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.Notice;
import com.tstcore.easybank.services.NoticesService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {
    private final NoticesService service;

    public NoticesController(NoticesService service) {
        this.service = service;
    }

    @GetMapping(value = "/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(service.findAllActiveNotices());
    }
}
