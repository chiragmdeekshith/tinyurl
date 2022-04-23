package com.chiragmdeekshith.tinyurl.service;

import com.chiragmdeekshith.tinyurl.dto.TinyurlDto;
import com.chiragmdeekshith.tinyurl.entity.Tinyurl;
import com.chiragmdeekshith.tinyurl.repository.TinyurlRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TinyurlServiceImpl implements TinyurlServiceI {

    @Autowired
    private TinyurlRepository tinyurlRepository;

    @Override
    public TinyurlDto createShortUrl(String originalUrl) {
        TinyurlDto tinyurlDto = new TinyurlDto();
        tinyurlDto.setOriginalUrl(originalUrl);
        tinyurlDto.setShortUrl(RandomStringUtils.random(6, true, true));
        tinyurlRepository.save(new Tinyurl(tinyurlDto.getOriginalUrl(), tinyurlDto.getShortUrl()));
        return tinyurlDto;
    }

    @Override
    public String getOriginalUrl(String shortUrl) throws Exception {
        Tinyurl tinyurl = tinyurlRepository.findByShortUrl(shortUrl);
        if (Objects.isNull(tinyurl)) {
            throw new Exception("Short URL not found");
        }
        return tinyurl.getOriginalUrl();
    }
}
