package project.courier.service.interfaces;

import project.courier.data.entity.Company;
import project.courier.service.model.CompanyTableModel;

import java.util.List;

public interface CompanyProvider
{
  List<CompanyTableModel> getAllCompanies();
}
