package mediatoolkit.mcurlin.change.domain.user;

import mediatoolkit.mcurlin.change.domain.expense.Expense;
import mediatoolkit.mcurlin.change.domain.income.Income;
import mediatoolkit.mcurlin.change.domain.interchange.Interchange;

import javax.persistence.*;
import java.util.List;

public class UserResponse {

    private Long id;

    private String name;

    private String surname;
//
//    private List<Income> receivedIncome;
//
//    private List<Income> participatedIncome;
//
//    private List<Expense> receivedExpense;
//
//    private List<Expense> participatedExpense;
//
//    private List<Interchange> givenInterchange;
//
//    private List<Interchange> receivedInterchange;

    private Double balance;

    public UserResponse(){

    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
//        this.receivedIncome = user.getReceivedIncome();
//        this.participatedIncome = user.getParticipatedIncome();
//        this.receivedExpense = user.getReceivedExpense();
//        this.participatedExpense = user.getParticipatedExpense();
//        this.givenInterchange = user.getGivenInterchange();
//        this.receivedInterchange = user.getReceivedInterchange();
        this.balance = user.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public List<Income> getReceivedIncome() {
//        return receivedIncome;
//    }
//
//    public void setReceivedIncome(List<Income> receivedIncome) {
//        this.receivedIncome = receivedIncome;
//    }
//
//    public List<Income> getParticipatedIncome() {
//        return participatedIncome;
//    }
//
//    public void setParticipatedIncome(List<Income> participatedIncome) {
//        this.participatedIncome = participatedIncome;
//    }
//
//    public List<Expense> getReceivedExpense() {
//        return receivedExpense;
//    }
//
//    public void setReceivedExpense(List<Expense> receivedExpense) {
//        this.receivedExpense = receivedExpense;
//    }
//
//    public List<Expense> getParticipatedExpense() {
//        return participatedExpense;
//    }
//
//    public void setParticipatedExpense(List<Expense> participatedExpense) {
//        this.participatedExpense = participatedExpense;
//    }
//
//    public List<Interchange> getGivenInterchange() {
//        return givenInterchange;
//    }
//
//    public void setGivenInterchange(List<Interchange> givenInterchange) {
//        this.givenInterchange = givenInterchange;
//    }
//
//    public List<Interchange> getReceivedInterchange() {
//        return receivedInterchange;
//    }
//
//    public void setReceivedInterchange(List<Interchange> receivedInterchange) {
//        this.receivedInterchange = receivedInterchange;
//    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
