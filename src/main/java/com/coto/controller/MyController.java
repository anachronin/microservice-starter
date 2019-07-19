package com.coto.uservice.controller;

import com.coto.sample.SampleRequest;
import com.coto.sample.SampleApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public Greeting thing() {
        return new Greeting(1, "Hello world");
    }

    @RequestMapping( value = "/processForm" ,method = {RequestMethod.POST, RequestMethod.GET})
    public SampleApp run(@RequestBody String reqJson) {
//         System.out.println(reqJson);
        SampleApp app = new SampleApp();
        app.run(reqJson);
        return app;
    }
}
