package tvAddicts.shows;

import tvAddicts.characters.Character;

import java.util.LinkedList;
import java.util.List;

public class EventClass implements Event {

    private String description;
    private List<Character> participants;
    private int season, episode;

    public EventClass(String description, int season, int episode,  List<Character> participants){
        this.description=description;
        this.season = season;
        this.episode = episode;
        this.participants=new LinkedList<>();
        this.participants = participants;
        for(Character character : participants)
            character.addEvent(this);
    }
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getSeason() {
        return this.season;
    }

    @Override
    public int getEpisode() {
        return this.episode;
    }

    @Override
    public List<Character> getParticipants() {
        return this.participants;
    }

    int compareTo(Event event){
        if(this.getSeason() > event.getSeason())
            return 1;
        else if(this.getSeason() == event.getSeason()){
            if(this.episode > event.getEpisode())
                return 1;
            else if(this.episode == this.getEpisode())
                return 0;
            else
                return -1;
        }else
            return -1;
    }
}
