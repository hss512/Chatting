package com.gamego.chatting.controller;

import com.gamego.chatting.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test1")
    public void test1(){
        log.info("===============================================");
        log.info("test");
        log.info("===============================================");
    }

    @GetMapping("/test2")
    public void test2(){
        String categoryTitle = testService.getCategoryTitle();

        log.info("===============================================");
        log.info("categoryTitle = " + categoryTitle);
        log.info("===============================================");

    }
}
