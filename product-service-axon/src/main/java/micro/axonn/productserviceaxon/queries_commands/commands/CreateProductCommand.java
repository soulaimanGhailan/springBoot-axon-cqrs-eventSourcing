package micro.axonn.productserviceaxon.queries_commands.commands;

import lombok.Getter;

public class CreateProductCommand extends BaseCommand<String>{
    @Getter private double price ;
    @Getter private String name  ;
    public CreateProductCommand(String id, double price , String name) {
        super(id);
        this.price = price;
        this.name = name;
    }
}
