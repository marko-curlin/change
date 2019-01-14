package mediatoolkit.mcurlin.change.domain.income;

import mediatoolkit.mcurlin.change.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User userReceivedIncome;

    @ManyToMany
    @JoinTable(name = "participant_income", joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "income_id", referencedColumnName = "id"))
    private List<User> usersParticipatedInIncome;

    public Income(){

    }

    public Income(IncomeRequest incomeRequest){
        this.amount = incomeRequest.getAmount();
        this.description = incomeRequest.getDescription();
    }

    public Income(Double amount, String description, User userReceivedIncome, List<User> usersParticipatedInIncome) {
        this.amount = amount;
        this.description = description;
        this.userReceivedIncome = userReceivedIncome;
        this.usersParticipatedInIncome = usersParticipatedInIncome;
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
