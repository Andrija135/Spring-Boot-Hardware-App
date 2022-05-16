package hr.tvz.poljak.hardwareapp.hardware.repository;

import hr.tvz.poljak.hardwareapp.hardware.model.Hardware;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements HardwareRepository {

    private final List<Hardware> MOCK_HARDWARE = new ArrayList<>(
            Arrays.asList(
                    new Hardware(1L, "Intel Pentium", "jhbJHG", BigDecimal.valueOf(100.00), HardwareType.CPU, 5),
                    new Hardware(2L, "RTX", "SDFLN", BigDecimal.valueOf(2100.00), HardwareType.GPU, 2),
                    new Hardware(3L, "ASUS ZEPHYRUS", "DFGFG", BigDecimal.valueOf(15000.00), HardwareType.OTHER, 10)
            )
    );

    @Override
    public List<Hardware> findAll() {
        return MOCK_HARDWARE;
    }

    @Override
    public Optional<Hardware> findByCode(final String code) {
        return MOCK_HARDWARE
                .stream()
                .filter(hardware -> hardware.getCode().equals(code))
                .findAny();
    }

    @Override
    public Optional<Hardware> save(Hardware newHardware) {
        if (!MOCK_HARDWARE.contains(newHardware)) {
            MOCK_HARDWARE.add(newHardware);
            return Optional.of(newHardware);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Hardware> update(final String code, Hardware updatedHardware) {

        boolean itemExisted = MOCK_HARDWARE
                .removeIf(hardware -> hardware.getCode().equals(code) && code.equals(updatedHardware.getCode()));

        if (itemExisted) {
            MOCK_HARDWARE.add(updatedHardware);
            return Optional.of(updatedHardware);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        MOCK_HARDWARE.removeIf(hardware -> hardware.getCode().equals(code));
    }
}
