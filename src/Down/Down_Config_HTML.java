package Down;

import Dao.Dao_Father;
import Dao.Dao_FindGroup;
import Entity.Bean_T_WangYiVersion;
import Until.SaveUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Down_Config_HTML {
    public static void main(String[] args) {
        try{
            Dao_Father VersionDao = new Dao_Father(3);
            Dao_FindGroup GroupDao = new Dao_FindGroup();
            SaveUntil saveUntil = new SaveUntil();
            for (int i = 0; i < 4138; i++) {
                String versionIDList ="";
                String versonID ="";
                ArrayList<Bean_T_WangYiVersion> beanList = GroupDao.Methoy_FindGroup("T_WangYi_Version", String.valueOf(i));
                for (int j = 0; j < beanList.size(); j++) {
                    versonID = beanList.get(j).getC_VersionID();
                    versionIDList +=versonID+",";
                }
                versionIDList = versionIDList.substring(0, versionIDList.length() - 1);
                String V_url = "https://product.auto.163.com/config_compare/"+versionIDList+".html";
//                System.out.println(versionIDList);
                System.out.println(V_url);
                String DownState = beanList.get(0).getC_DownState();
                if (DownState.equals("是")){
                    System.out.println("文件已经下载");
                }else {
                    Document Content = Jsoup.parse(new URL(V_url).openStream(),"GBK",V_url);
                    //1Thread.sleep(2000);
                    saveUntil.Method_SaveFile("F:/A_网易数据/Config页面/"+i+".text", Content.toString());
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //System.out.println(formatter.format(date));
                    String timeA = formatter.format(date).toString();
                    String sql = "Update T_WangYi_Version set C_DownState = '是',C_DownTime = '"+timeA+"' where C_Group = '" + i + "'";
                    VersionDao.Method_Update(sql);
                    System.out.println("完成一次下载");
                    System.out.println("++++++++++++++++++++++++++++++");
                   // Thread.sleep(3000);
                }
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
