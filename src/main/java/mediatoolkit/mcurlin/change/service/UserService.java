package mediatoolkit.mcurlin.change.service;

import mediatoolkit.mcurlin.change.domain.expense.Expense;
import mediatoolkit.mcurlin.change.domain.income.Income;
import mediatoolkit.mcurlin.change.domain.interchange.Interchange;
import mediatoolkit.mcurlin.change.domain.user.UserRequest;
import mediatoolkit.mcurlin.change.domain.user.UserResponse;

import java.util.List;

public interface UserService {

    void addIncome(Income income);

    UserResponse add(UserRequest userRequest);

    UserResponse getById(Long userId);

    void addExpense(Expense expense);

    void addInterchange(Interchange interchange);

    List<UserResponse> getAll();
}
