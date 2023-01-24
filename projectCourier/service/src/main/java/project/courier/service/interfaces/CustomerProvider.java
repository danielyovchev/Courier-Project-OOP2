package project.courier.service.interfaces;

import project.courier.service.model.CustomerTableModel;

import java.util.List;

public interface CustomerProvider {
    List<CustomerTableModel> getAllCompanyCustomers(String company);
}
