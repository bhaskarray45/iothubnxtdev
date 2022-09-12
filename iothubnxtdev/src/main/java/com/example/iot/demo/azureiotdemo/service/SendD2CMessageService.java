package com.example.iot.demo.azureiotdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.iot.demo.azureiotdemo.Model.DeviceToCloudMessage;
import com.example.iot.demo.azureiotdemo.constants.ApplicationConstant;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;

@Service
public class SendD2CMessageService {
    
    public void sendD2CMessage(DeviceToCloudMessage deviceToCloudMessage) throws IotHubClientException{

        DeviceClient deviceClient = new DeviceClient(ApplicationConstant.IOT_HUB_CONN_STRING_1, IotHubClientProtocol.MQTT);
        deviceClient.open(false);

        String deviceId = "iot-hub-1";
        double temperature = 20 + Math.random() * 10;
        double humidity = 30 + Math.random() * 20;

        String msgStr = "{\"deviceId\":\"" + deviceId +"\",\"messageId\":" + 1 + ",\"temperature\":"+ temperature +",\"humidity\":"+ humidity +"}";


        try
            {
                Message msg = new Message(msgStr);
                msg.setContentType("application/json");
                msg.setConnectionDeviceId("iot-hub-1");
                msg.setProperty("temperatureAlert", "false");
                msg.setMessageId(java.util.UUID.randomUUID().toString());
                msg.setExpiryTime(ApplicationConstant.D2C_MESSAGE_TIMEOUT);
                System.out.println(msgStr);

                //deviceClient.sendEvent(msg, ApplicationConstant.D2C_MESSAGE_TIMEOUT);
                //EventCallback callback = new EventCallback();
                //client.sendEventAsync(msg, callback, null);
                deviceClient.sendEvent(msg);
            }
            catch (Exception e)
            {
                e.printStackTrace(); // Trace the exception
                
            }
            finally{
                deviceClient.close();
            }

    }
    
    


}
