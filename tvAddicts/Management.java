package tvAddicts;

import tvAddicts.characters.*;
import tvAddicts.characters.Character;
import tvAddicts.exceptions.*;
import tvAddicts.shows.Episode;
import tvAddicts.shows.Show;

import java.util.Iterator;
import java.util.List;

public interface Management {

    Show getCurrentShow() throws NoCurrentShowException;

    void addShow(String showName) throws DuplicateShowException;

    Show switchToShow(String showName) throws VoidShowException;

    Show addSeason() throws NoCurrentShowException;

    Show addEpisode(int seasonNumber, String title) throws NoCurrentShowException, VoidSeasonException;

    Character addCharacter(String type, String name, String company_actor, int cost) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException, InvalidCharacterType;

    Iterator<Character> addRelationShip(String parentName, String kidName) throws NoCurrentShowException, InvalidRelationshipException, VoidCharacterException;

    void addRomance(String characterName1, String characterName2) throws NoCurrentShowException, InvalidRomanceException, VoidCharacterException;

    void addEvent(String description, int season, int episode, List<String> participants) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException;

    void addQuote(int season, int episode, String character, String quote) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException;

    Iterator<Episode> seasonsOutline(int startingSeason, int endingSeasons) throws NoCurrentShowException, InvalidSeasonIntervalException;

    Character getCharacter(String characterName);

    Iterator<Character> howAreTheseTwoRelated(String character1, String character2) throws NoCurrentShowException, VoidCharacterException, SameCharacterException;

    Iterator<Character> famousQuotes(String quote) throws NoCurrentShowException, VoidQuoteException;

    Iterator<Show> alsoAppearsOn(String characterName) throws NoCurrentShowException, VoidCharacterException;

    Iterator<Actor> mostRomantic(String character) throws VoidRomanceException, VoidCharacterException;

    Company kingOfCGI() throws VoidVirtualCharactersException;

}
