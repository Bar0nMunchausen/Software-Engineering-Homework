public class EmptyQueueException extends SpeciesQueueException {
    public EmptyQueueException() {
        super();
    }

    public EmptyQueueException(String message){
        super(message);
    }

    public EmptyQueueException(String message, Throwable cause){
        super(message, cause);
    }
}
