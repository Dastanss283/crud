package kz.attractorschool.lesson54lab.controller;

import kz.attractorschool.lesson54lab.dto.EventDTO;
import kz.attractorschool.lesson54lab.dto.SubscriptionResult;
import kz.attractorschool.lesson54lab.service.EventService;
import kz.attractorschool.lesson54lab.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final SubscriptionService subscriptionService;

    public EventController(EventService eventService, SubscriptionService subscriptionService) {
        this.eventService = eventService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<EventDTO> findEvents(@ApiIgnore Pageable pageable) {
        return eventService.findEvents(pageable);
    }

    @PostMapping(value = "/{eventId}/subscribe")
    public SubscriptionResult subscribe(@PathVariable String eventId, @RequestParam String email) {
        return subscriptionService.subscribe(eventId, email);
    }
}
