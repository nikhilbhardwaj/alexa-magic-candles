package in.nikhilbhardwaj.candles.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.User;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.google.common.collect.ImmutableMap;
import in.nikhilbhardwaj.candles.alexa.intent.IntentNames;
import in.nikhilbhardwaj.candles.alexa.intent.SlotNames;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class AlexaSkillSpeechletTest extends AbstractGuicyTest {

    @Test
    public void withValidRequest() throws Exception {
        AlexaSkillSpeechlet speechlet = GUICE.getInstance(AlexaSkillSpeechlet.class);
        SpeechletResponse speechletResponse = speechlet.onIntent(validRequest(), buildTestSession());
        String text = ((PlainTextOutputSpeech) speechletResponse.getOutputSpeech()).getText();
        Assert.assertTrue(text.contains("You got it"));
    }

    @Test
    public void withBadRequest() throws Exception {
        AlexaSkillSpeechlet speechlet = GUICE.getInstance(AlexaSkillSpeechlet.class);
        SpeechletResponse speechletResponse = speechlet.onIntent(badRequest(), buildTestSession());
        String text = ((PlainTextOutputSpeech) speechletResponse.getOutputSpeech()).getText();
        Assert.assertTrue(text.contains("I am sorry, I didn't catch that"));
    }

    private IntentRequest badRequest() {
        return request("Dance");
    }

    private IntentRequest validRequest() {
        return request("On");
    }

    private IntentRequest request(String action) {
        Map<String, Slot> slots = ImmutableMap.of(SlotNames.Action.name(), Slot.builder().withValue(action).withName(SlotNames.Action.name()).build());
        return IntentRequest.builder()
                        .withIntent(Intent.builder()
                                .withName(IntentNames.CANDLES.intentName())
                                .withSlots(slots)
                                .build())
                        .withRequestId("requestId")
                        .build();
    }

    private Session buildTestSession() {
        Session session = Session.builder()
                .withSessionId("sessionId")
                .withUser(User.builder().withUserId("Popo").build())
                .build();
        return session;
    }
}
