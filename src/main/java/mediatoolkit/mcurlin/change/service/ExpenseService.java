package mediatoolkit.mcurlin.change.service;

import mediatoolkit.mcurlin.change.domain.expense.ExpenseRequest;
import mediatoolkit.mcurlin.change.domain.expense.ExpenseResponse;

public interface ExpenseService {
    ExpenseResponse add(ExpenseRequest expenseRequest);

    ExpenseResponse getById(Long expenseId);
}
