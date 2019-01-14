package mediatoolkit.mcurlin.change.domain.interchange;


public class InterchangeRequest {

    private Double amount;

    private String description;

    private Long userGiverId;

    private Long userReceiverId;

    public InterchangeRequest(Double amount, String description, Long userGiverId, Long userReceiverId) {
        this.amount = amount;
        this.description = description;
        this.userGiverId = userGiverId;
        this.userReceiverId = userReceiverId;
    }

    public InterchangeRequest() {

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

    public Long getUserGiverId() {
        return userGiverId;
    }

    public void setUserGiverId(Long userGiverId) {
        this.userGiverId = userGiverId;
    }

    public Long getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(Long userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

}
