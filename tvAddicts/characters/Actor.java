package tvAddicts.characters;

import java.util.List;

public interface Actor {

    String getName();

    void addCharacter(RealCharacter character);

    List<RealCharacter> getRoles();
}
