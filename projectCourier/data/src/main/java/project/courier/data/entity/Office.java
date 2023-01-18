package project.courier.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Table(schema = "public")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private Long companyId;
    @ManyToOne
    @JoinColumn(name = "companyId", insertable = false, updatable = false)
    private Company company;
}
