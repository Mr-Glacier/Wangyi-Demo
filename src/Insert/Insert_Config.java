package Insert;

import Anslysis.Analysis_Config_Html;
import Dao.Dao_Father;
import Entity.Bean_T_WangYiConfig;
import Until.ReadUntil;

import java.util.ArrayList;

public class Insert_Config {
    public static void main(String[] args) throws Exception {
        ReadUntil readUntil = new ReadUntil();
        Analysis_Config_Html AS_Config = new  Analysis_Config_Html();
        Dao_Father daoConfig = new Dao_Father(5);
        try{
            for (int i = 0; i < 4138; i++) {
                System.out.println("本次是第多少个文件 :" + i);
                String path = "F:/A_网易数据/Config页面/" + i + ".text";
                String Content = readUntil.Method_ReadFile(path);
                ArrayList<Bean_T_WangYiConfig> ConfigList = AS_Config.Method_Analysis_Config(Content);
                for (int j = 0; j < ConfigList.size(); j++) {
                    daoConfig.Method_Insert2(ConfigList.get(j));
                }
                System.out.println("完成一组插入");
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }


    }
}
