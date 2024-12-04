package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/county")
public class CountyController {
    private final CountyService countyService;

    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping("/{countyNumber}")
    public ResponseEntity<String> getCounty(@PathVariable String countyNumber) {
        return ResponseEntity.ok(countyService.getCountyNameByNumber(countyNumber));
    }
}
