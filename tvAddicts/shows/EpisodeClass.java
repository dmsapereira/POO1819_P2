package tvAddicts.shows;

import java.util.LinkedList;
import java.util.List;

public class EpisodeClass implements Episode {
    private String title;
    private List<Event> events;
    private int seasonNumber, episodeNumber;

    public EpisodeClass(String title, int seasonNumber, int episodeNumber) {
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.title=title;
        this.events=new LinkedList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getSeasonNumber() {
        return this.seasonNumber;
    }

    @Override
    public int getEpisodeNumber() {
        return this.episodeNumber;
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
