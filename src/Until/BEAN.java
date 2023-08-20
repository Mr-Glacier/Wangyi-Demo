package Until;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BEAN {
    private String trim_id;
    private String         model_id;
    private String trim_name_zh;
    private String         model_name_zh;
    private String year;
    private String         date_launch;
    private String price_guide;
    private String         price_subsidy;
    private String price_presale;
    private String         url_logo;
    private String flag_place;
    private String         flag_status_product;
    private String time_listed;
    private String         car_body;
    private String car_body_code;
    private String         model_type;
    private String new_energy;
    private String         brand_id;
    private String brand_name_zh;
    private String         loc_min_price;
    private String sur_min_price;
    private String         image_count;


    public static void  main(String[] args){
        String Json = "{\"name\": null, \"pass\":\"123\"}";
        JSONObject obj= JSON.parseObject(Json);
        String name = Null2String(obj.get("name"));
        String pass = Null2String(obj.get("pass"));
        System.out.println(name + pass);
    }
    public static String Null2String(Object o){
        return null == o? "None" : o.toString();
    }
}

