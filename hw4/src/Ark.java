public class Ark {

    private SpeciesQueue<Animal> queue;

    /**
     * Initialize an empty Ark object.
    **/
    public Ark(){
        this.queue = new SpeciesQueue<Animal>();
    }

    /**
     * Removes and prints the first animal in the queue.
     */
    public void enterToArk() {
        System.out.println("A " + this.queue.remove() + " entered the ark");
    }

    /**
     * Removes and prints ALL the animals in the queue.
     */
    public void enterAllToArk() {
        while(!this.queue.isEmpty()){
            enterToArk();
        }
    }

    /**
     * Prints ALL the animals in the queue.
     */
    public void showQueue() {
         System.out.println(this);
    }

    /**
     * Adds the given animal to the queue.
     * @param animal The animal to add.
     */
    public void add(Animal animal) {
        this.queue.add(animal);
    }

    /**
     * Builds and returns the list of all animals in the queue
     * @return List of all animals.
     */
    @Override
    public String toString(){
        if (this.queue == null) return "";
        StringBuilder sb = new StringBuilder();
        SpeciesQueue<Animal> queueCopy = this.queue.clone();
        while (!queueCopy.isEmpty()){
            sb.append(queueCopy.remove());
            sb.append(", ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
