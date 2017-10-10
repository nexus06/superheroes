package puliware.es.superheroes.injection.component;


import dagger.Subcomponent;
import puliware.es.superheroes.injection.PerActivity;
import puliware.es.superheroes.injection.module.ActivityModule;
import puliware.es.superheroes.view.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
