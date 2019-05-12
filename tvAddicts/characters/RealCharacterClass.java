package tvAddicts.characters;

import tvAddicts.shows.Show;

public class RealCharacterClass extends CharacterClass implements RealCharacter {

    private Actor actor;
    private int fee;

    public RealCharacterClass(String name, Show show, Actor actor, int fee){
        super(name, show);
        this.actor=actor;
        this.fee=fee;
    }

    @Override
    public Actor getActor() {
        return null;
    }

    @Override
    public int getFee() {
        return 0;
    }
}
