package CloudPhoneBook.Repos;

import CloudPhoneBook.Individual;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoIndividuals extends MongoRepository<Individual, String> {
    public Individual findByName(String name);
}
