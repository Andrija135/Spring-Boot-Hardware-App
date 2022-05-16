package hr.tvz.poljak.hardwareapp.hardware.service;

import hr.tvz.poljak.hardwareapp.hardware.model.Hardware;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareCommand;
import hr.tvz.poljak.hardwareapp.hardware.repository.HardwareRepository;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareDTO;
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
    public Optional<HardwareDTO> findByCode(final String code) {
        return hardwareRepository
                .findByCode(code)
                .map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> save(final HardwareCommand command) {
        return hardwareRepository
                .save(mapCommandToHardware(command))
                .map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> update(final String code, final HardwareCommand command) {
        return hardwareRepository
                .update(code, mapCommandToHardware(command))
                .map(this::mapHardwareToDTO);
    }


    @Override
    public void deleteByCode(final String code) {
        hardwareRepository.deleteByCode(code);
    }

    public HardwareDTO mapHardwareToDTO(final Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getCode(), hardware.getPrice());
    }

    public Hardware mapCommandToHardware(final HardwareCommand command) {
        return new Hardware(
                command.getName(),
                command.getCode(),
                command.getPrice(),
                command.getType(),
                command.getStock()
        );
    }
}
