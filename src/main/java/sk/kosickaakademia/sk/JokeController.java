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
public class JokeController {
    String j1="I just read that someone in London gets stabbed every 52 seconds. Poor guy.";
    String j2="“Just say NO to drugs!” Well, If I’m talking to my drugs, I probably already said yes.";
    String j3="My grandfather says I'm too reliant on technology. I called him a hypocrite and unplugged his life support.";
    List<String> ar = new ArrayList<String>();



    @GetMapping("/jokes")
    public ResponseEntity<String> getJoke(){
        JSONObject o=new JSONObject();
        JSONArray jA=new JSONArray();
        ar.add(j1);
        ar.add(j2);
        ar.add(j3);
        for(String s:ar){
        jA.add(s);
        o.put("jokes",jA);
        }
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
    }
    @GetMapping("/joke/{id}")
    public ResponseEntity<String> getJokeById(@PathVariable int id){
        JSONObject o=new JSONObject();
        ar.add(j1);
        ar.add(j2);
        ar.add(j3);
        if(id>ar.size() || id<1){
            o.put("error","Invalid ID");
            return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
        }else{
        o.put("joke",ar.get(id-1));
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
        }
    }
    @GetMapping("/joke")
    public ResponseEntity<String> getRandomJoke() {
        JSONObject o = new JSONObject();
        ar.add(j1);
        ar.add(j2);
        ar.add(j3);
        if (ar.size()==0) {
            o.put("error", "we don't have jokes");
            return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
        } else {
            Random r = new Random();
            int index = r.nextInt(ar.size());
            String joke = ar.get(index);
            System.out.println(joke);
            o.put("joke", joke);
            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(o.toJSONString());
        }
    }

}
