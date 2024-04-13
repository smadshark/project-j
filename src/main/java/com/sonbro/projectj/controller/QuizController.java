package com.sonbro.projectj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class QuizController {
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) throws URISyntaxException {
        return switch (code) {
            case 1 -> ResponseEntity.created(new URI("/member")).body("Created!");
            case 2 -> ResponseEntity.badRequest().body("Bad Request!");
            default -> ResponseEntity.ok("OK!");
        };
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz1(@RequestBody Code code) {
        if (code.value() == 1) {
            return ResponseEntity.status(403).body("Forbidden!");
        }
        return ResponseEntity.ok("OK!");
    }

    record Code(int value) {
    }
}
