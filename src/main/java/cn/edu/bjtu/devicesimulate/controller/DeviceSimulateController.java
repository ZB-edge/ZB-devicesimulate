package cn.edu.bjtu.devicesimulate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/simulate")
@RestController
public class DeviceSimulateController {

    @CrossOrigin
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

}
