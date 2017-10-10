
package puliware.es.superheroes.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

import puliware.es.superheroes.model.AutoValue_Superheros;

@AutoValue
public abstract class Superheros
{

    private List<Profile> superheroes = null;

    @Nullable
    public abstract List<Profile> superheroes();

    public static Superheros create(List<Profile> shList) {
        return new AutoValue_Superheros(shList);
    }

    public static TypeAdapter<Superheros> typeAdapter(Gson gson) {
        return new AutoValue_Superheros.GsonTypeAdapter(gson);
    }

}
