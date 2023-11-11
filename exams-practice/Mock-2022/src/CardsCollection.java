import java.util.ArrayList;
import java.util.List;

public class CardsCollection {
    private List<Card> cards;
    private int gold;

    public CardsCollection() {
        cards = new ArrayList<>();
        gold = 0;
    }

    public void add(CardPack cardPack) {
//        System.out.println("Adding cards from cardPack");
        for (Card card : cardPack.getCards()) {
            if (cards.contains(card)) {
                switch (card.getRarity()) {
                    case "NORMAL" -> gold += 1;
                    case "RARE" -> gold += 2;
                    case "EPIC" -> gold += 4;
                    case "LEGENDARY" -> gold += 10;
                }
//                System.out.println("Now you have this much gold: " + gold);
                continue;
            }
//            System.out.println("New card: " + card);
            cards.add(card);
        }
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getGold() {
        return gold;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("You have ").append(gold).append(" gold and own ").append(cards.size()).append(" cards.\n");

        for (Card card : cards) {
            s.append(card);
        }
        return s.toString();
    }

    public String toWrite() {
        String s = "";
        s += gold + "\n";

        for (Card card : cards) {
            s += card.toWrite();
        }
        System.out.println(s);
        return s;
    }
}
