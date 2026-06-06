public class Director {
    private String name;
    private String biography;

    public Director(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public boolean equals(Director other){
        return this.name.equals(other.name);
    }

    public boolean equals(String otherName){
        return this.name.equals(otherName);
    }
}
