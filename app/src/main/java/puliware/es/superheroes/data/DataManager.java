package puliware.es.superheroes.data;


import javax.inject.Inject;
import javax.inject.Singleton;

import puliware.es.superheroes.data.remote.HeroesService;
import puliware.es.superheroes.model.Superheros;
import rx.Observable;

@Singleton
public class DataManager {

    private final HeroesService heroesService;

    @Inject
    public DataManager(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    public Observable<Superheros> getSuperHeros() {
        return heroesService.getSuperHeros();
    }

}
