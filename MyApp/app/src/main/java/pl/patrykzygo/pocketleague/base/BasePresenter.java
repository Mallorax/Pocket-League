package pl.patrykzygo.pocketleague.base;



public interface BasePresenter<T extends BaseView> {

    void stop();
    void setView(T view);
}
