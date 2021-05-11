package sample.model;

public class Car {
    private String mark;
    private String model;
    private Integer price;
    private Integer tonnage;

    public Car() {
    }

    public Car(String mark, String model, Integer price, Integer tonnage) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.tonnage = tonnage;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTonnage() {
        return tonnage;
    }

    public void setTonnage(Integer tonnage) {
        this.tonnage = tonnage;
    }
}
