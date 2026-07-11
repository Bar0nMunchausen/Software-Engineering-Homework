public class Animal implements Comparable<Animal>, Cloneable {
    private int dominance;

    public Animal(int dominance){
        this.dominance = dominance;
    }

    @Override
    public int compareTo(Animal other){
        return this.dominance - other.dominance;
    }

    public Animal clone() throws CloneNotSupportedException {
        Animal animal = (Animal) super.clone();
        return animal;
    }

    public String toString(){
        return this.getClass().getName();
    }
}
