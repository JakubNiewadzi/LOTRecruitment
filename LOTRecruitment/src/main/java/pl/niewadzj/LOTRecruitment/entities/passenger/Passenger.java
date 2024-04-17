package pl.niewadzj.LOTRecruitment.entities.passenger;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    @Embedded
    private PhoneNumber phoneNumber;

}
