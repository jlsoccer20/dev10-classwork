package learn.solarfarm.data;

public class DataAccessException extends Exception {
// hide any details of what happened if issues accesssing data
    // custom exception
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
