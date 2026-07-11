public class Ark {

    private SpeciesQueue<Animal> queue;

    public Ark(){
        this.queue = new SpeciesQueue<Animal>();
    }

    public void enterAllToArk() {
        this.queue.emptify();
    }

    public void showQueue() {
         System.out.println(this.toString());
    }

    public void add(Animal animal) {
        this.queue.add(animal);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        SpeciesQueue<Animal> queueCopy = this.queue.clone();
        while (!queueCopy.isEmpty()){
            sb.append(queueCopy.remove());
            sb.append(" ,");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
