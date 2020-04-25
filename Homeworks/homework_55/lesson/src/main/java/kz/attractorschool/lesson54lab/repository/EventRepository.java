package kz.attractorschool.lesson54lab.repository;

import kz.attractorschool.lesson54lab.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, String> {

}
