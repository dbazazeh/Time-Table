/**
 * Created by Dana on 4/20/16.
 */
public class CourseInstructor {

    int room;
    int slot;
    int day;


    public CourseInstructor(){

        day = -1;
        slot = -1;
        room = -1;

    }

    public CourseInstructor(int d, int s, int r){


        day = d;
        slot = s;
        room = r;

    }
    public void setDay(int d){
        day = d;
    }

    public void setSlot(int s){
        slot = s;
    }

    public void setRoom(int r){
        room = r;
    }

}

