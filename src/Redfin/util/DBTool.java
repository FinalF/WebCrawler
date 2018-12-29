package Redfin.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBTool {
    private static boolean initialized = false;
    private static Set<String> entries = new HashSet<>();

    public static void writeToFile(String path, List<String> list) throws IOException {
        System.out.println("Updating list: " + list.get(list.size() - 1));


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.now();
        path = path + dtf.format(localDate) + ".csv";
        System.out.println("file path: " + path);
        FileWriter writer = new FileWriter(path, true);
        if (!initialized) {
            initialized = true;
            System.out.println(path + " -> created");
            writer.append("Price,Bed,Bath,Sqrt,Year,Address,Community,County,url");
            writer.append('\n');

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            //System.out.println(data);
            sb.append(list.get(i));
            sb.append(",");
        }
        if (entries.contains(sb.toString())) {
            return;
        }else{
            entries.add(sb.toString());
        }
        for (int i = 5; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(",");
        }
        writer.append(sb.toString());
        writer.append('\n');
        writer.flush();
        writer.close();
        System.out.println("List updated: " + list.get(list.size() - 1));
    }
}
