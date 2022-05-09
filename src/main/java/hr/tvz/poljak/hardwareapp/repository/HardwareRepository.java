package hr.tvz.poljak.hardwareapp.repository;

import hr.tvz.poljak.hardwareapp.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Optional<Hardware> save(Hardware newHardware);

    Optional<Hardware> update(String code, Hardware updatedHardware);

    void deleteByCode(String code);
}
