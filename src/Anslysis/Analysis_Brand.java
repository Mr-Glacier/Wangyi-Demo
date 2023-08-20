package Anslysis;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiBrand;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.net.URL;
import java.util.ArrayList;

public class Analysis_Brand {
    public ArrayList<Bean_T_WangYiBrand> Method_Analysis_Brand(){
        ArrayList<Bean_T_WangYiBrand> BrandList = new ArrayList<>();
        try{
            Dao_Father BrandDao = new Dao_Father(0);
            String WangYiURL = "https://product.auto.163.com/";
            Document document = Jsoup.parse(new URL(WangYiURL).openStream(),"GBK", WangYiURL);
            //System.out.println(document);
            Elements Items1 = document.select(".brand_cont");
            Elements Items2 = Items1.select(".brand_name");
            System.out.println(Items2.size());
            //223品牌名字
            for (int i = 0; i < Items2.size(); i++) {
                Elements Items3 = Items2.get(i).select(".brand_title");
                String BrandName = Items3.select("a").attr("title");
                String BrandID = Items3.select("a").attr("id");
                String BrandURL = "https://product.auto.163.com"+Items3.select("a").attr("href");

                //https://product.auto.163.com/new_daquan/brand/20256.html
//                System.out.println("品牌ID :"+BrandID);
//                System.out.println("品牌名称 :"+BrandName);
//                System.out.println("品牌URL :"+BrandURL);
                Bean_T_WangYiBrand bean_t_wangYiBrand = new Bean_T_WangYiBrand();
                bean_t_wangYiBrand.setC_BrandID(BrandID);
                bean_t_wangYiBrand.setC_BrandName(BrandName);
                bean_t_wangYiBrand.setC_BrandURL(BrandURL);
                BrandDao.Method_Insert(bean_t_wangYiBrand);
                BrandList.add(bean_t_wangYiBrand);

            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return BrandList;
    }
}
