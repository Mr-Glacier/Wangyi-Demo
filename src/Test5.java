import Until.ReadUntil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.sg.prism.NGNode;

import java.util.Objects;
import java.util.SortedMap;

public class Test5 {
    public static void main(String[] args) {
        try{

            ReadUntil readUntil = new ReadUntil();
          String Content = readUntil.Method_ReadFile("F:/A_网易数据/json_3_Config.text");
            JSONArray jsonArray = JSONArray.parseArray(Content);
            System.out.println(jsonArray.size());
            JSONObject jsonObject = jsonArray.getJSONObject(9);
            System.out.println(jsonObject.size());
            JSONObject jsonObject1 = jsonObject.getJSONObject("trim_info");

            JSONArray jsonArray1 = jsonObject1.getJSONArray("config");
            String value;
            for (int i = 0; i < jsonArray1.size(); i++) {
                JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                String  a = jsonObject2.getString("value");
                if (a == "null"){
                    System.out.println(1);
                }






                //JSONObject t = (JSONObject) jsonObject2.get("value");

//                if (t.size() == 0){
//                    System.out.println(111);
//                }
//                if (value == null){
//                    System.out.println("无数据");
//                }else {
//                    System.out.println(value);
//                }
            }

            //String aa = jsonObject1.getString("price_subsidy");



        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
