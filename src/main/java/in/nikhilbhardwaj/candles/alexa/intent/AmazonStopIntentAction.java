package in.nikhilbhardwaj.candles.alexa.intent;


import javax.inject.Inject;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import in.nikhilbhardwaj.candles.alexa.speech.HumanReadableTextGenerator;

public class AmazonStopIntentAction implements IntentAction {
    private final HumanReadableTextGenerator textGenerator;

    @Inject
    protected AmazonStopIntentAction(HumanReadableTextGenerator textGenerator) {
        this.textGenerator = textGenerator;
    }

    @Override
    public SpeechletResponse perform(Intent intent, Session session) {
        String speechText = textGenerator.sessionEndResponse();
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech);
    }
}
