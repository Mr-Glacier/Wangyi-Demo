import Dao.Dao_Father;
import Entity.Bean_T_WangYiVersion;

import java.io.IOException;
import java.util.ArrayList;

public class Test4 {
    public static void main(String[] args) throws IOException {
        Dao_Father dao_father = new Dao_Father(3);
        String VersionID = "0000GaCC";
//        String sql = "select * From T_WangYi_Version Where C_VersionID= '"+VersionID+"'";
           ArrayList<Object> VersionList =  dao_father.Method_Find2(VersionID);
        for (int i = 0; i < VersionList.size(); i++) {
            String VersionName = ((Bean_T_WangYiVersion)VersionList.get(i)).getC_VersionName();
            System.out.println(VersionName);

        }
    }
}
