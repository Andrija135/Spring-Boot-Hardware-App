package hr.tvz.poljak.hardwareapp.hardware.model;

import hr.tvz.poljak.hardwareapp.review.model.Review;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private HardwareType type;

    private Integer stock;

    @OneToMany(mappedBy = "hardware", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    public Hardware(Long id, String name, String code, BigDecimal price, HardwareType type, Integer stock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public Hardware(String name, String code, BigDecimal price, HardwareType type, Integer stock) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }
}
