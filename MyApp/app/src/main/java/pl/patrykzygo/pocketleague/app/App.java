package pl.patrykzygo.pocketleague.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import pl.patrykzygo.pocketleague.dagger.AppComponent;
import pl.patrykzygo.pocketleague.dagger.AppModule;
import pl.patrykzygo.pocketleague.dagger.DaggerAppComponent;


public class App extends Application{

    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }

    protected AppComponent initDagger(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        appComponent = initDagger();
    }
}
