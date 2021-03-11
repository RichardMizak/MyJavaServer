package sk.kosickaakademia.sk;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class PresidentController {
    String sk="Čaputová";
    String cz="Zeman";
    String us="Biden";
    String ru="Putin";
    String fr="Macron";
    String hu="Áder";
    String pl="Duda";
    String it="Mattarella";
    String ua="Zelenskyj";
    List<String> list = new ArrayList<String>();

    public PresidentController(){
        list.add(sk);
        list.add(cz);
        list.add(us);
        list.add(ru);
        list.add(fr);
        list.add(hu);
        list.add(pl);
        list.add(it);
        list.add(ua);
    }


    @GetMapping("/presidents")
    public ResponseEntity<String> getJoke(){
        JSONObject o=new JSONObject();
        JSONArray jA=new JSONArray();
        for(String s:list){
            jA.add(s);
            o.put("presidents",jA);
        }
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
    }

}

