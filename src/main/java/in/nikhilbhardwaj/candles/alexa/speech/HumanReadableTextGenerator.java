package in.nikhilbhardwaj.candles.alexa.speech;

import java.util.concurrent.ThreadLocalRandom;

public class HumanReadableTextGenerator {

    public static final String [] RESPONSES = {
            "Ok",
            "You got it",
            "Gotcha",
            "Alright",
            "Thy will be done",
            "As you wish"
    };

    public String repromptResponse() {
        return "I am sorry, I didn't catch that. Try again or ask me for help.";
    }

    public String helpResponse() {
        return "Welcome to Magic Candles, you can ask me to light up the candles.";
    }

    public String sessionEndResponse() {
        return "Good bye!";
    }

    public String response() {
        return RESPONSES[ThreadLocalRandom.current().nextInt(RESPONSES.length)];
    }

}
