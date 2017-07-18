package in.nikhilbhardwaj.candles.alexa;

import com.google.inject.AbstractModule;
import in.nikhilbhardwaj.candles.alexa.intent.IntentModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new IntentModule());
    }
}
