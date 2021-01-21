package inti.SAhomepage.Locker.Domain;

public class Lock {

    private int Locker_id;
    private int No_user;
    private boolean find_empty;
    private int usercnt;

    public int getLocker_id() {
        return Locker_id;
    }

    public void setLocker_id(int locker_id) {
        Locker_id = locker_id;
    }

    public boolean isFind_empty() {
        return find_empty;
    }

    public void setFind_empty(boolean find_empty) {
        this.find_empty = find_empty;
    }

    public int getNo_user() {
        return No_user;
    }

    public void setNo_user(int no_user) {
        No_user = no_user;
    }

    public int getUsercnt() {
        return usercnt;
    }

    public void setUsercnt(int usercnt) {
        this.usercnt = usercnt;
    }
}
