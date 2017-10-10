package puliware.es.superheroes.presenter;


import javax.inject.Inject;

import puliware.es.superheroes.data.DataManager;
import puliware.es.superheroes.injection.ConfigPersistent;
import puliware.es.superheroes.model.Superheros;
import puliware.es.superheroes.util.RxUtil;
import puliware.es.superheroes.view.ProvidedViewOperations;
import puliware.es.superheroes.view.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

@ConfigPersistent
public class MainPresenter extends BasePresenter<ProvidedViewOperations.MainMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ProvidedViewOperations.MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadSuperHeros() {
        checkViewAttached();
        RxUtil.unsubscribe(mSubscription);
        mSubscription = mDataManager.getSuperHeros()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Superheros>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading the ribots.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(Superheros superheros) {
                        if (superheros.superheroes().isEmpty()) {
                            getMvpView().showSuperHeroEmpty();
                        } else {
                            getMvpView().showSuperHeros(superheros.superheroes());
                        }
                    }
                });
    }

}
