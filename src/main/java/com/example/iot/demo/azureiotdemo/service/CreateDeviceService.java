package com.example.iot.demo.azureiotdemo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.iot.demo.azureiotdemo.constants.ApplicationConstant;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import com.microsoft.azure.sdk.iot.service.registry.Device;
import com.microsoft.azure.sdk.iot.service.registry.RegistryClient;

@Service
public class CreateDeviceService {
    
    public void addDevice()
    {
        RegistryClient registryClient = new RegistryClient(ApplicationConstant.IOT_HUB_CONN_STRING);

        Device device = new Device(ApplicationConstant.DEVICE_ID);
        try
        {
            device = registryClient.addDevice(device);

            System.out.println("Device created: " + device.getDeviceId());
            System.out.println("Device key: " + device.getPrimaryKey());
        }
        catch (IotHubException | IOException iote)
        {
            iote.printStackTrace();
        }
    }
}
