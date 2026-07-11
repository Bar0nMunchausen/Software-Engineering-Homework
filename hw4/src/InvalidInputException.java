public class InvalidInputException extends SpeciesQueueException {
    /**
     * Thrown when invalid input (such as null) is passed to a queue operation.
     */

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
