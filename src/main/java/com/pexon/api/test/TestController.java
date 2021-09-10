package com.pexon.api.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {
    //This is a test request if the db connection cannot be established
    @GetMapping(path="api/v1/test")
    public String testApi(){ return "Pexon Rocks!";}
}