package kz.attractorschool.lesson54lab.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document("subscriptions")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Subscription {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Indexed
    private String email;

    @DBRef
    private Event event;

    private LocalDateTime subscriptionDate;
}
