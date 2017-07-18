package in.nikhilbhardwaj.candles.alexa.speech;

public class HumanReadableTextGenerator {


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
        return "You got it!";
    }

}
