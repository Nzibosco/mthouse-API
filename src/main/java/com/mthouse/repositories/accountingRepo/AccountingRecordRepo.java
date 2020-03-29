package com.mthouse.repositories.accountingRepo;

import com.mthouse.entities.accounting.Accounting_record;
import org.springframework.data.repository.CrudRepository;

public interface AccountingRecordRepo extends CrudRepository<Accounting_record, Integer> {
}
