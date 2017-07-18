package in.nikhilbhardwaj.candles.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

import javax.inject.Inject;
import java.util.Map;

public class IntentHandlerServiceImpl implements IntentHandlerService {

    private final Map<String, IntentAction> intentActions;

    @Inject
    public IntentHandlerServiceImpl(final Map<String, IntentAction> intentActions) {
        this.intentActions = intentActions;
    }

    @Override
    public SpeechletResponse handle(String intentName, Intent intent, Session session) throws SpeechletException {
        SpeechletResponse speechletResponse;

        if (intentActions.containsKey(intentName)) {
            speechletResponse = intentActions.get(intentName).perform(intent, session);
        } else {
            throw new SpeechletException("Invalid Intent: " + intentName);
        }

        return speechletResponse;
    }
}
