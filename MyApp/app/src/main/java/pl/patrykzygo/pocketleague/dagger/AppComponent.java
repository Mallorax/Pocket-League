package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mallorax on 15.08.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})


public interface AppComponent {
}
