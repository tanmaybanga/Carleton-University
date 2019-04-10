/**
 * Created by Imran on 2017-01-24.
 */

//Phone Plan TestProgram GIven To Us IN The Assingmenet Spec

    //System Printing Out The NEssecary Information
public class PlanTestProgram {
    public static void main(String args[]) {
        System.out.println( new PhonePlan(200, 2500000, false));
        System.out.println( new PhonePlan(250, 500000, true));
        System.out.println( new PhonePlan(300, 5000000, false));
        System.out.println( new PhonePlan(60,1000000, false));
        System.out.println( new PhonePlan(30, 0, true));
    }
}
