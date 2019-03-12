package CloudPhoneBook;

import CloudPhoneBook.Repos.RepoIndividuals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private RepoIndividuals repoIndividuals;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/addIndividual")
    public String addIndividual(@RequestParam(value = "Name", required = true) String Name,
                                @RequestParam(value = "Phone", required = true) String Phone,
                                @RequestParam(value = "INIPA", required = true) int INIPA) {
        repoIndividuals.save(new Individual(Name, Phone, INIPA));

        return "ok";
    }

    @RequestMapping("/showAll")
    public List<Individual> showAll() {
        return repoIndividuals.findAll();
    }

    @RequestMapping("/removeUser")
    public String removeUser(@RequestParam(value = "Name", required = true) String Name) {
        repoIndividuals.delete(repoIndividuals.findByName(Name));

        return "removed";
    }

    @RequestMapping("/search")
    public Individual search(@RequestParam(value = "Name", required = true) String Name) {
//        return repoIndividuals.findByName(Name);
        for (Individual individual : repoIndividuals.findAll()) {
            if (individual.getName().equals(Name)) {
                return individual;
            }
        }

        return null;
    }
}
