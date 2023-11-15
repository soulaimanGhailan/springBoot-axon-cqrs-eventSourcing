package micro.axonn.productserviceaxon.commands.aggregate;

import micro.axonn.productserviceaxon.queries_commands.commands.CreateProductCommand;
import micro.axonn.productserviceaxon.queries_commands.commands.UpdateProductCommand;
import micro.axonn.productserviceaxon.queries_commands.enums.ProductStatus;
import micro.axonn.productserviceaxon.queries_commands.events.ProductCreatedEvent;
import micro.axonn.productserviceaxon.queries_commands.events.ProductUpdatedEvent;
import micro.axonn.productserviceaxon.queries_commands.exceptions.ProductPriceNegativeException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name ;
    private double price;
    private ProductStatus status;

    public ProductAggregate() { }// important (used by axon)

    /** Create Product Command handler  **/
    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        if(command.getPrice()<0) throw new ProductPriceNegativeException("price < 0") ;
        AggregateLifecycle.apply(new ProductCreatedEvent(command.getId() ,command.getName() , command.getPrice() , ProductStatus.ADDED));
    }

    /** update the state function  **/
    @EventSourcingHandler
    public void update(ProductCreatedEvent event){
        this.productId = event.getId() ;
        this.price=event.getPrice();
        this.status=event.getStatus();
        this.name=event.getName();
    }

    /** copy paste **/
    @CommandHandler
    public void handle(UpdateProductCommand command){
        // id do not match exception
        AggregateLifecycle.apply(new ProductUpdatedEvent(command.getId() ,command.getName() , command.getPrice() , ProductStatus.UPDATED));
    }
    @EventSourcingHandler
    public void update(ProductUpdatedEvent event){
        this.price=event.getPrice();
        this.status=event.getStatus();
        this.name=event.getName();
    }

}
