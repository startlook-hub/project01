package ru.mtuci.project01.Service;

import ru.mtuci.project01.model.Device;

import java.util.List;

public interface DeviceService {
    Device get(Long id);
    List<Device> getAll();
    Device save(Device device);
    void delete(Long id);
}