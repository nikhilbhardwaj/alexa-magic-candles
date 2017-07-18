package in.nikhilbhardwaj.candles.alexa;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Guice;

import java.util.Set;

/**
 * This class is the handler for an AWS Lambda function powering an Alexa Skill.
 *  To do this, simply set the handler field in the AWS Lambda console to
 * "com.ardetrick.alexa.niceride.AlexaStarterSpeechletRequestStreamHandler" For this to work, you'll
 * also need to build this project using the buildZip gradle task and upload the
 * resulting zip file to the AWS Lambda console.
 */
public class AlexaSkillSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds = ImmutableSet.of("amzn1.ask.skill.ef42440a-49b8-4c80-bb06-4042a2f40aca");

    public AlexaSkillSpeechletRequestStreamHandler() {
        super(Guice.createInjector(new ApplicationModule()).getInstance(AlexaSkillSpeechlet.class), supportedApplicationIds);
    }
}
