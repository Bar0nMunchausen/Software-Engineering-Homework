public class EmptyQueueException extends SpeciesQueueException {
    /**
     * Thrown when tring to access or remove an element from empty queue.
     */
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
