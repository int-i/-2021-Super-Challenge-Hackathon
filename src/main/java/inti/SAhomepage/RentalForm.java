package inti.SAhomepage;


import java.sql.Date;

public class RentalForm {
    private int payer_id;
    private String checker;

    public int getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(int payer_id) {
        this.payer_id = payer_id;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }
}
