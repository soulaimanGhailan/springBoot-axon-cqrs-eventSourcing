package micro.axonn.productserviceaxon.queries.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import micro.axonn.productserviceaxon.queries_commands.enums.ProductStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Product {
    @Id
    private String id ;
    private String name ;
    private double price;
    private Date addingDate;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}
