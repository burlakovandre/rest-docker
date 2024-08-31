package home.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RestResource(rel = "cars", path = "cars")
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Engine engine;
}
