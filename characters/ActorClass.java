package characters;

import java.util.LinkedList;
import java.util.List;

public class ActorClass implements Actor{
    private String name;
    private List<RealCharacter> roles;

    public ActorClass(String name){
        this.name=name;
        this.roles=new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addCharacter(RealCharacter character) {
        this.roles.add(character);
    }

    @Override
    public List<RealCharacter> getRoles() {
        return this.roles;
    }
}
