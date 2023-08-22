package learn.gomoku.game;

import java.util.Objects;

public class Result {

    private final boolean success;
    private final String message;

    // Constructor
    public Result(String message) {
        this(message, false);
    }

    // Constructor
    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Method with return type "boolean"
    public boolean isSuccess() {
        return success;
    }

    // Method with return type "String"
    public String getMessage() {
        return message;
    }


    // Method with return type "boolean"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return success == result.success &&
                Objects.equals(message, result.message);
    }

    // Method with return type "int"
    @Override
    public int hashCode() {
        return Objects.hash(success, message);
    }

    // Method with return type "String"
    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
