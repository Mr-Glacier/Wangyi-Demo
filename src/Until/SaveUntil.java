package Until;

import java.io.*;

public class SaveUntil {
    public void Method_SaveFile(String path,String Content) {
        try{
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path,true),331074 );//165537
            bufferedOutputStream.write(Content.getBytes());
            //OutputStream.close();
            //Thread.sleep(2000);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }


    public void Method_BufferWriter(String path,String Content) throws IOException {
        File file = new File(path);
        BufferedWriter BW = new BufferedWriter(new FileWriter(file));
        BW.write(Content);
//        String text = "";
//        while ((text = br.readLine()) != null) {
//            SB.append(text);
//        }
        BW.flush();
        BW.close();
    }
}
