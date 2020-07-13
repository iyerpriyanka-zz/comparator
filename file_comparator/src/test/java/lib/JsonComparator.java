package lib;


import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

public class JsonComparator {

    public Boolean jsonComparator(JsonPath value1, JsonPath value2){
        Map<Object, Object> response1 = new HashMap<>();
        Map<Object, Object> response2 = new HashMap<>();
        if (value1 != null){
            response1 = value1.getMap(".");
        }
        if (value2 !=null){
            response2 = value2.getMap(".");
        }

        if(response1.equals(response2)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
