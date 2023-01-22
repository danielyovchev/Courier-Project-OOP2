package project.courier.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourierTableModel {
    private Long id;
    private String courierName;
    private String email;
    private String companyName;
    private String username;
    private int shipmentsCount;
}
