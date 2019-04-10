/**
 * Created by Imran on 2017-01-25.
 */
public class Customer {

    //Setting Strings
    private String name;
    private CellPhone model;
    private PhonePlan planType;
    private int callsMade;
    private float balance;
    private float dataConverterPrice = 1000000f;

    //Inserted For The Data Conversion
    public float getDataConverterPrice() {
        return dataConverterPrice;
    }


    //Setting Our Strings Again
    public Customer(String na, CellPhone mo, PhonePlan pt) {
        name = na;
        model = mo;
        planType = pt;
        callsMade = 0;
        balance = 0;
    }

    //Setting Our Get and Set Methods
    public String getName() {
        return this.name;
    }
    public CellPhone getmodel() {
        return this.model;
    }
    public int getcallsMade() {
        return this.callsMade;
    }
    public float getBalance() {
        return this.balance;
    }
    public boolean getPlanType() {
        return this.planType.getPlanType();
    }


    //Setting Our Get and Set Methods
    public void setName(String na) {
        this.name = na;
    }
    public void setModel(CellPhone mo) {
        this.model = mo;
    }
    public void setCallsMade(int cm) {
        this.callsMade = cm;
    }
    public void setBalance(float b) {
        this.balance = b;
    }
    public void setPlanType(boolean pt) {
        this.planType.setPlanType(pt);
    }

    //To String Printing Our Information
    public String toString() {
        if (this.planType.getPlanType() == true) {
            return (this.name + " with a " + this.model.getManufacturer() + " " + this.model.getModel() + " on a Pay-as-you-go Plan with " + (this.planType.getMinutesAllowed() - this.planType.getMinutesUsed()) + " minutes and " + (this.planType.getDataAllowed() - this.planType.getDataUsed()) + " KB Remaining ");
        } else {
            return (this.name + " with a " + this.model.getManufacturer() + " " + this.model.getModel() + " on a Regular (" + (this.planType.getMinutesAllowed() - this.planType.getMinutesUsed()) + " Minute, " + this.planType.getGBRemaining() + " GB data) " + " Monthly Plan with " + (this.planType.getMinutesAllowed() - this.planType.getMinutesUsed()) + " minutes remaining and " + (this.planType.getDataAllowed() - this.planType.getDataUsed()) + " KB remaining ");
        }
    }

    //Phone Class With The Calls Made Adding +1 Function
    public void phone(Customer customerLine, int callLength) {
        if (customerLine.planType.getPlanType() == true && callLength > customerLine.planType.getMinutesRemaining() ||
                this.planType.getPlanType() == true && callLength > this.planType.getMinutesRemaining()) {
            System.out.println("Customer Cannot Make This Call");
        } else {
            this.planType.setMinutesUsed(callLength + this.planType.getMinutesUsed());
            customerLine.callsMade += 1;
            customerLine.planType.setMinutesUsed(callLength + customerLine.planType.getMinutesUsed());
            callsMade += 1;
        }
    }

    //Retruing Phone Plan
    public PhonePlan getPlan() {
        return this.planType;
    }

    //Buying Minutes Function
    public void buyMinutes(int buyingMin) {
        if (this.planType.getPlanType() == true) {
            this.planType.setMinutesAllowed(this.planType.getMinutesUsed() + buyingMin);
            setBalance(0.40f * buyingMin);
        }
    }

    //Tracking Internet Acess
    public void accessInternet(int internetLength) {
        if (this.planType.getPlanType() == true && internetLength > this.planType.getDataRemaining()) {
            System.out.println("There Is No More Data Remaining To Be Used");
        } else {
            this.planType.setDataUsed(internetLength + this.planType.getDataUsed());
        }
    }

    //Monthly Charges Calculation
    public float monthlyChargeCalculation() {
        float monthlyCharge = 0;
        if (this.planType.getPlanType() == false) {
            if (this.planType.getMinutesAllowed() == 200) {
                monthlyCharge = 25 + ((this.planType.getDataAllowed() / getDataConverterPrice()) * 10);
            }
            else if (this.planType.getMinutesAllowed() == 100) {
                monthlyCharge = 15 + ((this.planType.getDataAllowed() / getDataConverterPrice()) * 10);
            }
        }
        else if (this.planType.getPlanType() == true){
            monthlyCharge = ((this.planType.getMinutesRemaining() + this.planType.getMinutesUsed()) * 0.4f);
        }
        return monthlyCharge;
    }

    //HST Charge Calcualtion
    public float hstTaxes() {
        if (this.planType.getPlanType() == true) {
            float hstCharge = (this.monthlyChargeCalculation() * 1.13f);
        }
        return ((this.monthlyChargeCalculation() + this.voiceOverCharge() + dataOverCharge()) * 0.13f);

    }

    //Charges That Customer Will Recive If They Go OVer There Phone Bull
    public float voiceOverCharge(){
        float voiceOverCharge = 0;
        if (this.planType.getMinutesUsed() > this.planType.getMinutesAllowed()) {
            voiceOverCharge = 0.15f * (this.planType.getMinutesUsed() - this.planType.getMinutesAllowed());
        }
        return voiceOverCharge;
    }

    //Charges That The Customer Will Recive If They Go OVer There Allowed Data, Including The Math Needed
    public float dataOverCharge(){
        float dataOverCharge = 0;
        if (this.planType.getDataUsed() > this.planType.getDataAllowed()) {
            dataOverCharge = 0.00005f * (this.planType.getDataUsed() - this.planType.getDataAllowed());
        }
        return dataOverCharge;
    }

    //Total Charges Calculation
    public float totalChargeCalculationBeforeTax(){
        float total = 0;
        total = monthlyChargeCalculation() + voiceOverCharge() + dataOverCharge();
        return total;
    }

    //Printing Our Total Statement, The % Sign Was USed to keep Everything In Line and Sting.Format used for Foratting As Seen
    //There Is Two Different Sets as One is for Pay-as-you-go, and One Is For Regualar
    public void printMonthlyStatement() {
        if (this.planType.getPlanType() == true) {
            System.out.println(String.format("\n%-25s", "Name:") + this.name);
            System.out.println(String.format("%-25s", "Plan Type:") + "Pay-as-you-go");
            System.out.println(String.format("%-25s", "Mintues Used:") + this.planType.getMinutesUsed());
            System.out.println(String.format("%-25s", "Minutes Remaining:") + this.planType.getMinutesRemaining());
            System.out.println(String.format("%-25s", "Data Used:") + this.planType.getDataUsed());
            System.out.println(String.format("%-25s", "Data Remaining:") + this.planType.getDataRemaining());
            System.out.println(String.format("%-25s", "Calls Made:") + this.callsMade);
            System.out.println(String.format("%-25s", "Monthly Charges:") + "$" + this.monthlyChargeCalculation());
            System.out.println(String.format("%-25s", "HST:") + "$" + this.hstTaxes());
            System.out.println(String.format("%-25s", "Total Due:") + "$" + (this.totalChargeCalculationBeforeTax()) * 1.13f);

        } else {
            System.out.println(String.format("\n%-25s", "Name:") + this.name);
            System.out.println(String.format("%-25s", "Plan Type:") + "Regular Monthly" + " (" + this.planType.getMinutesAllowed() + " Minutes, " + this.planType.getGBRemaining() + "GB Data)");
            System.out.println(String.format("%-25s", "Mintues Used:") + this.planType.getMinutesUsed());
            System.out.println(String.format("%-25s", "Data Used:") + this.planType.getDataUsed());
            System.out.println(String.format("%-25s", "Calls Made:") + this.callsMade);
            System.out.println(String.format("%-25s", "Monthly Charges:") + "$" + this.monthlyChargeCalculation());
            System.out.println(String.format("%-25s", "Voice Overtime Charges:") + "$" + this.voiceOverCharge());
            System.out.println(String.format("%-25s", "Data Overusage Charges:") + "$" + this.dataOverCharge());
            System.out.println(String.format("%-25s", "HST:") + "$" + this.hstTaxes());
            System.out.println(String.format("%-25s", "Total Due:") + "$" + (this.totalChargeCalculationBeforeTax()) * 1.13f);
        }
    }



}
