package micro.axonn.productserviceaxon.queries_commands.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
public class BaseCommand<T> {
    @TargetAggregateIdentifier
    @Getter private T id ;
}
