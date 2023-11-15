package micro.axonn.productserviceaxon.queries_commands.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UpdateProductDto {
    private String productId;
    private String name ;
    private double price ;
}
