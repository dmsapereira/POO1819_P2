import tvAddicts.Management;
import tvAddicts.ManagementClass;
import tvAddicts.characters.Character;
import tvAddicts.characters.RealCharacter;
import tvAddicts.exceptions.TVAddictException;
import tvAddicts.shows.Episode;
import tvAddicts.shows.Event;
import tvAddicts.shows.Show;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

enum Command {
    CURRENTSHOW, ADDSHOW, SWITCHTOSHOW, ADDSEASON, ADDEPISODE, ADDCHARACTER, ADDRELATIONSHIP, ADDROMANCE, ADDEVENT, ADDQUOTE, SEASONSOUTLINE, CHARACTERRESUME, HOWARETHESETWORELATED, FAMOUSQUOTES, ALSOAPPEARSON, MOSTROMANTIC, KINGOFCGI, HELP, EXIT, UNKNOWN
}

public class Main {

    private static final String SWITCH_SWOW_FORMAT = "%s . Seasons: %d Episodes: %d\n ";
    private static final String UNKNOWN = "Unknown command. Type help to see available commands.";
    private static final String EXIT = "Bye!";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Management system = new ManagementClass();
        processComand(in, system);
        System.out.println(EXIT);
    }

    private static void processComand(Scanner in, Management system) {
        //TODO
        Command command;
        try {
            command = Command.valueOf(in.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            command = Command.UNKNOWN;
        }
        while (!command.equals(Command.EXIT)) {
            try {
                switch (command) {
                    case CURRENTSHOW:
                        processCurrentShow(system);
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
                        processAddRelationship(in, system);
                        break;
                    case ADDROMANCE:
                        processAddRomance(in, system);
                        break;
                    case ADDEVENT:
                        processAddEvent(in, system);
                        break;
                    case ADDQUOTE:
                        processAddQuote(in, system);
                        break;
                    case SEASONSOUTLINE:
                        processSeasonsOutline(in, system);
                        break;
                    case CHARACTERRESUME:
                        processCharacterResume(in, system);
                        break;
                    case HOWARETHESETWORELATED:
                        processHowAreTheseTwoRelated(in, system);
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
            } catch (IllegalArgumentException e) {
                command = Command.UNKNOWN;
            }
        }
    }

    private static void processHowAreTheseTwoRelated(Scanner in, Management system) {
        //TODO
    }

    private static void printEventsPerEpisode(Iterator<Episode> episodes) {
        Iterator<Event> eventItera;
        Episode currentEpisode;
        if (!episodes.hasNext())
            System.out.println("None");
        else {
            while (episodes.hasNext()) {
                currentEpisode = episodes.next();
                System.out.println("S" + currentEpisode.getSeasonNumber() + " Ep" + currentEpisode.getEpisodeNumber() + ":");
                eventItera = currentEpisode.getEvents().iterator();
                while (eventItera.hasNext())
                    System.out.println(eventItera.next().getDescription());
            }
        }
    }

    private static void printCharacterIterator(Iterator<Character> characters) {
        if (!characters.hasNext())
            System.out.println("None");
        else {
            while (characters.hasNext())
                System.out.println(characters.next().getName());
        }
    }

    private static void printCharacterEvents(Iterator<Event> events) {
        Event currentEvent;
        int currentEpisode, currentSeason;
        if (!events.hasNext())
            System.out.println("None");
        else {
            currentEpisode = 0;
            currentSeason = 0;
            while (events.hasNext()) {
                currentEvent = events.next();
                if (currentEpisode != currentEvent.getEpisode() && currentSeason != currentEvent.getSeason()) {
                    currentEpisode = currentEvent.getEpisode();
                    currentSeason = currentEvent.getSeason();
                    System.out.println("S" + currentEvent.getSeason() + " Ep" + currentEvent.getEpisode() + ":");
                }
                System.out.println(events.next().getDescription());
            }
        }
    }

    private static void processCharacterResume(Scanner in, Management system) {
        Character character;
        String characterName = in.nextLine();
        character = system.getCharacter(characterName);
        System.out.print("Parents: ");
        printCharacterIterator(character.getParents().iterator());
        System.out.print("Kids: ");
        printCharacterIterator(character.getKids().iterator());
        System.out.print("Siblings: ");
        printCharacterIterator(character.getSiblings().iterator());
        System.out.print("Romantic relationships: ");
        printCharacterIterator(character.getRomances().iterator());
        printCharacterEvents(character.getEvents().iterator());
    }

    private static void processSeasonsOutline(Scanner in, Management system) {
        Iterator<Episode> episodes;
        try {
            int startingSeason = in.nextInt();
            int endingSeason = in.nextInt();
            in.nextLine();
            episodes = system.seasonsOutline(startingSeason, endingSeason);
            System.out.println(system.getCurrentShow().getName());
            printEventsPerEpisode(episodes);
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddQuote(Scanner in, Management system) {
        try {
            int season = in.nextInt();
            int episode = in.nextInt();
            in.nextLine();
            String character = in.nextLine();
            String quote = in.nextLine();
            system.addQuote(season, episode, character, quote);
            System.out.println("Quote added.");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddEvent(Scanner in, Management system) {
        List<String> participants;
        try {
            participants = new LinkedList<>();
            String description = in.nextLine();
            int season = in.nextInt();
            int episode = in.nextInt();
            int number = in.nextInt();
            in.nextLine();
            for (int i = 0; i < number; i++)
                participants.add(in.nextLine());
            system.addEvent(description, season, episode, participants);
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddRomance(Scanner in, Management system) {
        try {
            String character1 = in.nextLine();
            String character2 = in.nextLine();
            system.addRomance(character1, character2);
            System.out.println(character1 + " and " + character2 + " are now a couple.");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void processAddRelationship(Scanner in, Management system) {
        try {
            String parent = in.nextLine();
            String kid = in.nextLine();
            Iterator<Character> itera = system.addRelationShip(parent, kid);
            System.out.println(parent + " has now " + itera.next().getKids().size() + " kids. " + kid + " has now " + itera.next().getParents().size() + " parent(s).");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
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
                System.out.println("a virtual actor.");
        } catch (TVAddictException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processAddEpisode(Scanner in, Management system) {
        Show show;
        try {
            int season = in.nextInt();
            String title = in.nextLine();
            show = system.addEpisode(season, title);
            System.out.printf(SWITCH_SWOW_FORMAT, show.getName(), show.getSeasons().size(), show.getNumberOfEpisodes());
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

    private static void processCurrentShow(Management system) {
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
                "exit - terminates the execution of the program");
    }

    private static void processUnknownCommand() {
        System.out.println(UNKNOWN);
    }
}
