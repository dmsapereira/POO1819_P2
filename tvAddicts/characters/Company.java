package tvAddicts.characters;

import java.util.List;

public interface Company {

    String getName();

    List<VirtualCharacter> getCGI();

    void addCGI(VirtualCharacter character);
}
