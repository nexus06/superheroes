package puliware.es.superheroes.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import puliware.es.superheroes.data.DataManager;
import puliware.es.superheroes.data.remote.HeroesService;
import puliware.es.superheroes.injection.ApplicationContext;
import puliware.es.superheroes.injection.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(SyncService syncService);

    @ApplicationContext
    Context context();
    Application application();
    HeroesService superHeroesService();
    DataManager dataManager();

}
