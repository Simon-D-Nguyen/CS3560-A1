public class Student {
    private final int id;


    public Student (int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void vote(Question question) {
        //TODO
    }


    @Override
    public String toString() {
        return "ID: " + id;
    }
}
