import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit.equals(card.suit) && rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Пики", "Червы", "Бубны", "Трефы"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Колода пуста");
        }
        return cards.remove(0);
    }

    public boolean returnCard(Card card) {
        if (cards.contains(card)) {
            return false;
        }
        cards.add(card);
        return true;
    }

    public int size() {
        return cards.size();
    }
}

public class Coloda {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Card dealtCard = deck.deal();
        System.out.println("Сдана карта: " + dealtCard);

        boolean returned = deck.returnCard(dealtCard);
        System.out.println("Карта возвращена: " + returned);

        System.out.println("Карт осталось: " + deck.size());
    }
}
