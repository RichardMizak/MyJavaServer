package sk.kosickaakademia.sk;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String getHello(){
        return "Hello";
    }
    @RequestMapping("/time")
    public String currentTime(){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return date.format(now);
    }
    @RequestMapping("/hi" )
    public String getHi(){
        return "Hi.";
    }
    @RequestMapping("/hi/test")
    public String getTest(@PathVariable String user){
        return "Test page";
    }
    @RequestMapping("/hi/{user}")
    public String getHiWithUser(@PathVariable String user){
        return "Hi "+user+".";
    }
}
