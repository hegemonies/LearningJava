package PhoneBook.repos;

import PhoneBook.LegalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LegalEntityRepo extends CrudRepository<LegalEntity, Integer> {
    ArrayList<LegalEntity> findByName(String Name);
}
