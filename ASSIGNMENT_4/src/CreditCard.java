import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard {
    private String owner_name;
    private String owner_surName;
    private int serialNumber;
    private int securityNumber;
    private String expirationDate;
    private String creditCardType; //Regular || Gold || Platinum
    private int limit;
    private boolean Expired;

    public CreditCard(String owner_name, String owner_surName, int serialNumber, int securityNumber, String expirationDate){
        this.owner_name = owner_name;
        this.owner_surName = owner_surName;
        this.serialNumber = serialNumber;
        this.securityNumber = securityNumber;
        this.expirationDate = expirationDate;
        setLimit();

    }


    //getters
    public String getOwner_name(){
        return owner_name;
    }
    public String getOwner_surName(){
        return owner_surName;
    }
    public int getSerialNumber(){
        return serialNumber;
    }
    public int getSecurityNumber(){
        return securityNumber;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
    public String getCreditCardType(){
        return creditCardType;
    }

    //setter
    public void setCreditCardType(String customerLevel){
        if (customerLevel=="Regular customer"){
            this.creditCardType="Regular";
        }
        else if (customerLevel=="Golden customer"){
            this.creditCardType="Gold";
        }
        else{
            this.creditCardType="Platinum";
        }
    }
    public void setLimit() {
        if (this.creditCardType=="Regular"){
            this.limit = 2000;
        }
        else if(this.creditCardType=="Gold"){
            this.limit=5000;
        }
        else{
            this.limit=10000;
        }
    }

    /**
     * checks if date is expired
     */
    public void checkExpiration(){
        String input = this.expirationDate; 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);
        Date expiry = null;
        try {
            expiry = simpleDateFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.Expired = expiry.before(new Date());
    }



    /**
     * paying money
     * @param money amount to be paid
     */
    public void pay(int money){
        checkExpiration();
        if (money>this.limit || Expired){
                throw new AssertionError();
            }
        }
    }



