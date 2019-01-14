package mediatoolkit.mcurlin.change.domain.interchange;

import mediatoolkit.mcurlin.change.domain.user.User;

public class InterchangeResponse {

    private Long id;

    private Double amount;

    private String description;

    private User userGiver;

    private User userReceiver;

    public InterchangeResponse(){

    }

    public InterchangeResponse(Interchange interchange) {
        this.amount = interchange.getAmount();
        this.description = interchange.getDescription();
        this.userGiver = interchange.getUserGiver();
        this.userReceiver = interchange.getUserReceiver();
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
