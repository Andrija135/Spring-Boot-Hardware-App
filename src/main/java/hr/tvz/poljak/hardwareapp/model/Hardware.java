package hr.tvz.poljak.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hardware {

    private String name;

    @EqualsAndHashCode.Include
    private String code;

    private BigDecimal price;

    private HardwareType type;

    private Integer nrAvailable;
}
