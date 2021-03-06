package ru.bulatov.unlimintTask.typesOfParse;

public class JsonString {
    private String orderId;              // - идентификатор ордера
    private String amount;          // - сумма ордера
    private String currency;    // - валюта суммы ордера
    private String comment;     // - комментарий по ордеру

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getComment() {
        return comment;
    }
}
