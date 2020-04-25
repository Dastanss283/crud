package kz.attractorschool.lesson54lab.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document("events")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Event {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String description;

    @Indexed
    @Builder.Default
    private LocalDateTime eventDate = LocalDateTime.now();
}
