package inti.SAhomepage.Rental.domain;

public class Product {
    private int product_id;
    private String product_name;
    private int product_num;
    private int state;
    private String image_path;
    private String Checker;
    private Boolean isReserve;


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getChecker() {
        return Checker;
    }

    public void setChecker(String checker) {
        Checker = checker;
    }

    public Boolean getReserve() {
        return isReserve;
    }

    public void setReserve(Boolean reserve) {
        isReserve = reserve;
    }
}
