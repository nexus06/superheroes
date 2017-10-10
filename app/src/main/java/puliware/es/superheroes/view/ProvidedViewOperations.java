package puliware.es.superheroes.view;


import java.util.List;

import puliware.es.superheroes.model.Profile;
import puliware.es.superheroes.view.base.MvpView;

public class ProvidedViewOperations {

    public interface MainMvpView extends MvpView {

        void showSuperHeros(List<Profile> superhero_avs);

        void showSuperHeroEmpty();

        void showError();

    }
}
