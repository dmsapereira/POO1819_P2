package tvAddicts.exceptions;

import tvAddicts.shows.Show;

public class InvalidSeasonException extends TVAddictException {

    private Show show;
    private int season;

    public InvalidSeasonException(Show show, int season) {
        this.show = show;
        this.season = season;
    }

    @Override
    public String getMessage() {
        return this.show.getName() + " does not have a season " + season + "!";
    }
}
