public class Student {
    private final int id;


    public Student (int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "ID: " + id;
    }
}
