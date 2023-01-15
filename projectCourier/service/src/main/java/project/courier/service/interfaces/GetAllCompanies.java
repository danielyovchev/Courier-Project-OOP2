package project.courier.service.interfaces;

import java.util.List;

public interface GetAllCompanies {
    List<String> getNames();
    String getCompanyFromCourier(String username);

    List<Long> getAllId();
}
