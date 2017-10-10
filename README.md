# superhero

# Video

https://youtu.be/ndHazkEXhjY

# Resume

The app has been designed following MVP (https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) pattern. 
This pattern assumes perfectly all the functionality, waranty minimun couple between different layers and ensures communication.

First of all, two interfaces that are required and provided by the layers in the Model-View-Presenter have been designed. 
This design ensures loose coupling between the layers in the app's MVP-based architecture.


# Structure
Project has 3 packets related with MVP-based architecture:
- Model: contains classes that play the "Model" role in the Model-View-Presenter (MVP)
  pattern by defining an interface for providing data that will be
  acted upon by the "Presenter" and "View" layers in the MVP pattern.
  It implements the MVP/L.ProvidedModelOps
- Presenter: contains classes that play the "Presenter" role in the Model-View-Presenter
 (MVP) pattern by acting upon the Model and the View, i.e.,
  retrieves data from the Model (e.g., Profile) and
  display in the View (e.g., heroes list).
  Implements  MVP.ProvidedPresenterOps and
  MVP.RequiredPresenterOps to decouple the MVP layers.  
 - View: contains classes that play the "View" role in the Model-View-Presenter
 (MVP) pattern. All fragments, activities etc are here
 
 - Data plays the role of "repository" layer that connects with service using retrofit and manage fields mapping. Injection implements dagger based dependency injection

 Support libraries
- RecyclerViews and CardViews 
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid) 
- [Retrofit 2](http://square.github.io/retrofit/)
- [Dagger 2](http://google.github.io/dagger/)
- [Butterknife](https://github.com/JakeWharton/butterknife)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide](https://github.com/bumptech/glide)
- [AutoValue](https://github.com/google/auto/tree/master/value) with extensions [AutoValueParcel](https://github.com/rharter/auto-value-parcel) and [AutoValueGson](https://github.com/rharter/auto-value-gson)
- Functional tests with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/index.html)
- [Robolectric](http://robolectric.org/)
- [Mockito](http://mockito.org/)
- [Checkstyle](http://checkstyle.sourceforge.net/), [PMD](https://pmd.github.io/) and [Findbugs](http://findbugs.sourceforge.net/) for code analysis

## Requirements

- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html).
- Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html).
- Latest Android SDK Tools and build tools.


## Architecture

This project follows Android architecture guidelines that are based on [MVP (Model View Presenter)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter). Read more about them [here](https://github.com/ribot/android-guidelines/blob/master/architecture_guidelines/android_architecture.md).

### Tests

To run **unit** tests on your machine:

``` 
./gradlew test
``` 

To run **functional** tests on connected devices:

``` 
./gradlew connectedAndroidTest
``` 

Note: For Android Studio to use syntax highlighting for Automated tests and Unit tests you **must** switch the Build Variant to the desired mode.

### Code Analysis tools 

The following code analysis tools are set up on this project:

* [PMD](https://pmd.github.io/): It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. See [this project's PMD ruleset](config/quality/pmd/pmd-ruleset.xml).

``` 
./gradlew pmd
```

* [Findbugs](http://findbugs.sourceforge.net/): This tool uses static analysis to find bugs in Java code. Unlike PMD, it uses compiled Java bytecode instead of source code.

```
./gradlew findbugs
```

* [Checkstyle](http://checkstyle.sourceforge.net/): It ensures that the code style follows [our Android code guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md#2-code-guidelines). See our [checkstyle config file](config/quality/checkstyle/checkstyle-config.xml).

```
./gradlew checkstyle
```


