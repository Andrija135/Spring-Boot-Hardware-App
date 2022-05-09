package hr.tvz.poljak.hardwareapp.repository;

import hr.tvz.poljak.hardwareapp.model.Hardware;
import hr.tvz.poljak.hardwareapp.model.HardwareType;
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
                    new Hardware("Intel Pentium", "jhbJHG", BigDecimal.valueOf(100.00), HardwareType.CPU, 5),
                    new Hardware("RTX", "SDFLN", BigDecimal.valueOf(2100.00), HardwareType.GPU, 5)
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
    public void deleteByCode(String code) {
        MOCK_HARDWARE.removeIf(hardware -> hardware.getCode().equals(code));
    }
}
