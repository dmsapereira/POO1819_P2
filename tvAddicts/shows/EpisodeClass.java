package tvAddicts.shows;

import java.util.LinkedList;
import java.util.List;

public class EpisodeClass implements Episode {
    private String title;
    private List<Event> events;

    public EpisodeClass(String title){
        this.title=title;
        this.events=new LinkedList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public List<Event> getEvents() {
        return this.events;
    }
}
