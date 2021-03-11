package sk.kosickaakademia.sk;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @PostMapping(path="/add")
    public ResponseEntity<String> addNumbers(@RequestBody String input){
        try {
            JSONObject o=(JSONObject) new JSONParser().parse(input);
            int a=Integer.parseInt(String.valueOf(o.get("a")));
            int b=Integer.parseInt(String.valueOf(o.get("b")));
            int result=a+b;
            JSONObject r=new JSONObject();
            r.put("result",result);
            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(r.toJSONString());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            JSONObject o=new JSONObject();
            o.put("Error","Incorrect request");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
        }
        return null;
    }
    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(@RequestParam(value="a")int a,@RequestParam(value="b")int b){
        int result=(a*b);
        JSONObject o=new JSONObject();
        o.put("result",result);
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
    }
}
