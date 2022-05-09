package hr.tvz.poljak.hardwareapp.service;

import hr.tvz.poljak.hardwareapp.dto.HardwareDTO;
import hr.tvz.poljak.hardwareapp.model.Hardware;
import hr.tvz.poljak.hardwareapp.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }


    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository
                .findAll()
                .stream()
                .map(this::mapHardwareToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return hardwareRepository
                .findByCode(code)
                .map(this::mapHardwareToDTO);
    }


    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }

    public HardwareDTO mapHardwareToDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }
}
