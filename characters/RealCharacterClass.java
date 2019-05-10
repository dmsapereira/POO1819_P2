package characters;

public class RealCharacterClass extends CharacterClass implements RealCharacter {

    private Actor actor;
    private int fee;

    public RealCharacterClass(String name, Actor actor, int fee){
        super(name);
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
