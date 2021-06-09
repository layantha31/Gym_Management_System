package sample;

public class Over60Member extends DefaultMember{
    private int age;

    public Over60Member(){}

    public Over60Member(int membershipNumber, String name, Date regDate, String membershipType) {
        super(membershipNumber,name,regDate,membershipType);
    }

    //age method
    public void setAge(int age) {
        //validation for age
        if (age >= 60 && age<= 120){
            this.age = age;
        }else {
            System.out.println("Not over 60 member");
        }
    }

    public int getAge() {
        return age;
    }
}
