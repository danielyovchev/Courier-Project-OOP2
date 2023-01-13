package project.courier.service.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentTableModel {
    private Long shipmentId;
    private String office;
    private String category;
    private String destination;
    private Double price;
    private String status;
    private LocalDate dateSent;
}
