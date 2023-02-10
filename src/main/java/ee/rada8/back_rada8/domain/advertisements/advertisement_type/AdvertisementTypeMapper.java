package ee.rada8.back_rada8.domain.advertisements.advertisement_type;

import ee.rada8.back_rada8.forum.advertisements.AdvertisementTypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdvertisementTypeMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    AdvertisementTypeDto toDto(AdvertisementType advertisementType);
    List<AdvertisementTypeDto> toDtos(List<AdvertisementType> advertisementTypes);

}