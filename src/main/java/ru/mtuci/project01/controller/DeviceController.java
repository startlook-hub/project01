package ru.mtuci.project01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.project01.Service.DeviceService;
import ru.mtuci.project01.model.Device;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = DeviceController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)

public class DeviceController {
    public static final String REST_URL = "/api/v1/devices";


    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping(value = "/{id}")
    public Device get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return deviceService.get(id);
    }


    @GetMapping
    public List<Device> getAll() {
        log.info("getAll");
        return deviceService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Device save(@RequestBody Device device){
        log.info("save" + device);
        return deviceService.save(device);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete" + id);
        deviceService.delete(id);
    }
}