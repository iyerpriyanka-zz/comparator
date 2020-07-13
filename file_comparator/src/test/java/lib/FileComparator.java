package lib;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import core.ApiProcessor;
import io.restassured.path.json.JsonPath;

import java.io.*;
import java.net.ConnectException;
import java.util.HashSet;
import java.util.Set;

public class FileComparator {

    ApiProcessor apiProcessor = new ApiProcessor();
    JsonComparator jsonCompare = new JsonComparator();

    public Boolean ApiFileComparator(String fileLocation1, String fileLocation2) throws IOException {

        File file1 = new File(fileLocation1);
        File file2 = new File(fileLocation2);
        BufferedReader file_reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader file_reader2 = new BufferedReader(new FileReader(file2));
        String url1,url2;
        JsonPath file1Response = null, file2Response = null;
        Set<Boolean> compareValueResult = new HashSet<>();
        while ((url1 = file_reader1.readLine()) != null && (url2 = file_reader2.readLine()) != null){
            try {
                file1Response = apiProcessor.getApiProcessor(url1);
                file2Response = apiProcessor.getApiProcessor(url2);
            }catch (Exception e){
                compareValueResult.add(Boolean.FALSE);
                System.out.println("Either " + url1 + "  or  " + url2 + "encountered an exception" + e.getMessage());
            }

            Boolean compareResult = jsonCompare.jsonComparator(file1Response,file2Response);
            if(compareResult){
                compareValueResult.add(Boolean.TRUE);
            }else{
                compareValueResult.add(Boolean.FALSE);
            }
            System.out.println(url1 + " " + compareResult + " " + url2);
        }
        if (compareValueResult.contains(Boolean.FALSE)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
