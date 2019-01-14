package mediatoolkit.mcurlin.change.domain.expense;

import mediatoolkit.mcurlin.change.domain.user.User;

import java.util.List;

public class ExpenseResponse {

    private Long id;

    private Double amount;

    private String description;

    private User userReceivedExpense;

    private List<User> usersParticipatedInExpense;

    public ExpenseResponse(){

    }

    public ExpenseResponse(Expense expense) {
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.description = expense.getDescription();
        this.userReceivedExpense = expense.getUserReceivedExpense();
        this.usersParticipatedInExpense = expense.getUsersParticipatedInExpense();
//                .stream().map(i -> i.getId()).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserReceivedExpense() {
        return userReceivedExpense;
    }

    public void setUserReceivedExpense(User userReceivedExpense) {
        this.userReceivedExpense = userReceivedExpense;
    }

    public List<User> getUsersParticipatedInExpense() {
        return usersParticipatedInExpense;
    }

    public void setUsersParticipatedInExpense(List<User> usersParticipatedInExpense) {
        this.usersParticipatedInExpense = usersParticipatedInExpense;
    }
}
