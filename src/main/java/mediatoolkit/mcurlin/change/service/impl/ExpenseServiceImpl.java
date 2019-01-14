package mediatoolkit.mcurlin.change.service.impl;

import mediatoolkit.mcurlin.change.domain.expense.Expense;
import mediatoolkit.mcurlin.change.domain.expense.ExpenseRequest;
import mediatoolkit.mcurlin.change.domain.expense.ExpenseResponse;
import mediatoolkit.mcurlin.change.domain.user.User;
import mediatoolkit.mcurlin.change.repository.ExpenseRepository;
import mediatoolkit.mcurlin.change.repository.UserRepository;
import mediatoolkit.mcurlin.change.service.ExpenseService;
import mediatoolkit.mcurlin.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, UserRepository userRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public ExpenseResponse add(ExpenseRequest expenseRequest) {
        User userReceivedExpense = userRepository.getById(expenseRequest.getUserReceivedExpenseId());

        if(userReceivedExpense == null){
            return null;
        }

        List<User> userParticipatedInExpense = new ArrayList<>();

        for(Long userId : expenseRequest.getUsersParticipatedInExpenseId()){
            User user = userRepository.getById(userId);
            if(user == null){
                continue;
            }
            userParticipatedInExpense.add(user);
        }

        Expense expense = new Expense(expenseRequest);

        expense.setUserReceivedExpense(userReceivedExpense);
        expense.setUsersParticipatedInExpense(userParticipatedInExpense);

        userService.addExpense(expense);

        return getExpenseResponse(expenseRepository.save(expense));
    }

    @Override
    public ExpenseResponse getById(Long expenseId) {
        return getExpenseResponse(expenseRepository.getById(expenseId));
    }

    private ExpenseResponse getExpenseResponse(Expense expense) {
        return new ExpenseResponse(expense);
    }
}
