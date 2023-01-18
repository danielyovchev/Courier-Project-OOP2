package project.courier.service.model;

import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyTableModel
{
    private long companyId;
    private String companyName;
    private int shipmentCount;
}
