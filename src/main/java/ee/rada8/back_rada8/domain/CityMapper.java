package ee.rada8.back_rada8.domain;

import ee.rada8.back_rada8.forum.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    CityDto toDto(City city);
    List<CityDto> toDtos(List<City> cities);

}