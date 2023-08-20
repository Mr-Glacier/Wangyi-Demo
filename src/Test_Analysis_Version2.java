import Dao.Dao_Father;
import Entity.Bean_T_WangYiModel;
import Until.ReadUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Test_Analysis_Version2 {
    public static void main(String[] args) {
        try{
            Dao_Father ModelHTML_Dao =new Dao_Father(2);
            ArrayList<Object> ModelList =  ModelHTML_Dao.Method_Find();
//      SaveUntil saveUntil = new SaveUntil();
            for (int i = 0; i < ModelList.size(); i++) {
                String ModelURL = ((Bean_T_WangYiModel)ModelList.get(i)).getC_ModelURL();
                String ModelID = ((Bean_T_WangYiModel) ModelList.get(i)).getC_ModelID();
                System.out.println(ModelID);
                System.out.println(ModelURL);
                String Path = "F:/A_网易数据/Model页面/"+ModelID+".text";
                ReadUntil readUntil = new ReadUntil();
                String text = readUntil.Method_ReadFile(Path);
                //System.out.println(text);
                Document document = Jsoup.parse(text);
                System.out.println(document);
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
