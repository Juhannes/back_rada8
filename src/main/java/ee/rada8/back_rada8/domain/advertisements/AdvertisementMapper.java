package ee.rada8.back_rada8.domain.advertisements;

import ee.rada8.back_rada8.forum.advertisements.AdvertisementDto;
import org.mapstruct.*;
import ee.rada8.back_rada8.util.PictureUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface AdvertisementMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "header", target = "header")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "typeId", target = "type.id")
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "createdTimestamp", target = "createdTimestamp")
    @Mapping(source = "modifiedTimestamp", target = "editedTimestamp")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    Advertisement toEntity(AdvertisementDto advertisementDto);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        if (picture == null || "".equals(picture)) {
            return null;
        }
        byte[] bytes = picture.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Advertisement updateAdvertisement(AdvertisementDto advertisementDto, @MappingTarget Advertisement advertisement);

    @Mapping(source = "id", target = "advertisementId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "header", target = "header")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "createdTimestamp", target = "createdTimestamp")
    @Mapping(source = "editedTimestamp", target = "modifiedTimestamp")
    @Mapping(source = "status", target = "status")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(advertisement.getPicture()))", target = "picture")
    AdvertisementDto toDto(Advertisement advertisement);


    List<AdvertisementDto> toDtos(List<Advertisement> advertisements);
}