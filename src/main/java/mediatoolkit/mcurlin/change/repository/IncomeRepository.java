package mediatoolkit.mcurlin.change.repository;

import mediatoolkit.mcurlin.change.domain.income.Income;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepository extends CrudRepository<Income, Long> {

    Income getById(Long id);

}
