package com.chiragmdeekshith.tinyurl.service;

import com.chiragmdeekshith.tinyurl.dto.TinyurlDto;

public interface TinyurlServiceI {
    TinyurlDto createShortUrl(String originalUrl);

    String getOriginalUrl(String shortUrl) throws Exception;
}