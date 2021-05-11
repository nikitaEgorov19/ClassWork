package sample.model;

import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.StringProperty;

public class Car {
    private StringProperty mark;
    private StringProperty model;
    private IntegerProperty price;
    private IntegerProperty tonnage;

    public Car(String mark, String model, int price, int tonnage) {
    }

    public Car(StringProperty mark, StringProperty model, IntegerProperty price, IntegerProperty tonnage) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.tonnage = tonnage;
    }

    public StringProperty getMark() {
        return mark;
    }
    public StringProperty getMarkProperty() {
        return mark;
    }

    public void setMark(StringProperty mark) {
        this.mark = mark;
    }

    public StringProperty getModel() {
        return model;
    }
    public StringProperty getModelProperty() {
        return model;
    }

    public void setModel(StringProperty model) {
        this.model = model;
    }

    public IntegerProperty getPrice() {
        return price;
    }
    public IntegerProperty getPriceProperty() {
        return price;
    }

    public void setPrice(IntegerProperty price) {
        this.price = price;
    }

    public IntegerProperty getTonnage() {
        return tonnage;
    }
    public IntegerProperty getTonnageProperty() {
        return tonnage;
    }

    public void setTonnage(IntegerProperty tonnage) {
        this.tonnage = tonnage;
    }


}
