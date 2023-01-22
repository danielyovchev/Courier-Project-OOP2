package project.courier.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourierModel {
    private long courierId;
    private String firstName;
    private String lastName;
    private String username;
    private String companyName;
    private String email;
    private int shipmentsCount;
}
