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
        boolean flag = true;
        SpeciesQueue<Animal> queueCopy = this.queue.clone();
        while (!queueCopy.isEmpty()){
            if (!flag){
                sb.append(" ,");
            }
            sb.append(queueCopy.remove());
        }
        return sb.toString();
    }
}
