package inti.SAhomepage.Locker.Domain;

public class Payer {

    private int Id;
    private String Name;
    private String Phone;
    private int Locker_id;

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getLocker_id() {
        return Locker_id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setLocker_id(int locker_id) {
        Locker_id = locker_id;
    }
}
