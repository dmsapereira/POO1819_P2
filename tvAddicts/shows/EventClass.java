package tvAddicts.shows;

import java.util.LinkedList;
import java.util.List;

public class EventClass implements Event {

    private String description;
    private List<Character> participants;

    public EventClass(String description, List<Character> participants){
        this.description=description;
        this.participants=new LinkedList<>();
        for(Character character: participants){
            this.participants.add(character);
        }
    }
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public List<Character> getParticipants() {
        return this.participants;
    }
}
