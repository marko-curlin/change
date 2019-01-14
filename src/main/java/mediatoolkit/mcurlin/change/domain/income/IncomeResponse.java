package mediatoolkit.mcurlin.change.domain.income;

public class IncomeResponse {

    private Long id;

    private Double amount;

    private String description;

    public IncomeResponse(){

    }

    public IncomeResponse(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.description = income.getDescription();
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


    @Override
    public String toString() {
        return "IncomeResponse{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
