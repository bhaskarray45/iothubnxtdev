package com.example.iot.demo.azureiotdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.iot.demo.azureiotdemo.Model.DeviceToCloudMessage;
import com.example.iot.demo.azureiotdemo.service.SendD2CMessageService;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;

@RestController
public class D2CMessageSendController {
    
    @Autowired
    private SendD2CMessageService sendD2CMessageService;

    @PostMapping("/send/message/d2c")
    public void sendMessageD2C(@RequestBody DeviceToCloudMessage deviceToCloudMessage){

        try {
            sendD2CMessageService.sendD2CMessage(deviceToCloudMessage);
        } catch (IotHubClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
