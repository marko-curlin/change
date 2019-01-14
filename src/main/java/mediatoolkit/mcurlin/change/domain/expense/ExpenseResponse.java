package mediatoolkit.mcurlin.change.domain.expense;

import mediatoolkit.mcurlin.change.domain.user.User;

import java.util.List;

public class ExpenseResponse {

    private Long id;

    private Double amount;

    private String description;

    public ExpenseResponse(){

    }

    public ExpenseResponse(Expense expense) {
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.description = expense.getDescription();
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
        return "ExpenseResponse{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
