package tr.com.merciyes.persistance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.merciyes.commons.model.Event;
import tr.com.merciyes.persistance.entity.EventEntity;
import tr.com.merciyes.persistance.mapper.EventMapper;
import tr.com.merciyes.persistance.persistance.manager.EventRepositoryManager;
import tr.com.merciyes.persistance.service.EventService;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepositoryManager persistenceManager;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> getEvents() {
        return eventMapper.convert(persistenceManager.findAll());
    }

    @Override
    public Event addEvent(Event eventAdditionRequest) {
        // TODO: Validation

        EventEntity toBeCreated = eventMapper.convert(eventAdditionRequest);
        persistenceManager.save(toBeCreated);
        return eventAdditionRequest;
    }
}
