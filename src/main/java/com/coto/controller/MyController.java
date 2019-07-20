package com.myco.uservice.controller;

import com.myco.sample.PersonRecord;
import com.myco.sample.SampleApp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public Greeting thing() {
        return new Greeting(1, "Hello world");
    }

    // 2019-07-20 joel: see more examples at: https://www.baeldung.com/spring-request-param
    @RequestMapping( value = "/sampleAppSubmit/person/{id}" ,method = {RequestMethod.POST, RequestMethod.GET})
    public SampleApp sampleAppSubmit(@PathVariable long id, @RequestBody String json) {
//         System.out.printf("id:%s json:%s\n", id, json);
        SampleApp app = new SampleApp("person", id);
        app.processPerson(json);
        return app;
    }

    @RequestMapping( value = "/requestWithParams", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String requestWithParamsSubmit(@RequestParam Map<String,String> getParams, @RequestBody Map<String,String> postParams) {
        return "GET Parameters are " + getParams.entrySet() 
           + "; Post Parameters are " + postParams.entrySet();
    }
}
