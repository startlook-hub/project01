package ru.mtuci.project01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtuci.project01.dao.DeviceRepository;

@Component
public class ComandLineAppStartupRunner {

    private final DeviceRepository deviceRepository;

    @Autowired
    public ComandLineAppStartupRunner(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    public void run(String...args) throws Exception {
        //System.out.println(deviceRepository.findAll());
    }
}