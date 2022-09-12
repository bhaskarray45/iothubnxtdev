package com.example.iot.demo.azureiotdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iot.demo.azureiotdemo.service.CreateDeviceService;

@RestController
public class IotDeviceManagerController {
    
    @Autowired
    private CreateDeviceService createDeviceService;

    @GetMapping("/device/add")
    public void addDevice(){

        createDeviceService.addDevice();
    }

    @GetMapping("/device/get")
    public void getDevices(){


    }

    @PostMapping("/device/remove")
    public void removeDevice(){


    }

    @PostMapping("/device/update")
    public void updateDevice(){


    }

}
