package hr.tvz.poljak.hardwareapp.model;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class HardwareCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    private String code;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotNull(message = "Hardware type must be entered")
    HardwareType type;

    @NotNull(message = "Number of available items must be entered")
    @PositiveOrZero(message = "Number of available items must be entered as a positive integer")
    private Integer nrAvailable;

}
