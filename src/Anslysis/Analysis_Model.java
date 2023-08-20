package Anslysis;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class Analysis_Model {
    public ArrayList<Bean_T_WangYiModel> Method_Analysis_Model(String factoryURL,String factoryID){
        ArrayList<Bean_T_WangYiModel> ModelList = new ArrayList<>();
        try{
            Dao_Father ModelDao = new Dao_Father(2);

            Document document = Jsoup.parse(new URL(factoryURL).openStream(), "GBK", factoryURL);
            Elements Items1 = document.select(".item-cont.cur");
            System.out.println(Items1.size());
            Elements Items2 = Items1.select(".product-list.clearfix");
            System.out.println(Items2.size());
            Elements Items3 = Items2.select("li");
            System.out.println(Items3.size());
            for (int i = 0; i < Items3.size(); i++) {
                Elements Items4 = Items3.get(i).select(".title").select("a");
                String ModelName= Items4.text();
                String ModelID = Items4.attr("data-series-id");
                //https://product.auto.163.com/series/20354.html#new18list
                String ModelURL = "https://product.auto.163.com"+Items4.attr("href");
//                System.out.println(ModelID);
//                System.out.println(ModelName);
//                System.out.println(ModelURL);
                Bean_T_WangYiModel bean_t_wangYiModel = new Bean_T_WangYiModel();
                bean_t_wangYiModel.setC_ModelID(ModelID);
                bean_t_wangYiModel.setC_ModelName(ModelName);
                bean_t_wangYiModel.setC_ModelURL(ModelURL);
                bean_t_wangYiModel.setC_FactoryID(factoryID);
                ModelDao.Method_Insert(bean_t_wangYiModel);
                ModelList.add(bean_t_wangYiModel);
            }

        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return ModelList;
    }
}
