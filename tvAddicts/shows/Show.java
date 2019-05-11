package tvAddicts.shows;

import tvAddicts.characters.Character;
import tvAddicts.exceptions.DuplicateCharacterException;

import java.util.List;
import java.util.Map;

public interface Show {

    String getName();

    void addSeason();

    List<Season> getSeasons();

    void addCharacter(Character character) throws DuplicateCharacterException;

    Map<String, Character> getCharacters();
}
