package characters;

import shows.Event;

import java.util.LinkedList;
import java.util.List;

public class CharacterClass implements Character {

    private String name;
    private List<Character> parents, kids, siblings, romances;
    private List<Event> events;
    private List<Quote> quotes;

    public CharacterClass (String name){
        this.name=name;
        this.parents = new LinkedList<>();
        this.kids = new LinkedList<>();
        this.siblings = new LinkedList<>();
        this.romances = new LinkedList<>();
        this.events = new LinkedList<>();
        this.quotes = new LinkedList<>();
    }
    @Override
    public String getName() {
        return this.name;
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
    public List getParents() {
        return this.parents;
    }

    @Override
    public List getKids() {
        return this.kids;
    }

    @Override
    public List getSiblings() {
        return this.siblings;
    }

    @Override
    public void addRomance(Character character) {
        if(!this.romances.contains(character))
            this.romances.add(character);
    }

    @Override
    public List getRomances() {
        return this.romances;
    }

    @Override
    public void addEvent(Event event) {
        if(!this.events.contains(event))
            this.events.add(event);
    }

    @Override
    public List getEvents() {
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
}
