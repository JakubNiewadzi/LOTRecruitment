package pl.niewadzj.LOTRecruitment.entities.flight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    @Pattern(regexp = "^LO\\d{2,4}$\n")
    private String flightNumber;
    private LocalDateTime flightDateTime;
    @OneToMany
    @ToString.Exclude
    private List<Passenger> passengers;
    private int freeSeats;
}
