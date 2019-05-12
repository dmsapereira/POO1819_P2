import tvAddicts.Management;
import tvAddicts.ManagementClass;
import tvAddicts.characters.Character;
import tvAddicts.characters.RealCharacter;
import tvAddicts.exceptions.TVAddictException;
import tvAddicts.shows.Show;

import java.util.Scanner;

enum Command {
    CURRENTSHOW, ADDSHOW, SWITCHTOSHOW, ADDSEASON, ADDEPISODE, ADDCHARACTER, ADDRELATIONSHIP, ADDROMANCE, ADDEVENT, ADDQUOTE, SEASONSOUTLINE, CHARACTERRESUME, HOWARETHESETWORELATED, FAMOUSQUOTES, ALSOAPPEARSON, MOSTROMANTIC, KINGOFCGI, HELP, EXIT
}

public class Main {

    private static final String SWITCH_SWOW_FORMAT = "%s . Seasons: %d Episodes: %d\n ";
    private static final String UNKNOWN = "Unknown command. Type help to see available commands.";
    private static final String EXIT = "Bye!";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Management system = new ManagementClass();
        processComand(in, system);
    }

    private static void processComand(Scanner in, Management system) {
        //TODO
        Command command = Command.valueOf(in.nextLine().toUpperCase());
        while (!command.equals(Command.EXIT)) {
            in.nextLine();
            switch (command) {
                case CURRENTSHOW:
                    processCurrentShow(in, system);
                    break;
                case ADDSHOW:
                    processAddShow(in, system);
                    break;
                case SWITCHTOSHOW:
                    processSwitchToShow(in, system);
                    break;
                case ADDSEASON:
                    processAddSeason(system);
                    break;
                case ADDEPISODE:
                    processAddEpisode(in, system);
                    break;
                case ADDCHARACTER:
                    processAddCharacter(in, system);
                    break;
                case ADDRELATIONSHIP:
                    break;
                case ADDROMANCE:
                    break;
                case ADDEVENT:
                    break;
                case ADDQUOTE:
                    break;
                case SEASONSOUTLINE:
                    break;
                case CHARACTERRESUME:
                    break;
                case HOWARETHESETWORELATED:
                    break;
                case FAMOUSQUOTES:
                    break;
                case ALSOAPPEARSON:
                    break;
                case MOSTROMANTIC:
                    break;
                case KINGOFCGI:
                    break;
                case HELP:
                    processHelp();
                    break;
                case EXIT:
                    break;
                default:
                    processUnknownCommand();
                    break;
            }
            command = Command.valueOf(in.nextLine().toUpperCase());
        }
    }

    private static void processAddCharacter(Scanner in, Management system) {
        Character character;
        String type, name, company_actor;
        int cost;
        try {
            type = in.nextLine();
            name = in.nextLine();
            company_actor = in.nextLine();
            cost = in.nextInt();
            in.nextLine();
            character = system.addCharacter(type, name, company_actor, cost);
            System.out.print(character.getName() + " is now a part of " + character.getShow().getName() + ". This is ");
            if (character instanceof RealCharacter)
                System.out.println(((RealCharacter) character).getActor() + " role " + ((RealCharacter) character).getActor().getRoles().size() + ".");
            else
                System.out.println(" a virtual actor.");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddEpisode(Scanner in, Management system) {
        try {
            int season = in.nextInt();
            String title = in.nextLine();
            system.addEpisode(season, title);
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddSeason(Management system) {
        try {
            Show current = system.addSeason();
            System.out.printf(SWITCH_SWOW_FORMAT, current.getName(), current.getSeasons().size(), current.getNumberOfEpisodes());
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processSwitchToShow(Scanner in, Management system) {
        try {
            Show current;
            String title = in.nextLine();
            current = system.switchToShow(title);
            System.out.printf(SWITCH_SWOW_FORMAT, current.getName(), current.getSeasons().size(), current.getNumberOfEpisodes());
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddShow(Scanner in, Management system) {
        try {
            String title = in.nextLine();
            system.addShow(title);
            System.out.println(title + " created.");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processCurrentShow(Scanner in, Management system) {
        try {
            Show current = system.getCurrentShow();
            System.out.printf(SWITCH_SWOW_FORMAT, current.getName(), current.getSeasons().size(), current.getNumberOfEpisodes());
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processHelp() {
        System.out.println("currentShow - show the current show\n" +
                "addShow - add a new show\n" +
                "switchToShow - change the context to a particular show\n" +
                "addSeason - add a new season to the current show\n" +
                "addEpisode - add a new episode to a particular season of the current show\n" +
                "addCharacter - add a new character to a show\n" +
                "addRelationship - add a family relationship between characters\n" +
                "addRomance - add a romantic relationship between characters\n" +
                "addEvent - add a significant event involving at least one character\n" +
                "addQuote - add a new quote to a character\n" +
                "seasonsOutline - outline the contents of the selected seasons for the selected show\n" +
                "characterResume - outline the main information on a specific character\n" +
                "howAreTheseTwoRelated - find out if and how two characters may be related\n" +
                "famousQuotes - find out which character(s) said a particular quote\n" +
                "alsoAppearsOn - which other shows and roles is the same actor on?\n" +
                "mostRomantic - find out who is at least as romantic as X\n" +
                "kingOfCGI - fnd out which company has earned more revenue with their CGI virtual actors\n" +
                "help - shows the available commands\n" +
                "exit - terminates the execution of the program\n");
    }

    private static void processUnknownCommand() {
        System.out.println(UNKNOWN);
    }
}
