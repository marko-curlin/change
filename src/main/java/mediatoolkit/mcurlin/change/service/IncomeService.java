package mediatoolkit.mcurlin.change.service;

import mediatoolkit.mcurlin.change.domain.income.IncomeRequest;
import mediatoolkit.mcurlin.change.domain.income.IncomeResponse;

public interface IncomeService {
    IncomeResponse add(IncomeRequest incomeRequest);

    IncomeResponse getById(Long incomeId);
}
