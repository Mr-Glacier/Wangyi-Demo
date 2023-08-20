package Anslysis;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class Analysis_Factory {
    public ArrayList<Bean_T_WangYiFactory> Method_Analysis_Factory(String BrandURL, String BrandID) {
        ArrayList<Bean_T_WangYiFactory> FactoryList = new ArrayList<>();
        try {

            Dao_Father FactoryDao = new Dao_Father(1);
            Document document = Jsoup.parse(new URL(BrandURL).openStream(), "GBK", BrandURL);

            Element Items1 = document.getElementById(BrandID);
            Elements Items2 = Items1.select(".carList");
            //System.out.println(Items2.size());

            Elements Items3 = Items2.select(".chexi_name");
           // System.out.println("这是多少个厂商" + Items3.size());
            for (int i = 0; i < Items3.size(); i++) {
                Elements Items4 = Items3.get(i).select("a");
                String factoryURL = "https://product.auto.163.com" + Items4.attr("href");
                String factoryId = Items4.attr("id");
                String factoryName = Items4.attr("title");
//                System.out.println(factoryName);
//                System.out.println(factoryId);
//                System.out.println(factoryURL);
                Bean_T_WangYiFactory bean_t_wangYiFactory = new Bean_T_WangYiFactory();
                bean_t_wangYiFactory.setC_FactoryID(factoryId);
                bean_t_wangYiFactory.setC_FactoryName(factoryName);
                bean_t_wangYiFactory.setC_FactoryURL(factoryURL);
                bean_t_wangYiFactory.setC_BrandID(BrandID);
                FactoryDao.Method_Insert(bean_t_wangYiFactory);
                FactoryList.add(bean_t_wangYiFactory);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return FactoryList;
    }
}
