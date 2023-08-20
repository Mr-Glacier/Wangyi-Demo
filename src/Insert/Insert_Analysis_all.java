package Insert;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

public class Insert_Analysis_all {
    public static void main(String[] args) {
        try {
            Dao_Father dao_father = new Dao_Father(4);
            String URL = "https://product.auto.163.com/new_daquan/factory/20257.html";
            Document document = Jsoup.parse(new URL(URL).openStream(), "GBK", URL);
            Elements Items1 = document.select(".brand_cont");
            System.out.println(Items1.size());
            Elements Items2 = Items1.select(".brand_name");
            System.out.println(Items2.size());

            for (int i = 0; i < Items2.size(); i++) {
                Elements Items3A = Items2.get(i).select("h2").select("a");
                String BrandID = Items3A.attr("id");
                String BrandURL = "https://product.auto.163.com" + Items3A.attr("href");
                String BrandName = Items3A.attr("title");
//                System.out.println(BrandID);
//                System.out.println(BrandName);
//                System.out.println(BrandURL);

                Elements Items3B = Items2.get(i).select(".carList");
                Elements Items4 = Items3B.select(".chexi_name");
                for (int j = 0; j < Items4.size(); j++) {
                    Elements Items5A = Items4.get(j).select("h2").select("a");
                    String FactoryID = Items5A.attr("id");
                    String FactoryName = Items5A.attr("title");
                    String FcatoryURL = "https://product.auto.163.com" + Items5A.attr("href");
//                    System.out.println(FactoryID);
//                    System.out.println(FactoryName);
//                    System.out.println(FcatoryURL);


                    Elements Items5B = Items4.get(j).select(".chexi-list");
                    Elements Items6 = Items5B.select("li");
                    for (int k = 0; k < Items6.size(); k++) {
                        Elements Items7 = Items6.get(k).select("a");
                        String ModelID = Items7.attr("id");
                        String ModelName = Items7.attr("title");
                        String ModelURL = Items7.attr("href");
                        System.out.println(ModelID);
                        System.out.println(ModelName);
                        System.out.println(ModelURL);
                        Bean_T_WangYiDate bean_t_wangYiDate = new Bean_T_WangYiDate();
                        bean_t_wangYiDate.setC_BrandID(BrandID);
                        bean_t_wangYiDate.setC_BrandName(BrandName);
                        bean_t_wangYiDate.setC_BrandURL(BrandURL);
                        bean_t_wangYiDate.setC_FactoryID(FactoryID);
                        bean_t_wangYiDate.setC_FactoryName(FactoryName);
                        bean_t_wangYiDate.setC_FactoryURL(FcatoryURL);
                        bean_t_wangYiDate.setC_ModelID(ModelID);
                        bean_t_wangYiDate.setC_ModelName(ModelName);
                        bean_t_wangYiDate.setC_ModelURL(ModelURL);
                        //dao_father.Method_Insert(bean_t_wangYiDate);
                    }
                }
            }
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }
}
