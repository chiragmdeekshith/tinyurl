package com.chiragmdeekshith.tinyurl.repository;

import com.chiragmdeekshith.tinyurl.entity.Tinyurl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyurlRepository extends JpaRepository<Tinyurl, Integer> {
    Tinyurl findByShortUrl(String shortUrl);
}
