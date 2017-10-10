package puliware.es.superheroes.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import puliware.es.superheroes.data.remote.HeroesService;
import puliware.es.superheroes.injection.ApplicationContext;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    HeroesService provideSuperHeroesService() {
        return HeroesService.Creator.newRibotsService();
    }


}
