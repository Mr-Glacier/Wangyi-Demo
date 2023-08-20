package Anslysis;

import Dao.Dao_Father;
import Entity.Bean_T_WangYiVersion;
import Until.SaveUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Analysis_Version {
    public ArrayList<Bean_T_WangYiVersion> Method_Analysis_Version(String Content,String ModelID) throws IOException {
        SaveUntil saveUntilERRO = new SaveUntil();
        ArrayList<Bean_T_WangYiVersion> VersionList = new ArrayList<>();
        Dao_Father Version_Dao = new Dao_Father(3);
        try{
            Document document = Jsoup.parse(Content);
            Elements Items1 = document.select(".area_series_sells.area");
            if (Items1.size() == 0){
                System.out.println("页面无内容");
                saveUntilERRO.Method_SaveFile("F:/A_网易数据/ERROR/Error1.text",ModelID+"\n");
            }else {
                Elements Items2 = Items1.select(".wrapper");
                String State = Items2.select(".area_title_bar").select("span").text();
                if(State.equals("停产车款")){
                    Elements Items1A = document.select(".tab_content");
                    System.out.println(Items1A.size());
                    Elements Items2A = Items1A.select(".table_car_sells");
                    Elements Items3 = Items2A.select(".row_data");
                    System.out.println(Items3.size());
                    for (int i = 0; i < Items3.size(); i++) {
                        Elements Items4 = Items3.get(i).select(".cell.cell_1").select("a");
                        String VersionName = Items4.text();
                        String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
                        String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
                        String produceState = "停产";
//                        System.out.println(VersionID);
//                        System.out.println(VersionName);
//                        System.out.println(VersionURL);
//                        System.out.println(produceState);
                        Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
                        bean_t_wangYiVersion.setC_VersionID(VersionID);
                        bean_t_wangYiVersion.setC_VersionName(VersionName);
                        bean_t_wangYiVersion.setC_VersionURL(VersionURL);
                        bean_t_wangYiVersion.setC_ProduceState(produceState);
                        bean_t_wangYiVersion.setC_ModelID(ModelID);
                        VersionList.add(bean_t_wangYiVersion);
                        //Version_Dao.Method_Insert(bean_t_wangYiVersion);
                    }

                }else {
                    Elements Items1A = document.select(".tab_content");
                    System.out.println(Items1A.size());
                    Elements Items2A = Items1A.select(".table_car_sells");
                    Elements Items2B = Items1A.select(".table_car_sells.hidden");
                    Elements Items3A = Items2A.select(".row_data");
                    Elements Items3B = Items2B.select(".row_data");
                    System.out.println(Items2A.size());
                    System.out.println(Items2B.size());
                    //https://product.auto.163.com/product/000CPfSI.html#ncx00020
                    //第一个循环是在产
                    for (int i = 0; i < (Items3A.size()-Items3B.size()); i++) {
                        Elements Items4 = Items3A.get(i).select(".cell.cell_1").select("a");
                        String VersionName = Items4.text();
                        String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
                        String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
                        String produceState = "在产";
                        System.out.println(VersionID);
                        System.out.println(VersionName);
                        System.out.println(VersionURL);
                        Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
                        bean_t_wangYiVersion.setC_VersionID(VersionID);
                        bean_t_wangYiVersion.setC_VersionName(VersionName);
                        bean_t_wangYiVersion.setC_VersionURL(VersionURL);
                        bean_t_wangYiVersion.setC_ProduceState(produceState);
                        bean_t_wangYiVersion.setC_ModelID(ModelID);
                        VersionList.add(bean_t_wangYiVersion);
                        //Version_Dao.Method_Insert(bean_t_wangYiVersion);
                    }
                    //第二个循环是停产
                    for (int i = 0; i < Items3B.size(); i++) {
                        Elements Items4 = Items3B.get(i).select(".cell.cell_1").select("a");
                        String VersionName = Items4.text();
                        String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
                        String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
                        String produceState = "停产";
                        System.out.println(VersionID);
                        System.out.println(VersionName);
                        System.out.println(VersionURL);
                        Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
                        bean_t_wangYiVersion.setC_VersionID(VersionID);
                        bean_t_wangYiVersion.setC_VersionName(VersionName);
                        bean_t_wangYiVersion.setC_VersionURL(VersionURL);
                        bean_t_wangYiVersion.setC_ProduceState(produceState);
                        bean_t_wangYiVersion.setC_ModelID(ModelID);
                        VersionList.add(bean_t_wangYiVersion);
                        //Version_Dao.Method_Insert(bean_t_wangYiVersion);
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
//        try{
//            Document document = Jsoup.parse(Content);
//            Elements Items1 = document.select(".tab_content");
//            System.out.println(Items1.size());
//            Elements Items2A = Items1.select(".table_car_sells");
//            Elements Items2B = Items1.select(".table_car_sells.hidden");
//            Elements Items3A = Items2A.select(".row_data");
//            Elements Items3B = Items2B.select(".row_data");
//            System.out.println(Items2A.size());
//            System.out.println(Items2B.size());
//            //https://product.auto.163.com/product/000CPfSI.html#ncx00020
//            //第一个循环是在产
//            for (int i = 0; i < (Items3A.size()-Items3B.size()); i++) {
//                Elements Items4 = Items3A.get(i).select(".cell.cell_1").select("a");
//                String VersionName = Items4.text();
//                String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
//                String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
//                String produceState = "在产";
//                System.out.println(VersionID);
//                System.out.println(VersionName);
//                System.out.println(VersionURL);
//                Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
//                bean_t_wangYiVersion.setC_VersionID(VersionID);
//                bean_t_wangYiVersion.setC_VersionName(VersionName);
//                bean_t_wangYiVersion.setC_VersionURL(VersionURL);
//                bean_t_wangYiVersion.setC_ProduceState(produceState);
//                bean_t_wangYiVersion.setC_ModelID(ModelID);
//                VersionList.add(bean_t_wangYiVersion);
//                Version_Dao.Method_Insert(bean_t_wangYiVersion);
//            }
//            //第二个循环是停产
//            for (int i = 0; i < Items3B.size(); i++) {
//                Elements Items4 = Items3B.get(i).select(".cell.cell_1").select("a");
//                String VersionName = Items4.text();
//                String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
//                String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
//                String produceState = "停产";
//                System.out.println(VersionID);
//                System.out.println(VersionName);
//                System.out.println(VersionURL);
//                Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
//                bean_t_wangYiVersion.setC_VersionID(VersionID);
//                bean_t_wangYiVersion.setC_VersionName(VersionName);
//                bean_t_wangYiVersion.setC_VersionURL(VersionURL);
//                bean_t_wangYiVersion.setC_ProduceState(produceState);
//                bean_t_wangYiVersion.setC_ModelID(ModelID);
//                VersionList.add(bean_t_wangYiVersion);
//                Version_Dao.Method_Insert(bean_t_wangYiVersion);
//            }
//            //System.out.println(Items3A.size());
//        }catch (Exception ex){
//            System.out.println(ex.toString());
//        }
        return VersionList;
    }
}
