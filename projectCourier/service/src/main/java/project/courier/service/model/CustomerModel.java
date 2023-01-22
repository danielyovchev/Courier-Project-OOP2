package project.courier.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
}
