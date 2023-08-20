package Down;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiDate;
import Until.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Down_Version_HTML {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dao_Father VersionHTML_Dao =new Dao_Father(4);
        SaveUntil saveUntil = new SaveUntil();
        ArrayList<Object> DateList =  VersionHTML_Dao.Method_Find();
//      SaveUntil saveUntil = new SaveUntil();
        for (int i = 0; i < DateList.size(); i++) {
            String ModelURL = ((Bean_T_WangYiDate) DateList.get(i)).getC_ModelURL();
            String ModelID = ((Bean_T_WangYiDate) DateList.get(i)).getC_ModelID();
            String State = ((Bean_T_WangYiDate) DateList.get(i)).getC_DownState();
            System.out.println(ModelID);
            System.out.println(ModelURL);
            String Path = "F:/A_网易数据/Model页面/"+ModelID+".text";
//            ReadUntil readUntil = new ReadUntil();
//           String text =  readUntil.Method_ReadFile(Path);
//            System.out.println(text);
            //Thread.sleep(5000);
            if (State.equals("是")){
                System.out.println("文件已经下载");
            }else {
                Document document = Jsoup.parse(new URL(ModelURL).openStream(), "GBK", ModelURL);
                saveUntil.Method_SaveFile(Path,document.toString());
                String sql ="Update T_WangYi_Date set C_DownState = '是' where C_ModelID = '" + ModelID + "'";
                VersionHTML_Dao.Method_Update(sql);
            }
        }
       // System.out.println(DateList.size());
    }
}
