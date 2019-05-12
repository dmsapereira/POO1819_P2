package tvAddicts.characters;

import java.util.List;

public interface Company {

    String getName();

    void addCGI(VirtualCharacter character);

    List<VirtualCharacter> getCGI();
}
