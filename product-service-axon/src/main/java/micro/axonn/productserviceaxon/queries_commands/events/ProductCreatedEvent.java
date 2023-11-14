package micro.axonn.productserviceaxon.queries_commands.events;

import lombok.Getter;
import micro.axonn.productserviceaxon.queries_commands.enums.ProductStatus;

public class ProductCreatedEvent extends BaseEvent<String> {
    @Getter  private String name ;
    @Getter  private double price;
    @Getter  private ProductStatus status;
    public ProductCreatedEvent(String id, String name, double price, ProductStatus status) {
        super(id);
        this.name = name;
        this.price = price;
        this.status = status;
    }
}
