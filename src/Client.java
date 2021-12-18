import java.time.LocalDate;


public class Client {

    private String name;
    private LocalDate birthdayDate;


    public Client(String name, LocalDate birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdayDate(Client c) {

        return birthdayDate;

    }


}




