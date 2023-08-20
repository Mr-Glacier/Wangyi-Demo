package Insert;

import Anslysis.Analysis_Version;
import Dao.Dao_Father;
import Entity.Bean_T_WangYiDate;
import Entity.Bean_T_WangYiModel;
import Until.ReadUntil;

import java.util.ArrayList;

public class Insert_Version {
    public static void main(String[] args) {
        try {
            ReadUntil readUntil = new ReadUntil();
            Dao_Father ModelDao = new Dao_Father(4);
            Analysis_Version AS_Version = new Analysis_Version();
            ArrayList<Object> DateList = ModelDao.Method_Find();
            for (int i = 0; i < DateList.size(); i++) {
                String ModelID = ((Bean_T_WangYiDate) DateList.get(i)).getC_ModelID();
                String path = "F:/A_网易数据/Model页面/" + ModelID + ".text";
                String content = readUntil.Method_ReadFile(path);
                AS_Version.Method_Analysis_Version(content, ModelID);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
