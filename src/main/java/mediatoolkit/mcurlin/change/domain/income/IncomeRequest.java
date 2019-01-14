package mediatoolkit.mcurlin.change.domain.income;

import mediatoolkit.mcurlin.change.domain.user.User;

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

//    public IncomeRequest(Long id, Double amount, String description, Long userReceivedIncomeId, List<Long> usersParticipatedInIncomeId) {
//        this.id = id;
//        this.amount = amount;
//        this.description = description;
//        this.userReceivedIncomeId = userReceivedIncomeId;
//        this.usersParticipatedInIncomeId = usersParticipatedInIncomeId;
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
