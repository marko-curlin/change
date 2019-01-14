package mediatoolkit.mcurlin.change.domain.user;


import mediatoolkit.mcurlin.change.domain.expense.Expense;
import mediatoolkit.mcurlin.change.domain.income.Income;
import mediatoolkit.mcurlin.change.domain.interchange.Interchange;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "userReceivedIncome")
    private List<Income> receivedIncome;

    @ManyToMany(mappedBy = "usersParticipatedInIncome")
    private List<Income> participatedIncome;


    @OneToMany(mappedBy = "userReceivedExpense")
    private List<Expense> receivedExpense;

    @ManyToMany(mappedBy = "usersParticipatedInExpense")
    private List<Expense> participatedExpense;

    @OneToMany(mappedBy = "userGiver")
    private List<Interchange> givenInterchange;

    @OneToMany(mappedBy = "userReceiver")
    private List<Interchange> receivedInterchange;

    private Double balance;

    public User(){

    }

    public User(String name, String surname, List<Income> participatedIncome, List<Expense> participatedExpense,
                List<Interchange> receivedInterchange, Double balance) {
        this.name = name;
        this.surname = surname;
        this.participatedIncome = participatedIncome;
        this.participatedExpense = participatedExpense;
        this.balance = balance;
        this.receivedInterchange = receivedInterchange;
    }

    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.surname = userRequest.getSurname();
        this.participatedIncome = new ArrayList<>();
        this.participatedExpense = new ArrayList<>();
        this.receivedInterchange = new ArrayList<>();
        this.balance = new Double(0);
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

    public List<Income> getParticipatedIncome() {
        return participatedIncome;
    }

    public void addParticipatedIncome(Income income) {
        this.participatedIncome.add(income);
    }

    public List<Expense> getParticipatedExpense() {
        return participatedExpense;
    }

    public void addParticipatedExpense(Expense expense) {
        this.participatedExpense.add(expense);
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Interchange> getReceivedInterchange() {
        return receivedInterchange;
    }

    public void addReceivedInterchange(Interchange interchange) {
        this.receivedInterchange.add(interchange);
    }

    public void setReceivedIncome(List<Income> receivedIncome) {
        this.receivedIncome = receivedIncome;
    }

    public void setParticipatedIncome(List<Income> participatedIncome) {
        this.participatedIncome = participatedIncome;
    }

    public List<Expense> getReceivedExpense() {
        return receivedExpense;
    }

    public void setReceivedExpense(List<Expense> receivedExpense) {
        this.receivedExpense = receivedExpense;
    }

    public void setParticipatedExpense(List<Expense> participatedExpense) {
        this.participatedExpense = participatedExpense;
    }

    public List<Interchange> getGivenInterchange() {
        return givenInterchange;
    }

    public void setGivenInterchange(List<Interchange> givenInterchange) {
        this.givenInterchange = givenInterchange;
    }

    public void setReceivedInterchange(List<Interchange> receivedInterchange) {
        this.receivedInterchange = receivedInterchange;
    }
}
