package project.courier.service.interfaces;

import project.courier.service.model.CustomerModel;

import java.util.List;

public interface CustomerProvider
{
    List<CustomerModel> getAllCompanyCustomers(Long companyId);
}
