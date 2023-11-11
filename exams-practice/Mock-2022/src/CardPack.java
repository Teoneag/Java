import java.util.ArrayList;
import java.util.List;

public class CardPack {
    private List<Card> cards;

    public CardPack() {
        cards = new ArrayList<>(0);
    }

    private void addCard(Card card) {
        if (cards.size() > 5) {
            System.out.println("Trying to add more than 5 careds");
            return;
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public static CardPack open(List<Card> cards) {
        CardPack cardPack = new CardPack();

        for (int i = 0; i < 5; i++) {
            // get card rarity
            double p = Math.random();
            String rarity;
            if (p < 0.02) { // legendary
                rarity = "LEGENDARY";
            } else if (p < 0.08) { // epic
                rarity = "EPIC";
            } else if (p < 0.16) { // rare
                rarity = "RARE";
            } else { // noraml
                rarity = "NORMAL";
            }

            // get list of cards of that rarity
            List<Card> cardsGoodRarity = new ArrayList<>();

            for (Card card : cards) {
                if (card.getRarity().equals(rarity)) {
                    cardsGoodRarity.add(card);
                }
            }

            p = Math.random();
            int index = (int) (p * cardsGoodRarity.size());
            cardPack.addCard(cardsGoodRarity.get(index));
        }
        return cardPack;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Card card : cards) {
            s.append(card);
        }
        return s.toString();
    }
}
