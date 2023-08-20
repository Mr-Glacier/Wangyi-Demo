package Down;

import Until.ReadUntil;
import Until.SaveUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test_Html_ConfigTitle {
    public static void main(String[] args) {
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
                        if (Finallname.equals("新能源_电动机总扭矩(N&ot;m)#")){
                            System.out.println("在这里!!!   : "+path);
                        }
                    }
                    //System.out.println("跳出第一次循环");
                }
                //System.out.println(nameList);
            }
            //System.out.println(nameList);
            //saveUntil.Method_SaveFile("F:/A_网易数据/ConfigTitle.text", nameList);
            //System.out.println("完成一个文件的存储");
        }
    }
}
