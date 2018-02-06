package hystrixdashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HystrixDashboardController {

    // access root url will forward to ../hystrix
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
}
