package com.chiragmdeekshith.tinyurl.controller;

import com.chiragmdeekshith.tinyurl.dto.TinyurlDto;
import com.chiragmdeekshith.tinyurl.service.TinyurlServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping(path = "/")
public class TinyurlController {

    @Autowired
    private TinyurlServiceI tinyurlService;

    @PostMapping("/_/create")
    public ResponseEntity<TinyurlDto> createShortUrl(@RequestBody TinyurlDto tinyurlDto) {
        tinyurlDto = tinyurlService.createShortUrl(tinyurlDto.getOriginalUrl());
        return ResponseEntity.status(HttpStatus.OK).body(tinyurlDto);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable("shortUrl") String shortUrl) {
        String originalUrl;
        try {
            originalUrl = tinyurlService.getOriginalUrl(shortUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}