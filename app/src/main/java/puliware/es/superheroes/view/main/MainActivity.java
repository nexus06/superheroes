package puliware.es.superheroes.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import puliware.es.superheroes.R;
import puliware.es.superheroes.model.Profile;
import puliware.es.superheroes.presenter.MainPresenter;
import puliware.es.superheroes.util.DialogFactory;
import puliware.es.superheroes.view.ProvidedViewOperations;
import puliware.es.superheroes.view.base.BaseActivity;

public class MainActivity extends BaseActivity implements ProvidedViewOperations.MainMvpView, SuperHerosAdapter.OnListFragmentInteractionListener {


    @Inject
    MainPresenter mMainPresenter;
    @Inject
    SuperHerosAdapter superHerosAdapter;

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setAdapter(superHerosAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPresenter.attachView(this);
        mMainPresenter.loadSuperHeros();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    /***** MVP View methods implementation
     * @param superhero_avs*****/

    @Override
    public void showSuperHeros(List<Profile> superhero_avs) {
        superHerosAdapter.setHeroes(superhero_avs);
        superHerosAdapter.setListener(this);
        superHerosAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_heroes))
                .show();
    }

    @Override
    public void showSuperHeroEmpty() {
        superHerosAdapter.setHeroes(Collections.<Profile>emptyList());
        superHerosAdapter.setListener(this);
        superHerosAdapter.notifyDataSetChanged();
        Toast.makeText(this, R.string.empty_heroes, Toast.LENGTH_LONG).show();
    }

    /**
     * Return an Intent to start this Activity.
     */
    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void onListFragmentInteraction(Profile hero) {
        StringBuilder bl = new StringBuilder();
        bl.append(getString(R.string.groups));
        bl.append("\n");
        bl.append(hero.groups());
        bl.append("\n\n");
        bl.append(getString(R.string.abilities));
        bl.append("\n");
        bl.append(hero.abilities());
        bl.append("\n\n");
        bl.append(getString(R.string.power));
        bl.append("\n");
        bl.append(hero.power());
        DialogFactory.createSimpleOkErrorDialog(this, hero.name(), bl.toString() ).show();
    }
}
