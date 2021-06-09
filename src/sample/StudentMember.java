package sample;

public class StudentMember extends DefaultMember {
    private String schoolName;

    public StudentMember(){}


    public StudentMember(int membershipNumber, String name, Date regDate, String membershipType) {
        super(membershipNumber,name,regDate,membershipType);
    }

    //school name method
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
