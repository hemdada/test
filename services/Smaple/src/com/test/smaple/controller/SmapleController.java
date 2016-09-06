/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.test.smaple.controller;

import com.test.smaple.Smaple;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import com.wavemaker.studio.common.wrapper.StringWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/smaple")
public class SmapleController {

    @Autowired
    private Smaple smaple;

    @RequestMapping(value = "/sampleJavaOperation", produces = "application/json", method = RequestMethod.GET)
    public StringWrapper sampleJavaOperation(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return new StringWrapper(smaple.sampleJavaOperation(name, request));
    }
}
