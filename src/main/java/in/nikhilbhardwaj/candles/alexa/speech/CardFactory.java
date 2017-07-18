package in.nikhilbhardwaj.candles.alexa.speech;

import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.StandardCard;

public class CardFactory {

    public Card repromptCard(final String responseText) {
        StandardCard standardCard = new StandardCard();
        standardCard.setTitle("Sorry, I'm not sure what you said");
        standardCard.setText(responseText);
        return standardCard;
    }

    public Card responseCard(String responseText) {
        StandardCard standardCard = new StandardCard();
        standardCard.setTitle("Consider it done.");
        standardCard.setText(responseText);
        return standardCard;
    }

    public Card helpCard(String speechText) {
        SimpleCard card = new SimpleCard();
        card.setTitle("Welcome to Magic Candles!");
        card.setContent(speechText);
        return card;
    }
}
