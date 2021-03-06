package ru.bulatov.unlimintTask;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class OutString {       // строка для выходных данных

    private int id = 0;              // - идентификатор ордера
    private double amount = 0;       // - сумма ордера
    private String currency = "";    // - валюта суммы ордера
    private String comment = "";     // - комментарий по ордеру
    private String filename = "";    // имя исходного файла
    private int line = 0;            // - номер строки исходного файла
    private String result = "OK";    // - результат парсинга записи исходного файла. ОК - по умолчанию.

    public OutString(int id, String amount, String currency, String comment, String filename, int line) {
        this.id = id;
        try {
            this.amount = Double.parseDouble(amount);
        }
        catch (NumberFormatException exception) {
            result = "NumberFormatException: " + "поле amount должно быть числом!";
        }
        this.currency = currency;
        this.comment = comment;
        this.filename = filename;
        this.line = line;
    }

    @Override
    public String toString() {
        NumberFormat nf = new DecimalFormat("#.######");
        return "{" +
                "\"id\":" + id +
                ", \"amount\":" + nf.format(amount) +
                ", \"comment\":\"" + comment + '\"' +
                ", \"filename\":\"" + filename + '\"' +
                ", \"line\":" + line +
                ", \"result\":\"" + result + '\"' +
                '}';
    }
}
