package Entity;

public class User {
    private Integer uid;
    private String uname;
    private String password;
    private String telephone;
    private String address;
    private Integer ulevel;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    public User(Integer uid, String uname, String password, String telephone, String address, Integer ulevel) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.ulevel = ulevel;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", ulevel=" + ulevel +
                '}';
    }
}
