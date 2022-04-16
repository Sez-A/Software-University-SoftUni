package bg.softuni.events;

import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.logging.Logger;

public class EventsListener implements ApplicationListener<SpringApplicationEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventsListener.class);

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {

    }
}
