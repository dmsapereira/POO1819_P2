package tvAddicts.shows;

import tvAddicts.characters.Character;
import tvAddicts.characters.Quote;
import tvAddicts.characters.Romance;
import tvAddicts.exceptions.DuplicateCharacterException;
import tvAddicts.exceptions.InvalidRomanceException;
import tvAddicts.exceptions.SameCharacterException;
import tvAddicts.exceptions.VoidCharacterException;

import java.util.List;
import java.util.Map;

public interface Show {

    String getName();

    void addSeason();

    List<Season> getSeasons();

    void addCharacter(Character character) throws DuplicateCharacterException;

    Map<String, Character> getCharacters();

    void addRomance(String character1, String character2) throws InvalidRomanceException, VoidCharacterException;

    List<Romance> getRomances();

    void addQuote(String quote, String character);

    Map<String, Quote> getQuotes();
}
