package PhoneBook.Controllers;

import PhoneBook.LegalEntity;
import PhoneBook.repos.LegalEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    private LegalEntityRepo legalEntityRepo;

    @GetMapping
    public String main() {
        return "main";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<LegalEntity> getAllUsers() {
        return legalEntityRepo.findAll();
    }
}
