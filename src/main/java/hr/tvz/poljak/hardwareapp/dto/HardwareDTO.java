package hr.tvz.poljak.hardwareapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HardwareDTO {

    private String name;

    private BigDecimal price;
}
