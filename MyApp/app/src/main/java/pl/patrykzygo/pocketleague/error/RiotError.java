package pl.patrykzygo.pocketleague.error;

import java.io.IOException;

public class RiotError extends IOException {

    private int responseCode;
    private String errorMessage;

    public RiotError(int responseCode, String errorMessage){
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
