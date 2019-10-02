package platform.api.logging;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Data
@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Range(max = 4294967295L)
    @Column(nullable = false, updatable = false, unique = true)
    public Long id;

    private UUID   uuid;
    private String context;

    @CreationTimestamp
    private LocalDateTime stampCreated;

    private String title;

    @Column(length = 1000000)
    private String description;

}
