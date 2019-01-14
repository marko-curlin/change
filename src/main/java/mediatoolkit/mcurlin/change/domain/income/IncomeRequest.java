package mediatoolkit.mcurlin.change.domain.income;


import java.util.ArrayList;
import java.util.List;

public class IncomeRequest {

    private Double amount;

    private String description;

    private Long userReceivedIncomeId;

    private List<Long> usersParticipatedInIncomeId;

    public IncomeRequest(){
        usersParticipatedInIncomeId = new ArrayList<>();
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

    public Long getUserReceivedIncomeId() {
        return userReceivedIncomeId;
    }

    public void setUserReceivedIncomeId(Long userReceivedIncomeId) {
        this.userReceivedIncomeId = userReceivedIncomeId;
    }

    public List<Long> getUsersParticipatedInIncomeId() {
        return usersParticipatedInIncomeId;
    }

    public void addUsersParticipatedInIncomeId(Long usersParticipatedInIncomeId) {
        this.usersParticipatedInIncomeId.add(usersParticipatedInIncomeId);
    }
}
