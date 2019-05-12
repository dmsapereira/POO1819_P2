package tvAddicts.shows;

import tvAddicts.characters.*;
;
import tvAddicts.characters.Character;
import tvAddicts.exceptions.DuplicateCharacterException;
import tvAddicts.exceptions.InvalidRomanceException;
import tvAddicts.exceptions.SameCharacterException;
import tvAddicts.exceptions.VoidCharacterException;

import java.util.*;

public class ShowClass implements Show {

    private String name;
    private List<Season> seasons;
    private Map<String, Character> characters;
    private List<Romance> romances;
    private Map<String, Quote> quotes;

    public ShowClass(String name) {
        this.name = name;
        this.romances = new LinkedList<>();
        this.seasons = new LinkedList<>();
        this.characters = new HashMap<>();
        this.quotes = new TreeMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addSeason() {
        seasons.add(new SeasonClass());
    }

    @Override
    public List<Season> getSeasons() {
        return this.seasons;
    }

    @Override
    public void addCharacter(Character character) throws DuplicateCharacterException {
        if (this.characters.containsKey(character.getName()))
            throw new DuplicateCharacterException();
        this.characters.put(character.getName(), character);
    }

    @Override
    public Map<String, Character> getCharacters() {
        return this.characters;
    }

    @Override
    public void addRomance(String character1, String character2) throws InvalidRomanceException, VoidCharacterException {
        Romance r;

        if(character1.equals(character2))
            throw new InvalidRomanceException(character1);
        if(!this.characters.containsKey(character1))
            throw new VoidCharacterException(character1);
        if(!this.characters.containsKey(character2))
            throw new VoidCharacterException(character2);

        r = new RomanceClass(this.characters.get(character1), this.characters.get(character2));
        this.romances.add(r);
    }

    @Override
    public List<Romance> getRomances() {
        return this.romances;
    }

    @Override
    public void addQuote(String quote, String character) {
        Quote q;
        Character speaker = this.characters.get(character);

        if(this.quotes.containsKey(quote))
            if (!(q = this.quotes.get(quote)).whoSaidThis().containsKey(character))
                q.whoSaidThis().put(character, speaker);
        else
            this.quotes.put(quote, new QuoteClass(quote, speaker));
    }

    @Override
    public Map<String, Quote> getQuotes() {
        return this.quotes;
    }
}
