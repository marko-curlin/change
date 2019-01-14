package mediatoolkit.mcurlin.change.domain.expense;

import mediatoolkit.mcurlin.change.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User userReceivedExpense;

    @ManyToMany
    @JoinTable(name = "participant_expense", joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "id"))
    private List<User> usersParticipatedInExpense;

    public Expense(){

    }

    public Expense(ExpenseRequest expenseRequest){
        this.amount = expenseRequest.getAmount();
        this.description = expenseRequest.getDescription();
    }

    public Expense(Double amount, String description, User userReceivedExpense, List<User> usersParticipatedInExpense) {
        this.amount = amount;
        this.description = description;
        this.userReceivedExpense = userReceivedExpense;
        this.usersParticipatedInExpense = usersParticipatedInExpense;
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
