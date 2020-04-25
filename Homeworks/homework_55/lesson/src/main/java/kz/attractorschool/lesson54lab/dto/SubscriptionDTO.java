package kz.attractorschool.lesson54lab.dto;

import kz.attractorschool.lesson54lab.model.Subscription;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class SubscriptionDTO {

    public static SubscriptionDTO from(Subscription subscription) {
        return builder()
                .id(subscription.getId())
                .event(EventDTO.from(subscription.getEvent()))
                .subscriptionDate(subscription.getSubscriptionDate().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public String id;
    public EventDTO event;
    private String subscriptionDate;
}
