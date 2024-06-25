package courses.lesson_7;

public class MyArrayDataException extends Throwable {
    private String message;

    MyArrayDataException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
