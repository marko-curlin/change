package mediatoolkit.mcurlin.change.controller;

import mediatoolkit.mcurlin.change.domain.expense.ExpenseRequest;
import mediatoolkit.mcurlin.change.domain.expense.ExpenseResponse;
import mediatoolkit.mcurlin.change.domain.income.IncomeRequest;
import mediatoolkit.mcurlin.change.domain.income.IncomeResponse;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeRequest;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeResponse;
import mediatoolkit.mcurlin.change.domain.user.UserRequest;
import mediatoolkit.mcurlin.change.domain.user.UserResponse;
import mediatoolkit.mcurlin.change.service.ExpenseService;
import mediatoolkit.mcurlin.change.service.IncomeService;
import mediatoolkit.mcurlin.change.service.InterchangeService;
import mediatoolkit.mcurlin.change.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final IncomeService incomeService;
    private final UserService userService;
    private final ExpenseService expenseService;
    private final InterchangeService interchangeService;

    @Autowired
    public ApiController(IncomeService incomeService, UserService userService, ExpenseService expenseService, InterchangeService interchangeService) {
        this.incomeService = incomeService;
        this.userService = userService;
        this.expenseService = expenseService;
        this.interchangeService = interchangeService;
    }

    @PostMapping("/api/add-income")
    public IncomeResponse addIncome(@RequestBody IncomeRequest incomeRequest) {
        return incomeService.add(incomeRequest);
    }

    @GetMapping("/api/income/{incomeId}")
    public IncomeResponse getIncomeById(@PathVariable Long incomeId) {
        return incomeService.getById(incomeId);
    }

    @PostMapping("/api/add-expense")
    public ExpenseResponse addExpense(@RequestBody ExpenseRequest expenseRequest) {
        return expenseService.add(expenseRequest);
    }

    @GetMapping("/api/expense/{expenseId}")
    public ExpenseResponse getExpenseById(@PathVariable Long expenseId) {
        return expenseService.getById(expenseId);
    }

    @PostMapping("/api/add-user")
    public UserResponse addUser(@RequestBody UserRequest userRequest){
        return userService.add(userRequest);
    }

    @GetMapping("/api/user/{userId}")
    public UserResponse getUser(@PathVariable Long userId){
        return userService.getById(userId);
    }

    @GetMapping("/api/user")
    public List<UserResponse> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/api/add-interchange")
    public InterchangeResponse addInterchange(@RequestBody InterchangeRequest interchangeRequest){
        return interchangeService.add(interchangeRequest);
    }


}
