package in.nikhilbhardwaj.candles.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import in.nikhilbhardwaj.candles.alexa.speech.CardFactory;
import in.nikhilbhardwaj.candles.alexa.speech.HumanReadableTextGenerator;
import in.nikhilbhardwaj.candles.iot.AWSIOTService;

import javax.inject.Inject;
import java.util.Optional;

public class UserInteractionIntentAction implements IntentAction {

    private HumanReadableTextGenerator textGenerator;
    private CardFactory cardFactory;
    private AWSIOTService iotService;

    @Override
    public SpeechletResponse perform(Intent intent, Session session) {
        Optional<SupportedActions> actionRequested = SupportedActions.fromActionName(intent.getSlot(SlotNames.Action.name()).getValue());
        if (actionRequested.isPresent()) {
            String actionName = actionRequested.get().actionName();
            System.out.println("Requesting device to perform : " + actionName);
            iotService.publishMessage(actionName);
        } else {
            return getRepromptResposne();
        }
        return getResposne();
    }

    @Inject
    public UserInteractionIntentAction(AWSIOTService iotService, HumanReadableTextGenerator textGenerator, CardFactory cardFactory) {
        this.iotService = iotService;
        this.textGenerator = textGenerator;
        this.cardFactory = cardFactory;
    }

    private SpeechletResponse getRepromptResposne() {
        String responseText = textGenerator.repromptResponse();
        PlainTextOutputSpeech plainTextOutputSpeech = new PlainTextOutputSpeech();
        plainTextOutputSpeech.setText(responseText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(plainTextOutputSpeech);

        return SpeechletResponse.newAskResponse(plainTextOutputSpeech, reprompt, cardFactory.repromptCard(responseText));
    }

    private SpeechletResponse getResposne() {
        String responseText = textGenerator.response();
        PlainTextOutputSpeech plainTextOutputSpeech = new PlainTextOutputSpeech();
        plainTextOutputSpeech.setText(responseText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(plainTextOutputSpeech);

        return SpeechletResponse.newAskResponse(plainTextOutputSpeech, reprompt, cardFactory.responseCard(responseText));
    }
}
