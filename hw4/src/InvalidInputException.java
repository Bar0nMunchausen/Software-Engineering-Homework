public class InvalidInputException extends SpeciesQueueException {
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message){
        super(message);
    }

    public InvalidInputException(String message, Throwable cause){
        super(message, cause);
    }
}
