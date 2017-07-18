package in.nikhilbhardwaj.candles.alexa;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class AbstractGuicyTest {
    protected static final Injector GUICE = Guice.createInjector(new ApplicationModule());
}
