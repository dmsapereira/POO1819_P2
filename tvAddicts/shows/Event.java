package tvAddicts.shows;

import tvAddicts.characters.Character;

import java.util.List;

public interface Event extends Comparable<Event> {

    String getDescription();

    int getSeason();

    int getEpisode();

    List<Character> getParticipants();
}
