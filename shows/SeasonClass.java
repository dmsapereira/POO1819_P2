package shows;

import java.util.LinkedList;
import java.util.List;

public class SeasonClass implements Season {

    private List<Episode> episodes;

    public SeasonClass() {
        this.episodes = new LinkedList<>();
    }

    @Override
    public void addEpisode(Episode episode) {
        this.addEpisode(episode);
    }

    @Override
    public List<Episode> getEpisodes() {
        return this.episodes;
    }
}
