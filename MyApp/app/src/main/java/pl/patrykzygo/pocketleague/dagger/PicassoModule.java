package pl.patrykzygo.pocketleague.dagger;


import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {

    @Provides
    @Singleton
    Picasso providesPicasso(Context context){
        return new Picasso.Builder(context).build();
    }
}
