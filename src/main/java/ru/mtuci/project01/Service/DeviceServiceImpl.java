package ru.mtuci.project01.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.project01.dao.DeviceRepository;
import ru.mtuci.project01.model.Device;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;

    }
    @Override
    public Device get(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.delete(id);
    }
}

