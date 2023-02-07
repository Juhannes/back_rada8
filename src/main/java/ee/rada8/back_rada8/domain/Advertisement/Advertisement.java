package ee.rada8.back_rada8.domain.Advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "header", nullable = false)
    private String header;

    @Size(max = 1000)
    @NotNull
    @Column(name = "body", nullable = false, length = 1000)
    private String body;

    @NotNull
    @Column(name = "created_timestamp", nullable = false)
    private Instant createdTimestamp;

    @NotNull
    @Column(name = "edited_timestamp", nullable = false)
    private Instant editedTimestamp;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "picture")
    private byte[] picture;

}