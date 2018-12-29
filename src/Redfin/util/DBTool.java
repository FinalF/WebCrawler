package Redfin.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DBTool {

    public static void writeToFile(String path, List<String> list) throws IOException {
        System.out.println("Updating list: " + list.get(list.size()-1));
        FileWriter writer = new FileWriter(path);
        for(String data : list){
            writer.append(data);
            writer.append(",");
        }
        writer.append('\n');
        writer.flush();
        writer.close();
        System.out.println("List updated: " + list.get(list.size()-1));
    }
}
