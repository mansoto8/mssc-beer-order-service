package guru.sfg.beer.order.service.web.mappers;

import java.util.Optional;

import javax.swing.text.html.Option;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.external.BeerService;
import guru.sfg.beer.order.service.services.external.model.BeerDTO;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerOrderLineMapperDecorator
    implements BeerOrderLineMapper
{
  private BeerService beerService;

  private BeerOrderLineMapper mapper;

  @Autowired
  public void setBeerInventoryService(BeerService beerService) {
    this.beerService = beerService;
  }

  @Autowired
  void setMapper(BeerOrderLineMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) {
    BeerOrderLineDto dto = mapper.beerOrderLineToDto(beerOrderLine);
    Optional<BeerDTO> beerDTOOptional = beerService.getBeerByUpc(beerOrderLine.getUpc());

    beerDTOOptional.ifPresent(beerDTO -> {
        dto.setBeerName(beerDTO.getBeerName());
        dto.setBeerId(beerDTO.getId());
    } );

    return dto;
  }

  @Override
  public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto beerOrderLineDto) {
    return mapper.dtoToBeerOrderLine(beerOrderLineDto);
  }
}
