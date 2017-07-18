package in.nikhilbhardwaj.candles.alexa.intent;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class IntentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IntentHandlerService.class).to(IntentHandlerServiceImpl.class);

        MapBinder<String, IntentAction> mapBinder = MapBinder.newMapBinder(binder(), String.class, IntentAction.class);

        // Amazon intents
        mapBinder.addBinding(IntentNames.HELP.intentName()).to(AmazonHelpIntentAction.class);
        mapBinder.addBinding(IntentNames.START_OVER.intentName()).to(AmazonHelpIntentAction.class);
        mapBinder.addBinding(IntentNames.CANCEL.intentName()).to(AmazonStopIntentAction.class);
        mapBinder.addBinding(IntentNames.STOP.intentName()).to(AmazonStopIntentAction.class);

        // custom intents
        mapBinder.addBinding(IntentNames.CANDLES.intentName()).to(UserInteractionIntentAction.class);
    }
}
