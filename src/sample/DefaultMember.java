package sample;

public class DefaultMember {
    private String name;
    private int membershipNumber;
    private Date regDate;
    private String date;
    private String type;

    //membership number method
    public int getMembershipNumber() {
        return membershipNumber;
    }

    //membership type method
    public String getType() {
        return type;
    }

    public DefaultMember() {
    }

    public DefaultMember(int membershipNumber, String name, Date regDate, String membershipType) {
        this.name = name;
        this.membershipNumber = membershipNumber;
        this.regDate = regDate;
        this.date=regDate.getDay()+"/"+regDate.getMonth()+"/"+regDate.getYear();
        type=membershipType;
    }

    //membership number method
    public void setmembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public int getmembershipNumber() {
        return membershipNumber;
    }

    //name method
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //date method
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
