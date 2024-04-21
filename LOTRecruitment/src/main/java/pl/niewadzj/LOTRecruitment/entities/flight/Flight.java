package pl.niewadzj.LOTRecruitment.entities.flight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;

import java.time.LocalDateTime;
import java.util.Set;

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
    private String flightNumber;
    private String startCity;
    private String destinationCity;
    private LocalDateTime flightDateTime;
    @ManyToMany
    @JoinTable(
            name = "flight_passengers",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    @ToString.Exclude
    private Set<Passenger> passengers;
    private Integer freeSeats;
}
