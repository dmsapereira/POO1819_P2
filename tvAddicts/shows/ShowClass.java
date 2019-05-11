package tvAddicts.shows;

import tvAddicts.characters.Character;
import tvAddicts.exceptions.DuplicateCharacterException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShowClass implements Show {

    private String name;
    private List<Season> seasons;
    private Map<String, Character> characters;

    public ShowClass(String name) {
        this.name = name;
        this.seasons = new LinkedList<>();
        this.characters = new HashMap<>();
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
}
