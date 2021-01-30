public class Customers implements People {

    private String name;
    private String surName;
    private String customerLevel; //Regular customer || Golden customer || Platinum customer
    private int age;
    private int bankAccountNumber;
    private int ID;
    private int savings;
    private CreditCard c;

    public Customers(String name, String surname, int age, int bankaccnumber, int savings, int id, int serialNumber, int securityNumber, String expirationDate, String customerLevel) {
        boolean valid = checkInputCustomer(age, id, expirationDate, customerLevel);
        if (valid) {
            this.name = name;
            this.surName = surname;
            this.age = age;
            this.bankAccountNumber = bankaccnumber;
            this.savings = savings;
            this.customerLevel = customerLevel;
            this.ID = id;
            idList.add(id); //adding the id to the list
            this.c = createCreditCard(name, surname, serialNumber, securityNumber, expirationDate);
            setCustomerLevel(customerLevel);
        } else {
            throw new AssertionError();
        }
    }

    /**
     * checks if customer parameters are valid
     * @param age age of new customer needs to be between 0 and 140
     * @param id must be new
     * @param expirationDate must be of the right format "MM/jj"
     * @param customerLevel must be either Regular customer || Golden customer || Platinum customer
     * @return if valid or not
     */
    public boolean checkInputCustomer(int age, int id, String expirationDate, String customerLevel) {
        if (age < 0 || age > 140) {
            return false;
        } else if (idList.contains(id)) {
            return false;
        } else if (!customerLevel.equals("Regular customer") && !customerLevel.equals("Golden customer") && !customerLevel.equals("Platinum customer")) {
            return false;
        } else if (expirationDate.length() != 5) {
            return false;
        } else if (expirationDate.charAt(2) != '/') {
            return false;
        } else if ((expirationDate.charAt(0) != '0') && (expirationDate.charAt(0) != '1' || (expirationDate.charAt(1) != '0' && expirationDate.charAt(1) != '1' && expirationDate.charAt(1) != '2'))) {
            return false;
        } else if (expirationDate.charAt(3) != '0' && expirationDate.charAt(3) != '1' && expirationDate.charAt(3) != '2' && expirationDate.charAt(3) != '3' && expirationDate.charAt(3) != '4' && expirationDate.charAt(3) != '5' && expirationDate.charAt(3) != '6' && expirationDate.charAt(3) != '7' && expirationDate.charAt(3) != '8' && expirationDate.charAt(3) != '9') {
            return false;
        } else if (expirationDate.charAt(4) != '0' && expirationDate.charAt(4) != '1' && expirationDate.charAt(4) != '2' && expirationDate.charAt(4) != '3' && expirationDate.charAt(4) != '4' && expirationDate.charAt(4) != '5' && expirationDate.charAt(4) != '6' && expirationDate.charAt(4) != '7' && expirationDate.charAt(4) != '8' && expirationDate.charAt(4) != '9') {
            return false;
        } else {
            return true;
        }
    }


    /**
     * creates credit card object
     * @param name  of new customer for card to be crated
     * @param surname of new customer  for card to be crated
     * @param serialNumber of new customer  for card to be crated
     * @param securityNumber of new customer  for card to be crated
     * @param expirationDate of new customer  for card to be crated
     * @return credit card object
     */
    public CreditCard createCreditCard(String name, String surname, int serialNumber, int securityNumber, String expirationDate) {
        CreditCard c = new CreditCard(name, surname, serialNumber, securityNumber, expirationDate);
        c.setCreditCardType(customerLevel);
        return c;
    }

    public void setCustomerLevel(String customerLevel) {
        if (customerLevel.equals("Regular customer") || customerLevel.equals("Golden customer") || customerLevel.equals("Platinum customer")) {
            this.customerLevel = customerLevel;
            c.setCreditCardType(customerLevel);
            c.setLimit();
        } else {
            throw new AssertionError();
        }
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getID() {
        return ID;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public int getAge() {
        return age;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public int getSavings() {
        return savings;
    }

    public CreditCard getC() {
        return c;
    }

    //Make Actions


    /**
     * depositing money
     * @param money amount to be deposited
     */
    public void depositing(int money) {
        if (money > 0) {
            this.savings = this.savings + money;
        } else {
            throw new AssertionError();
        }
    }


    /**
     * withdraw money
     * @param money amount to be withdrawn
     * @return amount money if available on account
     */
    public int withdrawing(int money) {

        if (money > this.savings || money <= 0) {
            throw new AssertionError();
        } else {
            this.savings = this.savings - money;
            return money;
        }
    }

    /**
     * transfering money
     * @param money amount to be transfered
     */
    public void bank_transfer(int money) {
        if (money > this.savings || money <= 0) {
            throw new AssertionError();
        } else {

            this.savings = this.savings - money;

        }
    }

    /**
     * paying money by card
     * @param money to be paid by card
     */
    public void pay_by_card(int money) {
        if (money <= 0) {
            throw new AssertionError();
        } else {
            c.pay(money);
        }
    }
}




