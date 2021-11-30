import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class Client{

public String name;
private GregorianCalendar birtdayDate;


    public Client(String name, GregorianCalendar birtdayDate) {
        this.name = name;
        this.birtdayDate = birtdayDate;
       }

       public String getName() {
        return name;
       }

       public GregorianCalendar getBirthdayDate(Client c) {

        return birtdayDate;

       }


}




