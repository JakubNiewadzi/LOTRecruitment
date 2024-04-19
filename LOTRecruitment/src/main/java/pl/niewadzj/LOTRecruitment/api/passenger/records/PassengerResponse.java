package pl.niewadzj.LOTRecruitment.api.passenger.records;

import lombok.Builder;

@Builder
public record PassengerResponse(Long id,
                                String name,
                                String phoneNumber) {
}
