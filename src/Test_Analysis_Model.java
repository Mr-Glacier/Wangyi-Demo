import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class Test_Analysis_Model {
    public static void main(String[] args) {
        try{
            String url = "https://product.auto.163.com/new_daquan/factory/1823.html";
            Document document = Jsoup.parse(new URL(url).openStream(), "GBK", url);
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
                System.out.println(ModelID);
                System.out.println(ModelName);
                System.out.println(ModelURL);

            }

        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}
