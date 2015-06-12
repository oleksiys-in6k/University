package university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by employee on 6/12/15.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "home";
    }
}
