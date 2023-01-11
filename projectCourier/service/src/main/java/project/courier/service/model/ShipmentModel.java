package project.courier.service.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentModel {
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String office;
    private String type;
    private LocalDate dateSent;
    private String email;
    private String courierUsername;
}
