package tvAddicts.characters;

import tvAddicts.shows.Event;
import tvAddicts.shows.Show;

import java.util.List;
import java.util.Set;

public interface Character extends Comparable<Character> {

    String getName();

    Show getShow();

    void addRelationship(boolean parentFound, Character character);

    List<Character> getParents();

    List<Character> getKids();

    List<Character> getSiblings();

    void addRomance(Character character);

    List<Character> getRomances();

    void addEvent(Event event);

    Set<Event> getEvents();

    void addQuote(Quote quote);

    List getQuotes();



}
