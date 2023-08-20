import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class demo {

    public static void main(String[] args) {
         String str = "{\n" +
                 "        \"trim_info\":{\n" +
                 "            \"trim_id\":148237,\n" +
                 "            \"model_id\":4207,\n" +
                 "            \"trim_name_zh\":\"35 TFSI 时尚型 国VI\",\n" +
                 "            \"model_name_zh\":\"A3 Sportback\",\n" +
                 "            \"year\":2020,\n" +
                 "            \"date_launch\":\"2019-10\",\n" +
                 "            \"price_guide\":21.37,\n" +
                 "            \"price_subsidy\":null,\n" +
                 "            \"price_presale\":null,\n" +
                 "            \"url_logo\":\"http://m3.auto.itc.cn/c_fill,w_600,h_400/29535446.JPG\",\n" +
                 "            \"flag_place\":0,\n" +
                 "            \"flag_status_product\":-1,\n" +
                 "            \"time_listed\":\"2019-10-15T16:08:43.000+08:00\",\n" +
                 "            \"car_body\":0,\n" +
                 "            \"car_body_code\":1,\n" +
                 "            \"model_type\":3,\n" +
                 "            \"new_energy\":2,\n" +
                 "            \"brand_id\":191,\n" +
                 "            \"brand_name_zh\":\"奥迪\",\n" +
                 "            \"loc_min_price\":null,\n" +
                 "            \"sur_min_price\":null,\n" +
                 "            \"image_count\":null\n" +
                 "        }}";

        System.out.println(str);
//        JSONObject json_obj = JSONObject.parseObject(str);
        JSONObject js = JSON.parseObject(str);
       // JSONObject obj= JSON.parseObject(Json);
//        String name = Null2String(js.get("name"));
//        String pass = Null2String(obj.get("pass"));
        System.out.println(js);
        Object object = js.get("sur_min_price");
        if (object == null){
            System.out.println(1121);
        }
        //使用get方法去获取.
//        System.out.println("jjjb");
//        System.out.println(name + pass)

    }
}
