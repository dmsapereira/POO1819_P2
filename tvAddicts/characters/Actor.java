package tvAddicts.characters;

import tvAddicts.shows.Show;

import java.util.List;

public interface Actor extends Comparable<Actor> {

    String getName();

    void addCharacter(RealCharacter character);

    int getNumberOfRomances();

    List<RealCharacter> getRoles();

    List<Show> getShowsParticipated();

    int getNumberOfShowsWithRomance();
}
