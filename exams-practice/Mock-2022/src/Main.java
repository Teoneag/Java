import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Card> cards = new ArrayList<>();
    private static CardsCollection cardsCollection = new CardsCollection();
    private static Scanner userInput = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        int option = -1;
        cards = read(new Scanner(new File("resources/playingcards.txt")));
        try {
            Scanner scanner = new Scanner(new File("resources/data.txt"));
            cardsCollection.setGold(Integer.parseInt(scanner.nextLine()));
            cardsCollection.setCards(read(scanner));
        } catch (Exception e) {
            System.out.println("Welcome to this application");
        }
        do {
            System.out.println("""
                    Please make your choice:
                        1 – Show all known cards.
                        2 – Show user’s card collection and gold.
                        3 – Open a pack of cards.
                        4 – Save collection to file.
                        5 – Quit the application.
                                    """);
            try {
                option = Integer.parseInt(userInput.nextLine());
                switch (option) {
                    case 1 -> showCards();
                    case 2 -> showUserCardsGold();
                    case 3 -> open();
                    case 4 -> save();
                }
            } catch (Exception e) {
                System.out.println("Error reading, please try again.");
            }

        } while (option != 5);
        System.out.println("Exiting application.");
    }

    private static void open() {
        CardPack cardPack = CardPack.open(cards);
        cardsCollection.add(cardPack);
        System.out.println("Opened this cardPack:\n" + cardPack);
    }

    private static List<Card> read(Scanner input) {
        List<Card> cardsRead = new ArrayList<>();

        while (input.hasNextLine()) {
            String cardType = input.nextLine();

            String rarity = input.nextLine();

            input.useDelimiter(" - ");
            input.useDelimiter(" - ");
            String name = input.next();

            input.reset();
            input.skip(" - ");
            int energy = Integer.parseInt(input.next());
            input.next();

            switch (cardType) {
                case "Unit Card":
                    int attack = Integer.parseInt(input.next());
                    input.next(); // skip Attack
                    input.next(); // skip -
                    int defence = Integer.parseInt(input.next());
                    UnitCard unitCard = new UnitCard(rarity, name, energy, attack, defence);
                    input.nextLine(); // skip Defence
                    cardsRead.add(unitCard);
                    break;
                case "Weapon Card":
                    int durability = Integer.parseInt(input.next());
                    input.nextLine(); // skip Durability
                    WeaponCard weaponCard = new WeaponCard(rarity, name, energy, durability);
                    cardsRead.add(weaponCard);
                    break;
                case "Spell Card":
                    input.next(); // skip -
                    String spellType = input.next();
                    input.nextLine(); // skip /n
                    String description = input.nextLine();
                    SpellCard spellCard = new SpellCard(rarity, name, energy, spellType, description);
                    cardsRead.add(spellCard);
            }
        }
        return cardsRead;
    }

    private static void showCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    private static void showUserCardsGold() {
        System.out.println(cardsCollection);
    }

    private static void save() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/data.txt"));
            bufferedWriter.write(cardsCollection.toWrite());
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing: " + e);
        }
    }


}