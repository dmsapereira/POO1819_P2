package tvAddicts.shows;

import java.util.List;

public interface Episode {

    String getTitle();

    void addEvent(Event event);

    List<Event> getEvents();
}
