package hr.tvz.poljak.hardwareapp.service;

import hr.tvz.poljak.hardwareapp.dto.HardwareDTO;
import hr.tvz.poljak.hardwareapp.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    void deleteByCode(String code);
}
