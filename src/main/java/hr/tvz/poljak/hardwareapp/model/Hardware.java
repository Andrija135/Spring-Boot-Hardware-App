package hr.tvz.poljak.hardwareapp.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hardware {

    private Long id;

    private String name;

    @EqualsAndHashCode.Include
    private String code;

    private BigDecimal price;

    private HardwareType type;

    private Integer nrAvailable;
}
