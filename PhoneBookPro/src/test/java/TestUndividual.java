import PhoneBook.Individual;
import PhoneBook.PhoneBook;
import org.junit.Assert;
import org.junit.Test;

public class TestUndividual {
    @Test
    public void userCreate() {
        Individual individual = new Individual("Han Solovich", "123", 123);
        Assert.assertNotNull(individual);
    }

    @Test
    public void userAddToPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addIndividual("Han Solovich", "123", 123456);
        Assert.assertTrue(phoneBook.containsIndividual("Han Solovich"));
    }

    @Test
    public void userAddToPhoneBook2() {
        PhoneBook phoneBook = new PhoneBook();
        Assert.assertFalse(phoneBook.containsIndividual("Han Solovich"));
    }
}
