/**
 * Created by Dana on 4/20/16.
 */
public class Individual {
    Course [] c = new Course[10];
    long fitness;

    public Individual (Course[] c){

        this.c = c;
        fitness = -1;
    }
}
