import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    /**
     *
     * Применяем на практике навыки управления equals
     *
     * У нас есть банк , в котором хранятся золотые монеты.
     * У банка есть клиенты у которых есть имя и нам как банку важно знать их возраст для ограничений на операции.
     * У одного клиента может быть несколько счетов на которых хранятся золотые монеты.
     *
     * Нужно реализовать следующую функциональность :
     *
     * Найти все счета по клиенту (например List getAccounts(Client client) )
     * Найти клиента по счету (например Client findClient(Account account) ) Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
     * В классах Client и Account должно быть минимальное кол-во полей, достаточное для этой задачи.
     */
    public static void main(String[] args) {

        //Подготовка тестовых данных
        //Можно вывести их хранение в файл, бд, конфиг....
        Account acc11 = new Account("account1 of client1");
        Account acc12 = new Account("account2 of client1");
        Account acc21 = new Account("account1 of client2");
        Account acc22 = new Account("account2 of client2");
        Account acc23= new Account("account3 of client2");
        HashSet<Account> accounts1 = new HashSet<Account>();
        HashSet<Account> accounts2 = new HashSet<Account>();
        accounts1.add(acc11);
        accounts1.add(acc12);
        accounts2.add(acc21);
        accounts2.add(acc22);
        accounts2.add(acc23);
        HashSet<Client> clients = new HashSet<Client>();
        Client client1 = new Client("Client1",new GregorianCalendar(2020,11,5),accounts1);
        Client client2 = new Client("Client2",new GregorianCalendar(2001,11,5),accounts2);
        clients.add(client1);
        clients.add(client2);

        //Новый объект-экземпляр банка
        BankOperations bank = new BankOperations(clients);

        System.out.println("Вот какие клиенты есть в банке:");
        bank.printAllClientsAndAccounts();

        //Добавим нового клиента, а потом добавим ему еще один счет
        Account acc31 = new Account("account1 of client3");
        Account acc32 = new Account("account2 of client3");
        HashSet<Account> accounts3 = new HashSet<Account>();
        accounts3.add(acc31);
        accounts3.add(acc32);
        Client client3 = new Client("Client3",new GregorianCalendar(1975,11,5),accounts3);
        bank.addClient(client3);
        Account acc33 = new Account("account3 of client3");
        bank.addAccount(client3,acc33);

        System.out.println("А теперь вот какие клиенты есть в банке:");
        bank.printAllClientsAndAccounts();

        System.out.println("Поищем счета клиента 3:");
        for (Account a:bank.getAccounts(client3)) {
            System.out.println(a.id); };

        System.out.println("А теперь поищем клиента по id счета");//хотя тут может быть стоило бы икать не по объекту Account, а именно по номеру счета?
        System.out.println(bank.getClient(acc33).name);
    }
}
