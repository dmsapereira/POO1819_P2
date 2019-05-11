package tvAddicts;

import tvAddicts.characters.Character;
import tvAddicts.characters.RealCharacter;
import tvAddicts.characters.VirtualCharacter;
import tvAddicts.exceptions.*;
import tvAddicts.shows.Show;

import java.util.List;

public interface Management {

    Show getCurrentShow() throws NoCurrentShowException;

    void addShow(String showName) throws DuplicateShowException;

    Show switchToShow(String showName) throws VoidShowException;

    Show addSeason(String showName) throws NoCurrentShowException;

    Show addEpisode(int seasonNumber, String title) throws NoCurrentShowException, VoidSeasonException;

    RealCharacter addRealCharacter(String characterName, String actorName, int fee) throws NoCurrentShowException, DuplicateCharacterName, InvalidFeeException;

    VirtualCharacter addVirtualCharacter(String characterName, String companyName, int cost) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException;

    List<Character> addRelationShip(String parentName, String kidName) throws NoCurrentShowException, InvalidRelationshipException, VoidCharacterException;

    void addRomance(String characterName1, String characterName2) throws NoCurrentShowException, InvalidRomanceException, VoidCharacterException;

    void addEvent(String description, int season, int episode, List<Character> participants) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException;

    //TODO

}
