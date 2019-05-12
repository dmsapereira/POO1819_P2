package tvAddicts;

import tvAddicts.characters.*;
import tvAddicts.characters.Character;
import tvAddicts.exceptions.*;
import tvAddicts.shows.*;

import java.util.*;

public class ManagementClass implements  Management {

    private Show currentShow;
    private Map<String, Show> shows;
    private Map<String, Actor> actors;
    private Map<String, Company> companies;

    public ManagementClass() {
        this.shows = new HashMap<>();
        this.actors = new HashMap<>();
        this.companies = new HashMap<>();
    }

    @Override
    public Show getCurrentShow() throws NoCurrentShowException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        return this.currentShow;
    }

    @Override
    public void addShow(String showName) throws DuplicateShowException {
        if(this.shows.containsKey(showName))
            throw new DuplicateShowException();
        this.shows.put(showName, new ShowClass(showName));
    }

    @Override
    public Show switchToShow(String showName) throws VoidShowException {
        if(!this.shows.containsKey(showName))
            throw new VoidShowException();
        this.currentShow = this.shows.get(showName);
        return this.currentShow;
    }

    @Override
    public Show addSeason(String showName) throws NoCurrentShowException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        this.currentShow.addSeason();
        return this.currentShow;
    }

    @Override
    public Show addEpisode(int seasonNumber, String title) throws NoCurrentShowException, VoidSeasonException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(this.currentShow.getSeasons().size() < seasonNumber)
            throw new VoidSeasonException();
        this.currentShow.getSeasons().get(seasonNumber - 1).addEpisode(new EpisodeClass(title));
        return this.currentShow;
    }

    @Override
    public RealCharacter addRealCharacter(String characterName, String actorName, int fee) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException {
        Actor actor;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(this.currentShow.getCharacters().containsKey(characterName))
            throw new DuplicateCharacterException();
        if(fee <= 0)
            throw new InvalidFeeException();

        if(!this.actors.containsKey(actorName))
             actor = new ActorClass(actorName);
        else
            actor = this.actors.get(actorName);
        RealCharacter character = new RealCharacterClass(characterName, this.currentShow, actor, fee);
        this.currentShow.getCharacters().put(characterName, character);
        actor.addCharacter(character);
        this.actors.put(actorName, actor);
        return character;
    }

    @Override
    public VirtualCharacter addVirtualCharacter(String characterName, String companyName, int cost) throws NoCurrentShowException, DuplicateCharacterException, InvalidFeeException {
        Company company;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(this.currentShow.getCharacters().containsKey(characterName))
            throw new DuplicateCharacterException();
        if(cost <= 0)
            throw new InvalidFeeException();

        if(!this.companies.containsKey(companyName))
            company = new CompanyClass(companyName);
        else
            company = this.companies.get(companyName);
        VirtualCharacter character = new VirtualCharacterClass(characterName, this.currentShow, company, cost);
        this.getCurrentShow().getCharacters().put(characterName, character);
        company.addCGI(character);
        this.companies.put(companyName, company);
        return character;
    }

    @Override
    public Iterator<Character> addRelationShip(String parentName, String kidName) throws NoCurrentShowException, InvalidRelationshipException, VoidCharacterException {
        Character parent, kid;
        List<Character> result;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(parentName.equals(kidName))
            throw new InvalidRelationshipException(parentName);
        if(!this.currentShow.getCharacters().containsKey(parentName))
            throw new VoidCharacterException(parentName);
        if(!this.currentShow.getCharacters().containsKey(kidName))
            throw new VoidCharacterException(kidName);

        result = new LinkedList<>();
        parent = this.currentShow.getCharacters().get(parentName);
        kid = this.currentShow.getCharacters().get(kidName);
        kid.addRelationship(true, parent);
        result.add(parent);
        result.add(kid);
        return result.iterator();
    }

    @Override
    public void addRomance(String characterName1, String characterName2) throws NoCurrentShowException, InvalidRomanceException, VoidCharacterException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        this.currentShow.addRomance(characterName1, characterName2);
    }

    @Override
    public void addEvent(String description, int season, int episode, List<String> participants) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException {
        List<Character> characters;
        Event event;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(this.currentShow.getSeasons().size() < season)
            throw new InvalidSeasonException(this.currentShow, season);
        if(this.currentShow.getSeasons().get(season - 1).getEpisodes().size() < episode)
            throw new InvalidEpisodeException(this.currentShow, season, episode);

        characters = new LinkedList<>();
        for(String character : participants) {
            if (!this.currentShow.getCharacters().containsKey(character))
                throw new VoidCharacterException(character);
            characters.add(this.currentShow.getCharacters().get(character));
        }
        event = new EventClass(description, season, episode, characters);
        this.currentShow.getSeasons().get(season - 1).getEpisodes().get(episode).addEvent(event);
    }

    @Override
    public void addQuote(int season, int episode, String character, String quote) throws NoCurrentShowException, InvalidSeasonException, InvalidEpisodeException, VoidCharacterException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(this.currentShow.getSeasons().size() < season)
            throw new InvalidSeasonException(this.currentShow, season);
        if(this.currentShow.getSeasons().get(season - 1).getEpisodes().size() < episode)
            throw new InvalidEpisodeException(this.currentShow, season, episode);
        if(!this.currentShow.getCharacters().containsKey(character))
            throw new VoidCharacterException(character);

        this.currentShow.addQuote(quote, character);
    }

    @Override
    public Iterator<Episode> seasonsOutline(int startingSeason, int endingSeason) throws NoCurrentShowException, InvalidSeasonIntervalException {
        Season season;
        List<Episode> episodes;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(startingSeason < endingSeason)
            throw new InvalidSeasonIntervalException();

        episodes = new LinkedList<>();
        for(int i = startingSeason - 1; i < endingSeason; i++){
            season = this.currentShow.getSeasons().get(i);
            for(Episode episode : season.getEpisodes())
                episodes.add(episode);
        }
        return episodes.iterator();
    }

    @Override
    public Character getCharacter(String characterName) {
        return this.currentShow.getCharacters().get(characterName);
    }

    @Override
    public Iterator<Character> howAreTheseTwoRelated(String character1, String character2) throws NoCurrentShowException, VoidCharacterException, SameCharacterException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(!this.currentShow.getCharacters().containsKey(character1))
            throw new VoidCharacterException(character1);
        if(!this.currentShow.getCharacters().containsKey(character2))
            throw new VoidCharacterException(character2);
        if(character1.equals(character2))
            throw new SameCharacterException();

        //TODO
        return null;
    }

    @Override
    public Iterator<Character> famousQuotes(String quote) throws NoCurrentShowException, VoidQuoteException {
        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(!this.currentShow.getQuotes().containsKey(quote))
            throw new VoidQuoteException();

        return this.currentShow.getQuotes().get(quote).whoSaidThis().values().iterator();
    }

    @Override
    public Iterator<Show> alsoAppearsOn(String characterName) throws NoCurrentShowException, VoidCharacterException {
        Character character;
        List<RealCharacter> roles;
        List<Show> result;

        if(this.currentShow == null)
            throw new NoCurrentShowException();
        if(!this.currentShow.getCharacters().containsKey(characterName))
            throw new VoidCharacterException(characterName);

        result = new LinkedList<>();
        character = this.currentShow.getCharacters().get(characterName);
        if(character instanceof RealCharacter) {
            roles = ((RealCharacter) character).getActor().getRoles();
            for(RealCharacter role : roles){
                if(!result.contains(role.getShow()))
                    result.add(role.getShow());
            }
        }else
            result.add(character.getShow());
        return result.iterator();
    }

    @Override
    public Iterator<Character> mostRomantic(String character) throws VoidRelationshipsException, VoidCharacterException {
        //TODO
    }

    @Override
    public Company kingOfCGI() throws VoidVirtualCharactersException {
        return null;
    }
}
