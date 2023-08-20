import Until.ReadUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

public class Test_Analysis_Version {
    public static void main(String[] args) {
        try{
            String Path = "F:/A_网易数据/Model页面/17149.text";
            ReadUntil readUntil = new ReadUntil();
            String text =  readUntil.Method_ReadFile(Path);
//            String ModelURL = "https://product.auto.163.com/series/1959.html#new18list";
//            Document document = Jsoup.parse(new URL(ModelURL).openStream(), "GBK", ModelURL);
            Document document = Jsoup.parse(text);
            Elements Items1 = document.select(".tab_content");
            System.out.println(Items1.size());
            Elements Items2A = Items1.select(".table_car_sells");
            Elements Items2B = Items1.select(".table_car_sells.hidden");
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
                System.out.println(VersionID);
                System.out.println(VersionName);
                System.out.println(VersionURL);
            }
            //第二个循环是停产
            for (int i = 0; i < Items3B.size(); i++) {
                Elements Items4 = Items3B.get(i).select(".cell.cell_1").select("a");
                String VersionName = Items4.text();
                String VersionURL = "https://product.auto.163.com"+Items4.attr("href");
                String VersionID = VersionURL.replace("https://product.auto.163.com/product/", "").replace(".html#ncx00020", "");
                System.out.println(VersionID);
                System.out.println(VersionName);
                System.out.println(VersionURL);
            }
            System.out.println(Items3A.size());

//            System.out.println(Items2B.size());
//            Elements Items3A = Items2B.select(".row_data");
//
//            for (int i = 0; i < Items3A.size(); i++) {
//                Elements Items4 = Items3A.get(i).select(".cell.cell_1").select("a");
//                String VersionName = Items4.text();
//                String VersionURL = Items4.attr("href");
//                System.out.println(VersionName);
//                System.out.println(VersionURL);
//            }
//
//
//            //2009款 2.0 TFSI 自动标准型
//            //2018款 TFSI 典藏型
//            Elements Items3B = Items2B.select(".row_data");
//            for (int i = 0; i < Items3B.size(); i++) {
//                Elements Items4 = Items3A.get(i).select(".cell.cell_1").select("a");
//                String VersionName = Items4.text();
//                String VersionURL = Items4.attr("href");
//                System.out.println(VersionName);
//                System.out.println(VersionURL);
//            }
//            //System.out.println(Items3A.size());
//            System.out.println(Items3B.size());

        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
