package tvAddicts.exceptions;

public class InvalidSeasonIntervalException extends TVAddictException {
    public InvalidSeasonIntervalException() {
    }

    public String getMessage(){
        return "Invalid seasons interval!";
    }
}
