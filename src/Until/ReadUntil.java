package Until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadUntil {
    public String Method_ReadFile(String path) {
        String Content = "";
        try {
            //System.out.println(path);
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer SB = new StringBuffer();
            String text = "";
            while ((text = br.readLine()) != null) {
                SB.append(text);
            }
            br.close();
            Content = SB.toString();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return Content;
    }
}
