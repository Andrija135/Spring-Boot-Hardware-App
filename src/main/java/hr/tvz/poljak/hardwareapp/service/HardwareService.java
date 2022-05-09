package hr.tvz.poljak.hardwareapp.service;

import hr.tvz.poljak.hardwareapp.dto.HardwareDTO;
import hr.tvz.poljak.hardwareapp.model.Hardware;
import hr.tvz.poljak.hardwareapp.model.HardwareCommand;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand command);

    Optional<HardwareDTO> update(String code,HardwareCommand command);

    void deleteByCode(String code);
}
