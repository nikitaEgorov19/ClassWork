package sample.model;

public class Order {
    private Integer order_weight;

    public Order() {
    }

    public Order(Integer order_weight) {
        this.order_weight = order_weight;
    }

    public Integer getOrder_weight() {
        return order_weight;
    }

    public void setOrder_weight(Integer order_weight) {
        this.order_weight = order_weight;
    }
}
