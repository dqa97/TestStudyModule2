package Models;

public class PhoneBook {
    private long phoneNumber;
    private String group;
    private String name;
    private String sex;
    private String address;

    public PhoneBook(){
    }
    public PhoneBook(long phoneNumber, String group, String name, String sex, String address){
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.sex = sex;
        this.group = group;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

