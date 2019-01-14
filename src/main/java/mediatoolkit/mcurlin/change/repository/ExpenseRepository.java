package mediatoolkit.mcurlin.change.repository;

import mediatoolkit.mcurlin.change.domain.expense.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    Expense getById(Long id);

}
