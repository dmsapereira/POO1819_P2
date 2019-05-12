package tvAddicts.characters;

import tvAddicts.shows.Event;
import tvAddicts.shows.Show;

import java.util.*;

public class CharacterClass implements Character {

    private String name;
    private Show show;
    private List<Character> parents, kids, siblings, romances;
    private Set<Event> events;
    private List<Quote> quotes;

    public CharacterClass (String name, Show show){
        this.name=name;
        this.show = show;
        this.parents = new LinkedList<>();
        this.kids = new LinkedList<>();
        this.siblings = new LinkedList<>();
        this.romances = new LinkedList<>();
        this.events = new TreeSet<>();
        this.quotes = new LinkedList<>();
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Show getShow() {
        return this.show;
    }

    @Override
    public void addRelationship(boolean parentFound, Character character) {
        if(parentFound){
            if(!this.parents.contains(character))
                this.parents.add(character);
            character.getKids().add(this);
            for(Character current: character.getKids()) {
                if(!this.siblings.contains(current))
                    this.siblings.add(current);
                current.getSiblings().add(this);
            }
        }else{
            this.kids.add(character);
            character.getParents().add(this);
        }
    }

    @Override
    public List<Character> getParents() {
        return this.parents;
    }

    @Override
    public List<Character> getKids() {
        return this.kids;
    }

    @Override
    public List<Character> getSiblings() {
        return this.siblings;
    }

    @Override
    public void addRomance(Character character) {
        if(!this.romances.contains(character)) {
            this.romances.add(character);
            character.addRomance(this);
        }
    }

    @Override
    public List<Character> getRomances() {
        return this.romances;
    }

    @Override
    public void addEvent(Event event) {
        if(!this.events.contains(event))
            this.events.add(event);
    }

    @Override
    public Set<Event> getEvents() {
        return this.events;
    }

    @Override
    public void addQuote(Quote quote) {
        quote.addCharacter(this);
        if(!this.quotes.contains(quote))
            this.quotes.add(quote);
    }

    @Override
    public List getQuotes() {
        return this.quotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterClass that = (CharacterClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
