package project.courier.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Long companyId;
    @ManyToOne
    @JoinColumn(name = "companyId", insertable = false, updatable = false)
    private Company company;
}
