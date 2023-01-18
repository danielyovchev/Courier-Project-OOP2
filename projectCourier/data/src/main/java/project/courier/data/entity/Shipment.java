package project.courier.data.entity;

import jakarta.persistence.*;
import lombok.*;
import project.courier.data.entity.enums.ShipmentCategory;
import project.courier.data.entity.enums.ShipmentStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long courierId;
    private Long officeId;
    private String destination;
    @Enumerated(EnumType.STRING)
    private ShipmentCategory category;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
    private LocalDate dateSent;
    private LocalDate dateReceived;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "courierId", insertable = false, updatable = false)
    private Courier courier;
    @ManyToOne
    @JoinColumn(name = "officeId", insertable = false, updatable = false)
    private Office office;
}
