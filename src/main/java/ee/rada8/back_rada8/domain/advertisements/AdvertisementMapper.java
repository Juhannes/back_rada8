package ee.rada8.back_rada8.domain.advertisements;

import ee.rada8.back_rada8.forum.advertisements.AdvertisementDto;
import ee.rada8.back_rada8.forum.advertisements.AdvertisementResponse;
import org.mapstruct.*;
import ee.rada8.back_rada8.util.PictureUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface AdvertisementMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "header", target = "header")
    @Mapping(source = "body", target = "body")
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

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "header", target = "header")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "createdTimestamp", target = "createdTimestamp")
    @Mapping(source = "editedTimestamp", target = "editedTimestamp")
    @Mapping(source = "status", target = "status")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(advertisement.getPicture()))", target = "picture")
    AdvertisementDto toDto(Advertisement advertisement);

    List<AdvertisementDto> toDtos(List<Advertisement> advertisements);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "header", target = "header")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "createdTimestamp", target = "createdTimestamp")
    @Mapping(source = "editedTimestamp", target = "editedTimestamp")
    @Mapping(source = "status", target = "status")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(advertisement.getPicture()))", target = "picture")
    AdvertisementResponse toResponse(Advertisement advertisement);

   }