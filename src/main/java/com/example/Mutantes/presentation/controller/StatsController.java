package com.example.Mutantes.presentation.controller;

import com.example.Mutantes.domain.dto.StatsDTO;
import com.example.Mutantes.business.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping("")
    public ResponseEntity<StatsDTO> getStats() {
        try {
            StatsDTO stats = statsService.getStats();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
