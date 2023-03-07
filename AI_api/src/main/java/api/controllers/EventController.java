package api.controllers;

import api.Authentication;
import api.models.Event;
import api.models.ReceivedEvent;
import api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventController {
  @Autowired private EventService eventService;

  @PostMapping("/add")
  public void addEvent(@RequestHeader String authorize, @RequestBody ReceivedEvent receivedEvent) {
    if (!Authentication.verifyUser(authorize)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    try {
      this.eventService.addEvent(new Event(receivedEvent));
    } catch (Exception exception) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }
}
