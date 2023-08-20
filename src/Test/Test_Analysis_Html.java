package Test;

import Until.ReadUntil;
import Until.SaveUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test_Analysis_Html {
    public static void main(String[] args) {
////        String Content = "";
////        Document document = Jsoup.parse(Content);
//       // Elements Items1 = document.select(".car_config_param_head").select(".row_placeholder");
//        Elements Items2 = Items1.select(".row").select("cell");
//        for (int i = 0; i < Items2.size(); i++) {
//
//            String name = Items2.attr("data-config").toString();
//            System.out.println(name);
//
//            System.out.println("");
//            System.out.println("hhahahahahha");
//            //在for循环内进行插入并表明可以Value值
//            //在循环内进行这个事件
//            //正好罗列出来
//            //顺序不会错的
//            //
//            //
//
//
//        }
//        System.out.println();


        SaveUntil saveUntil = new SaveUntil();
        ReadUntil readUntil = new ReadUntil();
        for (int i = 0; i < 4138; i++) {

            String path = "F:/A_网易数据/Config页面/" + i + ".text";
            String Content = readUntil.Method_ReadFile(path);
            //System.out.println(Content);
            Document document = Jsoup.parse(Content);
            String titleOne = "";
            String titleTwo = "";
            String nameList = "";
            Elements Items1 = document.select(".car_config_param_names").get(0).children();
            //进入具体的页面列表进行取值

            Elements CarDateItems1 = document.select(".car_config_param_list").get(0).children();
            System.out.println(CarDateItems1.size());



            for (int j = 0; j < Items1.size(); j++) {
                //System.out.println(Items1.get(j));
                String tempSting = Items1.get(j).select("div").attr("class");
                //System.out.println(tempSting);
                if (tempSting.indexOf("row_head") > -1) {
                    //System.out.println("拿到一级标题了");
                    titleOne = Items1.get(j).select(".row_head").select(".cell_text").text();
                    //System.out.println(titleOne);
                } else {
                    //System.out.println("拿到二级标题了");
                    titleTwo = Items1.get(j).select(".row").select(".cell_text").attr("title");
                    //System.out.println(titleTwo);
                    if (!titleTwo.equals("")) {
                        String Finallname = titleOne + "_" + titleTwo + "#";
                        //System.out.println(Finallname);
                        nameList += Finallname;
                    }
                    //System.out.println("跳出第一次循环");
                }
                //System.out.println(nameList);
            }
            System.out.println(nameList);
            //saveUntil.Method_SaveFile("F:/A_网易数据/ConfigTitle.text", nameList);
            System.out.println("完成一个文件的存储");
        }






    }
}
