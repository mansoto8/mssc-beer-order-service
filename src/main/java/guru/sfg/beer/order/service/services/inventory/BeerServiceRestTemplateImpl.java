package guru.sfg.beer.order.service.services.inventory;

import java.util.UUID;

import guru.sfg.beer.order.service.services.inventory.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BeerServiceRestTemplateImpl
    implements BeerService
{
  private final String INVENTORY_PATH = "/api/v1/beer/upc/{upc}";

  private final RestTemplate restTemplate;

  private String beerInventoryServiceHost;

  public void setBeerInventoryServiceHost(String beerInventoryServiceHost) {
    this.beerInventoryServiceHost = beerInventoryServiceHost;
  }

  public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public BeerDTO getBeerByUpc(String upc) {
    log.debug("Calling beer service");

    ResponseEntity<BeerDTO> responseEntity = restTemplate
        .exchange(beerInventoryServiceHost + INVENTORY_PATH, HttpMethod.GET, null,
            new ParameterizedTypeReference<BeerDTO>() { }, (Object) upc
        );

    return responseEntity.getBody();
  }
}
