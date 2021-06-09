package sample;

public class Date {
    private int year;
    private int month;
    private int day;

    //year method
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        //validation for year
        if (year > 2000 && year < 2021){
            this.year = year;
        }else {
            System.out.println("Please enter correct year.");
        }
    }

    //month method
    public int getMonth() {
            return month;
    }

    public void setMonth(int month) {
        //validation for month
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Please enter correct month");
        }
    }

    //day method
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        //validation for 31 days months
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day >= 1 && day <= 31 ) {
                this.day = day;
            }
            else {
                System.out.println("This month have only 31 days.");
            }
        }

        //validation for 30 days months
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 1 && day <= 30 ) {
                this.day = day;
            }
            else {
                System.out.println("This month have only 30 days.");
            }
        }

        //validation for february
        else if (month == 2 ) {
            if (day >= 1 && day <= 29 ) {
                this.day = day;
            }
            else {
                System.out.println("This month have only 28 or 29 days.");
            }
        }

        else {
            System.out.println("Please enter correct day");
        }
    }
}
