package micro.axonn.productserviceaxon.queries_commands.commands;

import lombok.Getter;

public class UpdateProductCommand extends BaseCommand<String> {
    @Getter  private String name ;
    @Getter private double price ;
    public UpdateProductCommand(String id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }
}
