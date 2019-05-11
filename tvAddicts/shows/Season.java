package tvAddicts.shows;

import java.util.List;

public interface Season {

    void addEpisode(Episode episode);

    List<Episode> getEpisodes();

}
