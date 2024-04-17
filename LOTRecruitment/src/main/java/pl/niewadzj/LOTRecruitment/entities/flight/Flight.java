package pl.niewadzj.LOTRecruitment.entities.flight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "flights")
@NoArgsConstructor
@RequiredArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    @Pattern(regexp = "^LO\\d{2,4}$\n")
    private String flightNumber;
    


}
