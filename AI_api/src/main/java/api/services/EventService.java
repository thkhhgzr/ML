package api.services;

import api.models.Event;
import api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
  @Autowired private EventRepository eventRepository;

  public void addEvent(Event event) {
    this.eventRepository.save(event);
  }
}
