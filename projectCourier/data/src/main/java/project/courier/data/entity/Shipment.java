package project.courier.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.courier.data.entity.enums.ShipmentCategory;
import project.courier.data.entity.enums.ShipmentStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private long courierId;
    private long officeId;
    private String destination;
    @Enumerated(EnumType.STRING)
    private ShipmentCategory category;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
    private LocalDate dateSent;
    private LocalDate dateReceived;
    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "courierId", insertable = false, updatable = false)
    private Courier courier;
    @ManyToOne
    @JoinColumn(name = "officeId", insertable = false, updatable = false)
    private Office office;
}
