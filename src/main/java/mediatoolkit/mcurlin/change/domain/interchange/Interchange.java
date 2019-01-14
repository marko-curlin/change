package mediatoolkit.mcurlin.change.domain.interchange;

import mediatoolkit.mcurlin.change.domain.user.User;

import javax.persistence.*;

@Entity
public class Interchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "giver_id")
    private User userGiver;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User userReceiver;

    public Interchange(){

    }

    public Interchange(Double amount, String description, User userGiver, User userReceiver) {
        this.amount = amount;
        this.description = description;
        this.userGiver = userGiver;
        this.userReceiver = userReceiver;
    }

    public Interchange(InterchangeRequest interchangeRequest) {
        this.amount = interchangeRequest.getAmount();
        this.description = interchangeRequest.getDescription();
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

    public User getUserGiver() {
        return userGiver;
    }

    public void setUserGiver(User userGiver) {
        this.userGiver = userGiver;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }
}
