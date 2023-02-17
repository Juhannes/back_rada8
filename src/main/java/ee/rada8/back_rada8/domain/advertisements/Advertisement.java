package ee.rada8.back_rada8.domain.advertisements;

import ee.rada8.back_rada8.domain.City;
import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "header", nullable = false)
    private String header;

    @Size(max = 1000)
    @NotNull
    @Column(name = "body", nullable = false, length = 1000)
    private String body;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private AdvertisementType type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotNull
    @Column(name = "created_timestamp", nullable = false)
    private Instant createdTimestamp;

    @NotNull
    @Column(name = "edited_timestamp", nullable = false)
    private Instant editedTimestamp;

    @Size(max = 1)
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "picture")
    private byte[] picture;

}