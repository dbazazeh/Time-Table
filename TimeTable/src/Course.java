/**
 * Created by Dana on 4/20/16.
 */
public class Course {

    int courseNum;
    int instructor;
    CourseInstructor [] ci = new CourseInstructor [3];

    public Course(){
        courseNum = -1;
        instructor = -1;
        ci[0] = new CourseInstructor();
        ci[1] = new CourseInstructor();
        ci[2] = new CourseInstructor();

    }



    public Course (int n, int i, int in)
    {
        courseNum = n;
        instructor = i;
    }


    public void setInstructor(int i){

        instructor = i;

    }




}
