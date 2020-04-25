package kz.attractorschool.lesson54lab.dto;

import kz.attractorschool.lesson54lab.model.Event;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class EventDTO {
    private static final EventDTO NO_EVENT = builder().name("--bad reference--").build();

    public static EventDTO from(Event event) {
        if (event == null) {
            return NO_EVENT;
        }

        return builder()
                .id(event.getId())
                .description(event.getDescription())
                .name(event.getName())
                .eventDate(event.getEventDate().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public String id;
    public String name;
    public String description;
    public String eventDate;
}
