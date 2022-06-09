package hr.tvz.poljak.hardwareapp.hardware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HardwareDTO {

    private String name;

    private String code;

    private BigDecimal price;

    private Integer stock;
}
