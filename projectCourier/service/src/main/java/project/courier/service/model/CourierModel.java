package project.courier.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourierModel {
    private String firstName;
    private String lastName;
    private String email;
    private long companyId;
}
