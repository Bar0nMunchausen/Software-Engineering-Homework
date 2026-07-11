public class Ark {

    private SpeciesQueue<Animal> queue;

    public Ark(){
        this.queue = new SpeciesQueue<Animal>();
    }

    public void enterToArk() {
        System.out.println("A " + this.queue.remove() + " entered the ark");
    }

    public void enterAllToArk() {
        while(!this.queue.isEmpty()){
            enterToArk();
        }
    }

    public void showQueue() {
         System.out.println(this.toString());
    }

    public void add(Animal animal) {
        this.queue.add(animal);
    }

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
