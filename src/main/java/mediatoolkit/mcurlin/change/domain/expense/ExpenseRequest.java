package mediatoolkit.mcurlin.change.domain.expense;

import mediatoolkit.mcurlin.change.domain.user.User;

import java.util.List;

public class ExpenseRequest {

    private Double amount;

    private String description;

    private Long userReceivedExpenseId;

    private List<Long> usersParticipatedInExpenseId;

    public ExpenseRequest(){

    }

//    public ExpenseRequest(Long id, Double amount, String description, Long userReceivedExpenseId, List<Long> usersParticipatedInExpenseId) {
//        this.id = id;
//        this.amount = amount;
//        this.description = description;
//        this.userReceivedExpenseId = userReceivedExpenseId;
//        this.usersParticipatedInExpenseId = usersParticipatedInExpenseId;
//    }

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

    public void setUsersParticipatedInExpenseId(List<Long> usersParticipatedInExpenseId) {
        this.usersParticipatedInExpenseId = usersParticipatedInExpenseId;
    }
}
