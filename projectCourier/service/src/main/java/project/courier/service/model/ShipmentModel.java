package project.courier.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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