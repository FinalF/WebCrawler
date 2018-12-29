package Redfin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetConfig {

    public static boolean loadConfig() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/flame/JAVA/WebCrawler/src/Redfin/configurations/criteria.csv"));
            String line = null;
            Map<String, String> map = new HashMap<String, String>();

            while ((line = br.readLine()) != null) {
                //String str[] = line.split(",");
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
