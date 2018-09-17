package pl.patrykzygo.pocketleague.ViewModels;


import pl.patrykzygo.pocketleague.pojo.Champion;

public class ChampionViewModel {

    private final boolean hasError;
    private final boolean isLoading;
    private final String errorMessage;
    private Champion champion;

    private ChampionViewModel(boolean hasError, boolean isLoading, String errorMessage, Champion champion) {
        this.hasError = hasError;
        this.isLoading = isLoading;
        this.errorMessage = errorMessage;
        this.champion = champion;
    }

    public boolean hasError(){return hasError;}
    public boolean isLoading(){return isLoading;}

    public Champion getChampion() {
        return champion;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ChampionViewModel loading(){return new ChampionViewModel(false, true, null, null);}
    public static ChampionViewModel succes(Champion champion){return new ChampionViewModel(false, false, null, champion);}
    public static ChampionViewModel error(String errorMessage){return new ChampionViewModel(true, false, errorMessage, null);}

}
