package pl.patrykzygo.pocketleague.ViewModels;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Item;

public class ItemsViewModel {

    private final boolean hasError;
    private final boolean isLoading;
    private final String errorMessage;
    private List<Item> items;

    private ItemsViewModel(boolean hasError, boolean isLoading, String errorMessage, List<Item> items) {
        this.hasError = hasError;
        this.isLoading = isLoading;
        this.errorMessage = errorMessage;
        this.items = items;
    }

    public boolean hasError(){return hasError;}
    public boolean isLoading(){return isLoading;}

    public List<Item> getItems() {
        return items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ItemsViewModel loading(){return new ItemsViewModel(false, true, null, null);}
    public static ItemsViewModel succes(List<Item> items){return new ItemsViewModel(false, false, null, items);}
    public static ItemsViewModel error(String errorMessage){return new ItemsViewModel(true, false, errorMessage, null);}
}
