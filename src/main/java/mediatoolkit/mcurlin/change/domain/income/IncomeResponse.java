package mediatoolkit.mcurlin.change.domain.income;

import mediatoolkit.mcurlin.change.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class IncomeResponse {

    private Long id;

    private Double amount;

    private String description;

    private User userReceivedIncome;

    private List<User> usersParticipatedInIncome;

    public IncomeResponse(){

    }

    public IncomeResponse(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.description = income.getDescription();
        this.userReceivedIncome = income.getUserReceivedIncome();
        this.usersParticipatedInIncome = income.getUsersParticipatedInIncome();
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

    public User getUserReceivedIncome() {
        return userReceivedIncome;
    }

    public void setUserReceivedIncome(User userReceivedIncome) {
        this.userReceivedIncome = userReceivedIncome;
    }

    public List<User> getUsersParticipatedInIncome() {
        return usersParticipatedInIncome;
    }

    public void setUsersParticipatedInIncome(List<User> usersParticipatedInIncome) {
        this.usersParticipatedInIncome = usersParticipatedInIncome;
    }
}
