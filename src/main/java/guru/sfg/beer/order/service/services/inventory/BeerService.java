package guru.sfg.beer.order.service.services.inventory;

import guru.sfg.beer.order.service.services.inventory.model.BeerDTO;

public interface BeerService
{
  BeerDTO getBeerByUpc(String upc);
}
