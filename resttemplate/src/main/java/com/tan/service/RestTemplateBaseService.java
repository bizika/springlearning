package com.tan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 基于注解
 *
 * @author 601091
 * @date 2018/6/26
 */
@Component
@Slf4j
public class RestTemplateBaseService {


    @Resource(name = "restTemplate")
    RestTemplate restTemplate;

    protected <T> T httpGetObjectRequest(String url, String body, Map<String, ?> param) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> entity = new HttpEntity<String>(body, httpHeaders);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, param);
        return null;
    }
}
