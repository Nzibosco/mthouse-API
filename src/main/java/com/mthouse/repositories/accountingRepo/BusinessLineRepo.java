package com.mthouse.repositories.accountingRepo;


import com.mthouse.entities.accounting.Business_line;
import org.springframework.data.repository.CrudRepository;

public interface BusinessLineRepo extends CrudRepository<Business_line, Integer> {
}
