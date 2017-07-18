package in.nikhilbhardwaj.candles.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import in.nikhilbhardwaj.candles.alexa.intent.IntentHandlerService;
import in.nikhilbhardwaj.candles.alexa.intent.IntentNames;

import javax.inject.Inject;

public class AlexaSkillSpeechlet implements Speechlet {

    private IntentHandlerService intentHandlerService;

    @Inject
    public AlexaSkillSpeechlet(IntentHandlerService intentHandlerService) {
        this.intentHandlerService = intentHandlerService;
    }

    /**
     * Invoked at the start of an Alexa session. Does not handle any intents.
     */
    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {

    }

    /**
     * Invoked when the user invokes the Skill without providing an intent.
     * Reroute to AMAZON.HelpIntent
     */
    @Override
    public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        Intent helpIntent = Intent.builder().withName(IntentNames.HELP.intentName()).build();
        return intentHandlerService.handle(IntentNames.HELP.intentName(), helpIntent, session);
    }

    /**
     * Invoked by any intent requests.
     */
    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        return intentHandlerService.handle(intentName, intent, session);
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

    }
}
