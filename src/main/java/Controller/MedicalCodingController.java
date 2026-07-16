package Controller;

import lombok.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalCodingController {


    // Reading the vlues of property file
   // @Value("${app.name}")

    private String appName ;

   // @Value("${app.version}")
    private String appVersion;

    @GetMapping("/appdetails")

    public String getAppDetails( ) {

        return "App Name: "+appName + "\nApp Version: "+ appVersion;
    }

    @GetMapping("/")
    public String homePage() {
        return "Home";
    }

    @RequestMapping(value = "/task" , method = RequestMethod.GET)
    @ResponseBody
    public String getEmployee() {

        return "display the list of employees";

    }

}
