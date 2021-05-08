package guru.sfg.beer.order.service.services.external.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO implements Serializable
{
  static final long serialVersionUID = 999667790473683369L;

  private UUID id;
  private Integer version;
  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;
  private String beerName;
  private String beerStyle;
  private String upc;
  private BigDecimal price;
  private Integer quantityOnHand;
}