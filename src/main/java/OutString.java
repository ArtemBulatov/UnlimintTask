
// строка выходных данных

public class OutString {

    private int id = 0;              // - идентификатор ордера
    private int amount = 0;          // - сумма ордера
    private String currency = "";    // - валюта суммы ордера
    private String comment = "";     // - комментарий по ордеру
    private String filename = "";    // имя исходного файла
    private int line = 0;            // - номер строки исходного файла
    private String result = "OK";    // - результат парсинга записи исходного файла. ОК - по умолчанию.

    public OutString(String filename, int line, String result) {
        this.filename = filename;
        this.line = line;
        this.result = result;
    }

    public OutString(String id, String amount, String currency, String comment, String filename, int line) {
        try {
            this.id = Integer.parseInt(id);
        }
        catch (NumberFormatException exception) {
            result = "NumberFormatException: " + "поле id должно быть числом!";
        }

        try {
            this.amount = Integer.parseInt(amount);
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
        return "{" +
                "\"id\":" + id +
                ", \"amount\":" + amount +
                ", \"comment\":\"" + comment + '\"' +
                ", \"filename\":\"" + filename + '\"' +
                ", \"line\":" + line +
                ", \"result\":\"" + result + '\"' +
                '}';
    }
}
