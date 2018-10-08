/**
 * Created by Dana on 4/19/16.
 */
    // 7 instructors
    // 10 courses
    //4 slots per day
    //2 rooms
    //5 days

import java.util.Random;

public class TimeTable {


    public static void main(String [] args){

        Course[] c  = new Course[10];
        Individual[] Individual = new Individual[20];

        for (int i = 0; i<c.length; i++ ){

            c[i] = new Course();
        }
        for (int i = 0; i<Individual.length; i++ ){

            Individual[i] = new Individual(c);
        }

      for (int i=0; i <c.length ; i++){
          c[i].courseNum  = i;
      }

        c[0].instructor = 0;
        c[1].instructor = 0;
        c[2].instructor = 1;
        c[3].instructor = 2;
        c[4].instructor = 2;
        c[5].instructor = 3;
        c[6].instructor = 4;
        c[7].instructor = 5;
        c[8].instructor = 5;
        c[9].instructor = 6;


        Individual =  InitialPopulation(c, Individual);

        System.out.println(Individual[0].c[0].ci[0].day);
        System.out.println(Individual[0].c[0].ci[2].day);



            for (int i = 0; i < c.length; i++) {
                System.out.println("course num : " + Individual[0].c[i].courseNum);
                System.out.println(" instructor : " + Individual[0].c[i].instructor);

                for (int j = 0; j < 3; j++) {
                    System.out.print(" day : " + Individual[0].c[i].ci[j].day);
                    System.out.print(" slot: " + Individual[0].c[i].ci[j].slot);
                    System.out.println(" room: " + Individual[0].c[i].ci[j].room);
                }

            }

        fitnessFunction(Individual[0]);
        fitnessFunction(Individual[4]);
        System.out.println(Individual[0].fitness);
        System.out.println(Individual[4].fitness);




    }

    public static Individual[] InitialPopulation(Course[] c, Individual[] ind) {
        Random rand = new Random();

        for (int k = 0; k < ind.length; k++) {

            for (int i = 0; i < c.length; i++) {

                for (int j = 0; j < 3; j++) {
                    ind[k].c[i].ci[j].day =  rand.nextInt((5 - 1) + 1) + 1;
                    ind[k].c[i].ci[j].room = rand.nextInt((2 - 1) + 1) + 1;
                    ind[k].c[i].ci[j].slot = rand.nextInt((4 - 1) + 1) + 1;
                }
            }
        }
        return ind;
    }

//    public static Individual[] Crossover(Individual [] ind){
//        float pc = 0.8;
//        Random rand = new Random();
//        float pc1 = 0;
//        float pc2 = 0;
//
//        for (int i = 0; i < ind[0].c.length/2; i++) {
//            pc1 = rand.nextFloat((1 - 0) + 1) + 0;
//            if (pc1 < pc){
//
//            }
//
//        }
//
//    }
    public static Individual[] Mutation(Individual [] ind){
        double pm = 0.1;
        Random rand = new Random();
        double pm1 = 0;
        double pm2 = 0;

        for (int k = 0 ; k< ind.length; k++){
             pm1 = Math.random() * 1.0;
            if (pm1 < pm){
                for (int i = 0; i < ind[0].c.length; i++) {

                    for (int j = 0; j < 3; j++) {
                        pm2  = Math.random() * 1.0;
                        if (pm2 < pm){
                            ind[k].c[i].ci[j].day =  rand.nextInt((5 - 1) + 1) + 1;
                            ind[k].c[i].ci[j].room = rand.nextInt((2 - 1) + 1) + 1;
                            ind[k].c[i].ci[j].slot = rand.nextInt((4 - 1) + 1) + 1;
                        }
                    }
                }

            }
        }
        return ind;

    }
    public static Individual [] selectionFunction (Individual [] ind, Course [] c){
        Individual[] newInd = new Individual[20];
        Random rand = new Random();
        int randomNum = 0;
        int size = ind.length;
        for (int i = 0; i<newInd.length; i++ ){

            newInd[i] = new Individual(c);
        }
        Individual i1 = new Individual(c);
        Individual i2 = new Individual(c);
        Individual i3 = new Individual(c);
        for (int i = 0; i<newInd.length; i++ ){
            randomNum = rand.nextInt(((size-1) - 0) + 0) + 0;
            i1 = ind[randomNum];
            randomNum = rand.nextInt(((size-1) - 0) + 0) + 0;
            i2 = ind[randomNum];
            randomNum = rand.nextInt(((size-1) - 0) + 0) + 0;
            i3 = ind[randomNum];

            if (i1.fitness >= i2.fitness)
            {

                if (i1.fitness>= i3.fitness)
                {
                    newInd[i] = i1;
                }
                   else{ newInd[i] = i3;

                }
            }
            else {
                if (i2.fitness>= i3.fitness)
                {
                    newInd[i] = i2;
                }
                else{ newInd[i] = i3;

                }
            }

        }
return newInd;

    }

    public static void fitnessFunction (Individual ind){
        long conflict = 0;
        int conflict1 = 0;
        int conflict2 = 0;

        int numOfInstructos = 7;
        int instructorConflict[] = new int [numOfInstructos];

        for ( int m = 0; m< numOfInstructos; m++){

            instructorConflict[m] = 0;
        }



       for (int day = 1; day <=5; day++){

           for (int slot =1; slot<=4; slot++){

               for (int i = 0; i < ind.c.length; i++) {

                   for (int j = 0; j < 3; j++) {
                       if (ind.c[i].ci[j].day == day && ind.c[i].ci[j].slot == slot && ind.c[i].ci[j].room == 1)
                           conflict1++;

                       if (ind.c[i].ci[j].day == day && ind.c[i].ci[j].slot == slot && ind.c[i].ci[j].room == 2)
                           conflict2++;



                       if (conflict1 + conflict2 > 2 )
                           conflict += conflict1 + conflict2 - 2;
                       System.out.println("conflict: " + conflict);

                       for (int l = 0; l < numOfInstructos; l++)
                       {
                           if (ind.c[i].ci[j].day == day && ind.c[i].ci[j].slot == slot && ind.c[i].instructor == l)
                           instructorConflict[l] ++;
                           if (instructorConflict[l] > 1 )
                               conflict ++;
                        }
                   }
               }

//               conflict += conflict1 + conflict2 - 2;
//               for (int l = 0; l < numOfInstructos; l++)
//               {
//
//                       conflict += instructorConflict[l];
//
//                       conflict = conflict - 7;
               conflict1 = 0;
               conflict2 = 0;
               for (int l = 0; l < numOfInstructos; l++)
               {

                  instructorConflict[l] = 0;
               }
           }

       }

        ind.fitness = conflict;

    }



}
