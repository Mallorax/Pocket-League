package pl.patrykzygo.pocketleague.ViewModels;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Champion;

public class ChampionsViewModel {

    private final boolean hasError;
    private final boolean isLoading;
    private final String errorMessage;
    private List<Champion> championsList;

    private ChampionsViewModel(boolean hasError, boolean isLoading, String errorMessage, List<Champion> championsList) {
        this.hasError = hasError;
        this.isLoading = isLoading;
        this.errorMessage = errorMessage;
        this.championsList = championsList;
    }

    public boolean hasError(){return hasError;}
    public boolean isLoading(){return isLoading;}

    public List<Champion> getChampionsList() {
        return championsList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ChampionsViewModel loading(){return new ChampionsViewModel(false, true, null, null);}
    public static ChampionsViewModel succes(List<Champion> champions){return new ChampionsViewModel(false, false, null, champions);}
    public static ChampionsViewModel error(String errorMessage){return new ChampionsViewModel(true, false, errorMessage, null);}

}
