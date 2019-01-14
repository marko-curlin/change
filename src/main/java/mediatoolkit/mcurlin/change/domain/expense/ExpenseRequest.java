package mediatoolkit.mcurlin.change.domain.expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRequest {

    private Double amount;

    private String description;

    private Long userReceivedExpenseId;

    private List<Long> usersParticipatedInExpenseId;

    public ExpenseRequest(){
        usersParticipatedInExpenseId = new ArrayList<>();
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

    public Long getUserReceivedExpenseId() {
        return userReceivedExpenseId;
    }

    public void setUserReceivedExpenseId(Long userReceivedExpenseId) {
        this.userReceivedExpenseId = userReceivedExpenseId;
    }

    public List<Long> getUsersParticipatedInExpenseId() {
        return usersParticipatedInExpenseId;
    }

    public void addUsersParticipatedInExpenseId(Long usersParticipatedInExpenseId) {
        this.usersParticipatedInExpenseId.add(usersParticipatedInExpenseId);
    }
}
