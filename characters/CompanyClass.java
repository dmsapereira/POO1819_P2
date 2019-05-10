package characters;

import java.util.LinkedList;
import java.util.List;

public class CompanyClass implements Company {

    private String name;
    private List<VirtualCharacter> cgi;

    public CompanyClass(String name, VirtualCharacter firstCharacter){
        this.name=name;
        this.cgi=new LinkedList<>();
        this.cgi.add(firstCharacter);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<VirtualCharacter> getCGI() {
        return this.cgi;
    }

    @Override
    public void addCGI(VirtualCharacter character) {
        this.cgi.add(character);
    }
}
