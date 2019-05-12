package tvAddicts;

import tvAddicts.characters.Character;
import tvAddicts.characters.Company;
import tvAddicts.characters.RealCharacter;
import tvAddicts.characters.VirtualCharacter;
import tvAddicts.exceptions.*;
import tvAddicts.shows.Episode;
import tvAddicts.shows.Show;

import java.util.Iterator;
import java.util.List;

public interface Management {

    Show getCurrentShow() throws NoCurrentShowException;

    void addShow(String showName) throws DuplicateShowException;

    Show switchToShow(String showName) throws VoidShowException;

    Show addSeason(String showName) throws NoCurrentShowException;

    Show addEpisode(int seasonNumber, String title) throws NoCurrentShowException, VoidSeasonException;

    RealCharacter addRealCharacter(String characterName, String actorName, int fee) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException, DuplicateCharacterException;

    VirtualCharacter addVirtualCharacter(String characterName, String companyName, int cost) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException;

    Iterator<Character> addRelationShip(String parentName, String kidName) throws NoCurrentShowException, InvalidRelationshipException, VoidCharacterException;

    void addRomance(String characterName1, String characterName2) throws NoCurrentShowException, InvalidRomanceException, VoidCharacterException;

    void addEvent(String description, int season, int episode, List<String> participants) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException;

    void addQuote(int season, int episode, String character, String quote) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException;

    Iterator<Episode> seasonsOutline(int startingSeason, int endingSeasons) throws NoCurrentShowException, InvalidSeasonIntervalException;

    Character getCharacter(String characterName);

    Iterator<Character> howAreTheseTwoRelated(String character1, String character2) throws NoCurrentShowException, VoidCharacterException, SameCharacterException;

    Iterator<Character> famousQuotes(String quote) throws NoCurrentShowException, VoidQuoteException;

    Iterator<Show> alsoAppearsOn(String characterName) throws NoCurrentShowException, VoidCharacterException;

    Iterator<Character> mostRomantic(String character) throws VoidRelationshipsException, VoidCharacterException;

    Company kingOfCGI() throws VoidVirtualCharactersException;

}
