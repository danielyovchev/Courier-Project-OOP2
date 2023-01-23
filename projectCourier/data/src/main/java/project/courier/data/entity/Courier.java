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
public class Courier {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Long companyId;
    @ManyToOne
    @JoinColumn(name = "companyId", insertable = false, updatable = false)
    private Company company;
}
