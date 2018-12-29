package Redfin.util;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetConfig {

    public static Map<String, Double> loadConfig() {

        BufferedReader br = null;
        Map<String, Double> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("/Users/flame/JAVA/WebCrawler/src/Redfin/configurations/criteria.csv"));
            String line = null;


            while ((line = br.readLine()) != null) {
                String str[] = line.split(",");
                map.put(str[0], Double.parseDouble(str[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

}
