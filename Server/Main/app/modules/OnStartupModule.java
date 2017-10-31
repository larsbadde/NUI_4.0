package modules;

import com.google.inject.AbstractModule;
import play.mvc.*;
import global.*;

/**
 * Created by Lars Badde
 */
public class OnStartupModule extends AbstractModule {
    @Override
    public void configure() {
        bind(global.OnStartup.class).asEagerSingleton();
    }
}