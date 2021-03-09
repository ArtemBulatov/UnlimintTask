package ru.bulatov.unlimintTask.typesOfParse;

public class JsonString {
        private String orderId;              // - идентификатор ордера
        private String amount;          // - сумма ордера
        private String currency;    // - валюта суммы ордера
        private String comment;     // - комментарий по ордеру

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
