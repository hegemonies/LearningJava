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
    public String addIndividual(@RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "phone", required = true) String phone,
                                @RequestParam(value = "INIPA", required = true) int INIPA) {
        repoIndividuals.save(new Individual(name, phone, INIPA));

        return "ok";
    }

    @RequestMapping("/showAll")
    public List<Individual> showAll() {
        return repoIndividuals.findAll();
    }

    // to-do: don't work
    @RequestMapping("/removeUser")
    public String removeUser(@RequestParam(value = "Name", required = true) String Name) {
        repoIndividuals.delete(repoIndividuals.findByName(Name));

        return "removed";
    }

    @RequestMapping("/search")
    public Individual search(@RequestParam(value = "name", required = true) String name) {
        return repoIndividuals.findByName(name);
    }
}
