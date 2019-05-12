package tvAddicts.shows;

import java.util.List;

public interface Episode {

    String getTitle();

    int getSeasonNumber();

    int getEpisodeNumber();

    void addEvent(Event event);

    List<Event> getEvents();
}
