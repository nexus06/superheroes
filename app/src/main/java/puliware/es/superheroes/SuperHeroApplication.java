package puliware.es.superheroes;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import puliware.es.superheroes.injection.component.ApplicationComponent;
import puliware.es.superheroes.injection.component.DaggerApplicationComponent;
import puliware.es.superheroes.injection.module.ApplicationModule;
import timber.log.Timber;

public class SuperHeroApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Fabric.with(this, new Crashlytics());
        }
    }

    public static SuperHeroApplication get(Context context) {
        return (SuperHeroApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
