package guru.sfg.beer.order.service.services.external;

import java.util.Optional;

import guru.sfg.beer.order.service.services.external.model.BeerDTO;

public interface BeerService
{
  Optional<BeerDTO> getBeerByUpc(String upc);
}
