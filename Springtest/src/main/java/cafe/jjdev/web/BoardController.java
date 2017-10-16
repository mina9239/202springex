package cafe.jjdev.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	@RequestMapping(value="/boardAdd", method = RequestMethod.GET)
    public String boardAdd() {
        return "boardAdd";
    }
}