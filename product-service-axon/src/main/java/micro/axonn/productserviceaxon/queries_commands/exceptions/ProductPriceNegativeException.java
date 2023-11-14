package micro.axonn.productserviceaxon.queries_commands.exceptions;

public class ProductPriceNegativeException extends RuntimeException {
    public ProductPriceNegativeException(String message) {
        super(message);
    }
}
