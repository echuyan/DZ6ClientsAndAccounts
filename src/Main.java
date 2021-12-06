import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    /**
     * Применяем на практике навыки управления equals
     * <p>
     * У нас есть банк , в котором хранятся золотые монеты.
     * У банка есть клиенты у которых есть имя и нам как банку важно знать их возраст для ограничений на операции.
     * У одного клиента может быть несколько счетов на которых хранятся золотые монеты.
     * <p>
     * Нужно реализовать следующую функциональность :
     * <p>
     * Найти все счета по клиенту (например List printAccountId(Client client) )
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
        Account acc23 = new Account("account3 of client2");
        Client client1 = new Client("Client1", LocalDate.of(2020, 5, 21));
        Client client2 = new Client("Client2", LocalDate.of(2001, 11, 5));
        HashMap<Account, Client> bankMap = new HashMap<Account, Client>();
        bankMap.put(acc11, client1);
        bankMap.put(acc12, client1);
        bankMap.put(acc21, client2);
        bankMap.put(acc22, client2);
        bankMap.put(acc23, client2);

        BankOperations bank = new BankOperations(bankMap);


        System.out.println("Вот какие клиенты и счета есть в банке:");
        bank.printAllClientsAndAccounts();

        //Добавим нового клиента, а потом добавим ему еще один счет
        Account acc31 = new Account("account1 of client3");
        Account acc32 = new Account("account2 of client3");
        Client client3 = new Client("Client3", LocalDate.of(1975, 11, 5));
        bank.addAccount(client3, acc31);
        bank.addAccount(client3, acc32);
        Account acc33 = new Account("account3 of client3");
        bank.addAccount(client3, acc33);

        System.out.println("А теперь вот какие клиенты и их счета есть в банке:");
        bank.printAllClientsAndAccounts();

        System.out.println("Поищем счета клиента 3:");
        bank.printAccountId(client3);

        System.out.println("А теперь поищем клиента по счету");
        bank.printClientName(acc31);

        System.out.println("Каким клиентам можем выдать деньги?");
        if (bank.canThisClientGetMoney(client1)) {
            System.out.println(client1.getName() + " может получить деньги");
        } else {
            System.err.println(client1.getName() + " не может получить деньги");
        }
        if (bank.canThisClientGetMoney(client2)) {
            System.out.println(client2.getName() + " может получить деньги");
        } else {
            System.err.println(client2.getName() + " не может получить деньги");
        }
        if (bank.canThisClientGetMoney(client3)) {
            System.out.println(client3.getName() + " может получить деньги");
        } else {
            System.err.println(client3.getName() + " не может получить деньги");
        }

    }
}
