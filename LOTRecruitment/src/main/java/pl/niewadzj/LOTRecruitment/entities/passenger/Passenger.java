package pl.niewadzj.LOTRecruitment.entities.passenger;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;

import java.util.Set;

@Getter
@Setter
@ToString
@SuperBuilder
@Entity
@Table(name = "passengers")
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    @Column(unique = true)
    private PhoneNumber phoneNumber;
    @ManyToMany
    @JoinTable(
            name = "flight_passengers",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    @ToString.Exclude
    private Set<Flight> flights;

}
