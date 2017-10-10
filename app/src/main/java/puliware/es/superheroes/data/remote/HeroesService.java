package puliware.es.superheroes.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import puliware.es.superheroes.model.Superheros;
import puliware.es.superheroes.util.MyGsonTypeAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public interface HeroesService {

    String ENDPOINT = "https://api.myjson.com/bins/";

    @GET("bvyob")
    Observable<Superheros> getSuperHeros();

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static HeroesService newRibotsService() {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(HeroesService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(HeroesService.class);
        }
    }
}
