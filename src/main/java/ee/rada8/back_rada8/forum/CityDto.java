package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Integer id;
    @Size(max = 20)
    @NotNull
    private final String name;
}