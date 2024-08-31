package home.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Engine {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double volume;
    private int power;
    private String type;
}
