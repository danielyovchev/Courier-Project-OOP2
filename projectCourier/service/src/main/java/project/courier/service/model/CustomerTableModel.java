package project.courier.service.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTableModel {
    private long customerId;
    private String name;
    private int shipmentsCount;
}
