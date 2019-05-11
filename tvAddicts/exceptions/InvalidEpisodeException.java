package tvAddicts.exceptions;

import tvAddicts.shows.Show;

public class InvalidEpisodeException extends TVAddictException {

    private Show show;
    private int season, episode;

    public InvalidEpisodeException(Show show, int season, int episode) {
        this.show = show;
        this.season = season;
        this.episode = episode;
    }

    @Override
    public String getMessage() {
        return this.show.getName() + " S" + this.season + " does not have episode " + this.episode + "!";
    }
}
