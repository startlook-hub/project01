package ru.mtuci.project01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mtuci.project01.model.Device;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DeviceRepository extends JpaRepository <Device,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Device p WHERE p.id=:id")
    int delete(@Param("id") Long id );

}
