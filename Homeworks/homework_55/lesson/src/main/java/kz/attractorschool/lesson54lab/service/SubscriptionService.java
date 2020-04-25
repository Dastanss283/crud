package kz.attractorschool.lesson54lab.service;

import kz.attractorschool.lesson54lab.dto.SubscriptionDTO;
import kz.attractorschool.lesson54lab.dto.SubscriptionResult;
import kz.attractorschool.lesson54lab.model.Subscription;
import kz.attractorschool.lesson54lab.repository.EventRepository;
import kz.attractorschool.lesson54lab.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final EventRepository eventRepository;

    public List<SubscriptionDTO> findByEmail(String email, Pageable pageable) {
        return subscriptionRepository.findByEmail(email, pageable)
                .stream()
                .map(SubscriptionDTO::from)
                .collect(Collectors.toList());
    }

    public SubscriptionResult unsubscribe(String subId, String email) {
        var sub = subscriptionRepository.findByEmailAndId(email, subId);
        var builder = SubscriptionResult.builder().message("not subscribed");
        sub.ifPresent(s -> {
            builder.subId(s.getId()).message("unsubscribed");
            subscriptionRepository.delete(s);
        });
        return builder.build();
    }

    public SubscriptionResult subscribe(String eventId, String email) {
        var subscription = subscriptionRepository.findByEmailAndEventId(email, eventId);

        if (subscription.isPresent()) {
            return SubscriptionResult.builder()
                    .message("Already subscribed")
                    .subId(subscription.get().getId())
                    .build();
        }

        var rawEvent = eventRepository.findById(eventId);

        if (!rawEvent.isPresent()) {
            return SubscriptionResult.builder()
                    .message("Can't subscribe. The event not found")
                    .build();
        }

        var event = rawEvent.get();

        if (event.getEventDate().isBefore(LocalDateTime.now())) {
            return SubscriptionResult.builder()
                    .message("Can't subscribe. The event has already passed.")
                    .build();
        }

        var sub = Subscription.builder()
                .email(email)
                .event(event)
                .subscriptionDate(LocalDateTime.now())
                .build();

        subscriptionRepository.save(sub);

        return SubscriptionResult.builder()
                .message("Successfully subscribed.")
                .subId(sub.getId())
                .build();
    }
}
