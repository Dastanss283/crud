package kz.attractorschool.lesson54lab.repository;

import kz.attractorschool.lesson54lab.model.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
    List<Subscription> findByEmail(String email, Pageable pageable);

    Optional<Subscription> findByEmailAndId(String email, String subId);

    Optional<Subscription> findByEmailAndEventId(String email, String eventId);
}
