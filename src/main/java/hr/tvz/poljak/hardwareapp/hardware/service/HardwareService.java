package hr.tvz.poljak.hardwareapp.hardware.service;

import hr.tvz.poljak.hardwareapp.hardware.model.HardwareCommand;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand command);

    Optional<HardwareDTO> update(String code,HardwareCommand command);

    void deleteByCode(String code);
}
