/**
 * Created by Imran on 2017-01-24.
 */

//Createing The New Phone Plan Class
public class PhonePlan {
    private int minutesAllowed;
    private int minutesUsed;
    private int dataAllowed;
    private int dataUsed;
    private boolean planType;


    //Our PhonePlan Varibles
    public PhonePlan(int ma, int da, boolean pt) {
        minutesAllowed = ma;
        dataAllowed = da;
        planType = pt;
        minutesUsed = 0;
        dataUsed = 0;
    }

    //Our Get Methods
    public int getMinutesAllowed() {return this.minutesAllowed;}
    public int getMinutesUsed() {return this.minutesUsed;}
    public int getDataAllowed() {return this.dataAllowed;}
    public int getDataUsed() {return this.dataUsed;}
    public boolean getPlanType() {return this.planType;}
    public int getMinutesRemaining() {return this.minutesAllowed - this.minutesUsed;}
    public int getDataRemaining() {return this.dataAllowed - this.dataUsed;}
    public float getGBRemaining() {return this.dataAllowed / 1000000f;}

    //Our Set Methods
    public void setMinutesAllowed(int ma) {this.minutesAllowed = ma;}
    public void setMinutesUsed(int mu) {this.minutesUsed = mu;}
    public void setDataAllowed(int da) {this.dataUsed = da;}
    public void setDataUsed(int du) {this.dataUsed = du;}
    public void setPlanType(boolean pt) {this.planType = pt;}

    //ToSTring Prining Our THe Corerct Information REquired TO Print
    public String toString() {
        if (this.planType == true) {
            return ("\nPay-as-you-go Plan with " + (this.minutesAllowed - this.minutesUsed) + " minutes and " + (this.dataAllowed - this.dataUsed) + "KB remaining");}
        else {
            return ("\nRegular (" + (this.minutesAllowed - this.minutesUsed) + " minute, " + this.getGBRemaining() + "GB data) Monthly Plan with " + (this.minutesAllowed - this.minutesUsed) + " minutes remaining and " + (this.dataAllowed - this.dataUsed) + "KB remaining " );
        }
    }
}

