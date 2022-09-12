package com.example.iot.demo.azureiotdemo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceToCloudMessage {

    @JsonProperty("deviceId")
    private String deviceId;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("deviceLocation")
    private String deviceLocation;

    public String getDeviceLocation() {
        return this.deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    @JsonProperty("deviceMessage")
    private String deviceMessage;

    public String getDeviceMessage() {
        return this.deviceMessage;
    }

    public void setDeviceMessage(String deviceMessage) {
        this.deviceMessage = deviceMessage;
    }

}
