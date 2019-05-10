package characters;

import shows.Event;

import java.util.List;

public interface Character {

    String getName();

    void addRelationship(boolean parentFound, Character character);

    List<Character> getParents();

    List<Character> getKids();

    List<Character> getSiblings();

    void addRomance(Character character);

    List getRomances();

    void addEvent(Event event);

    List getEvents();

    void addQuote(Quote quote);

    List getQuotes();



}
