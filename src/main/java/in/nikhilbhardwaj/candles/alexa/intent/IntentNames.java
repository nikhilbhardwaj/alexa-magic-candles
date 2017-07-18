package in.nikhilbhardwaj.candles.alexa.intent;

public enum IntentNames {
    CANCEL("AMAZON.CancelIntent"),
    HELP("AMAZON.HelpIntent"),
    START_OVER("AMAZON.StartOverIntent"),
    STOP("AMAZON.StopIntent"),
    CANDLES("CandlesIntent");

    private String intentName;

    IntentNames(String intentName) {
        this.intentName = intentName;
    }

    public String intentName() {
        return intentName;
    }
}
