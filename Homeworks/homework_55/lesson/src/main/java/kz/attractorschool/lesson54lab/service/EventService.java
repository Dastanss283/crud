package kz.attractorschool.lesson54lab.service;

import kz.attractorschool.lesson54lab.dto.EventDTO;
import kz.attractorschool.lesson54lab.repository.EventRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<EventDTO> findEvents(Pageable pageable) {
        return repository.findAll(pageable)
                .stream()
                .map(EventDTO::from)
                .collect(Collectors.toList());
    }
}
