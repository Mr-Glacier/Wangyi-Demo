package Anslysis;

import Entity.Bean_T_WangYiConfig;
import Until.Replace_Json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//传入参数为html页面,进行解析,返回本页面内所含有的车辆配置信息ArrayList
public class Analysis_Config_Html {
    public ArrayList<Bean_T_WangYiConfig> Method_Analysis_Config(String Content) throws NoSuchFieldException {
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("基本信息_厂商","C_基本信息_厂商");
        columnMap.put("基本信息_车身结构","C_基本信息_车身结构");
        columnMap.put("基本信息_长*宽*高(mm)","C_基本信息_长_宽_高_mm_");
        columnMap.put("基本信息_动力系统","C_基本信息_动力系统");
        columnMap.put("基本信息_变速箱","C_基本信息_变速箱");
        columnMap.put("基本信息_最高车速(Km/h)","C_基本信息_最高车速_Km_h_");
        columnMap.put("基本信息_官方0—100加速时间(s)","C_基本信息_官方0_100加速时间_s_");
        columnMap.put("基本信息_工信部综合油耗(L/100km)","C_基本信息_工信部综合油耗_L_100km_");
        columnMap.put("基本信息_整车保修期限","C_基本信息_整车保修期限");
        columnMap.put("基本信息_动力类型","C_基本信息_动力类型");
        columnMap.put("车身尺寸_车长(mm)","C_车身尺寸_车长_mm_");
        columnMap.put("车身尺寸_车宽(mm)","C_车身尺寸_车宽_mm_");
        columnMap.put("车身尺寸_车高(mm)","C_车身尺寸_车高_mm_");
        columnMap.put("车身尺寸_轴距(mm)","C_车身尺寸_轴距_mm_");
        columnMap.put("车身尺寸_前轮距(mm)","C_车身尺寸_前轮距_mm_");
        columnMap.put("车身尺寸_后轮距(mm)","C_车身尺寸_后轮距_mm_");
        columnMap.put("车身尺寸_最小离地间隙(mm)","C_车身尺寸_最小离地间隙_mm_");
        columnMap.put("车身尺寸_整备质量(Kg)","C_车身尺寸_整备质量_Kg_");
        columnMap.put("车身尺寸_车门数(个)","C_车身尺寸_车门数_个_");
        columnMap.put("车身尺寸_座位数(个)","C_车身尺寸_座位数_个_");
        columnMap.put("车身尺寸_油箱容积(L) ","C_车身尺寸_油箱容积_L_");
        columnMap.put("车身尺寸_行李舱容积(L) ","C_车身尺寸_行李舱容积_L_");
        columnMap.put("动力系统_发动机厂家型号","C_动力系统_发动机厂家型号");
        columnMap.put("动力系统_缸盖材料","C_动力系统_缸盖材料");
        columnMap.put("动力系统_缸体材料","C_动力系统_缸体材料");
        columnMap.put("动力系统_气缸排列形式","C_动力系统_气缸排列形式");
        columnMap.put("动力系统_气缸数(个)","C_动力系统_气缸数_个_");
        columnMap.put("动力系统_供油方式","C_动力系统_供油方式");
        columnMap.put("动力系统_进气形式","C_动力系统_进气形式");
        columnMap.put("动力系统_气缸容积(ml)","C_动力系统_气缸容积_ml_");
        columnMap.put("动力系统_排气量(L)","C_动力系统_排气量_L_");
        columnMap.put("动力系统_最大马力(Ps)","C_动力系统_最大马力_Ps_");
        columnMap.put("动力系统_最大功率(kW)","C_动力系统_最大功率_kW_");
        columnMap.put("动力系统_最大功率转速(rpm)","C_动力系统_最大功率转速_rpm_");
        columnMap.put("动力系统_最大扭矩(N·m)","C_动力系统_最大扭矩_N_m_");
        columnMap.put("动力系统_最大扭矩转速(rpm)","C_动力系统_最大扭矩转速_rpm_");
        columnMap.put("动力系统_燃料类型","C_动力系统_燃料类型");
        columnMap.put("动力系统_最高车速(Km/h)","C_动力系统_最高车速_Km_h_");
        columnMap.put("动力系统_官方0—100加速时间(s)","C_动力系统_官方0_100加速时间_s_");
        columnMap.put("动力系统_NEDC综合油耗(L/100km)","C_动力系统_NEDC综合油耗_L_100km_");
        columnMap.put("动力系统_WLTC综合油耗(L/100km)","C_动力系统_WLTC综合油耗_L_100km_");
        columnMap.put("动力系统_环保标准","C_动力系统_环保标准");
        columnMap.put("动力系统_挡位数","C_动力系统_挡位数");
        columnMap.put("动力系统_变速器形式","C_动力系统_变速器形式");
        columnMap.put("动力系统_四驱类型","C_动力系统_四驱类型");
        columnMap.put("动力系统_中央差速器结构","C_动力系统_中央差速器结构");
        columnMap.put("动力系统_中央差速器锁止功能","C_动力系统_中央差速器锁止功能");
        columnMap.put("动力系统_前桥差速器锁","C_动力系统_前桥差速器锁");
        columnMap.put("动力系统_后桥差速器锁","C_动力系统_后桥差速器锁");
        columnMap.put("新能源_电动机类型","C_新能源_电动机类型");
        columnMap.put("新能源_电动机总功率(Kw)","C_新能源_电动机总功率_Kw_");
        columnMap.put("新能源_电动机总扭矩(N·m)","C_新能源_电动机总扭矩_N_m_");
        columnMap.put("新能源_前电动机最大功率(Kw)","C_新能源_前电动机最大功率_Kw_");
        columnMap.put("新能源_前电动机最大扭矩(N·m)","C_新能源_前电动机最大扭矩_N_m_");
        columnMap.put("新能源_后电动机最大功率(Kw)","C_新能源_后电动机最大功率_Kw_");
        columnMap.put("新能源_后电动机最大扭矩(N·m)","C_新能源_后电动机最大扭矩_N_m_");
        columnMap.put("新能源_系统综合功率(Kw)","C_新能源_系统综合功率_Kw_");
        columnMap.put("新能源_系统综合扭矩(N·m)","C_新能源_系统综合扭矩_N_m_");
        columnMap.put("新能源_电池类型","C_新能源_电池类型");
        columnMap.put("新能源_NEDC纯电续航里程(km)","C_新能源_NEDC纯电续航里程_km_");
        columnMap.put("新能源_CLTC纯电续航里程(km)","C_新能源_CLTC纯电续航里程_km_");
        columnMap.put("新能源_WLTC纯电续航里程(km)","C_新能源_WLTC纯电续航里程_km_");
        columnMap.put("新能源_电池容量(kWh)","C_新能源_电池容量_kWh_");
        columnMap.put("新能源_百公里耗电量(kWh/100km)","C_新能源_百公里耗电量_kWh_100km_");
        columnMap.put("新能源_快充时间(h)","C_新能源_快充时间_h_");
        columnMap.put("新能源_慢充时间(h)","C_新能源_慢充时间_h_");
        columnMap.put("新能源_电池组质保","C_新能源_电池组质保");
        columnMap.put("底盘制动_车体结构","C_底盘制动_车体结构");
        columnMap.put("底盘制动_驱动方式","C_底盘制动_驱动方式");
        columnMap.put("底盘制动_前悬挂形式","C_底盘制动_前悬挂形式");
        columnMap.put("底盘制动_后悬挂形式","C_底盘制动_后悬挂形式");
        columnMap.put("底盘制动_前制动器类型","C_底盘制动_前制动器类型");
        columnMap.put("底盘制动_后制动器类型","C_底盘制动_后制动器类型");
        columnMap.put("底盘制动_助力转向类型","C_底盘制动_助力转向类型");
        columnMap.put("底盘制动_前轮胎规格","C_底盘制动_前轮胎规格");
        columnMap.put("底盘制动_后轮胎规格","C_底盘制动_后轮胎规格");
        columnMap.put("底盘制动_铝合金轮辋","C_底盘制动_铝合金轮辋");
        columnMap.put("底盘制动_备胎规格","C_底盘制动_备胎规格");
        columnMap.put("底盘制动_防爆轮胎","C_底盘制动_防爆轮胎");
        columnMap.put("安全操控_驾驶位安全气囊","C_安全操控_驾驶位安全气囊");
        columnMap.put("安全操控_副驾驶位安全气囊","C_安全操控_副驾驶位安全气囊");
        columnMap.put("安全操控_前排侧安全气囊","C_安全操控_前排侧安全气囊");
        columnMap.put("安全操控_后排侧安全气囊","C_安全操控_后排侧安全气囊");
        columnMap.put("安全操控_头部安全气帘","C_安全操控_头部安全气帘");
        columnMap.put("安全操控_膝部气囊","C_安全操控_膝部气囊");
        columnMap.put("安全操控_胎压监测系统","C_安全操控_胎压监测系统");
        columnMap.put("安全操控_ABS防抱死","C_安全操控_ABS防抱死");
        columnMap.put("安全操控_EBD制动力分配","C_安全操控_EBD制动力分配");
        columnMap.put("安全操控_刹车辅助(EBA/BA/BAS等)","C_安全操控_刹车辅助_EBA_BA_BAS等_");
        columnMap.put("安全操控_牵引力控制(TCS/ASR/TRC等)","C_安全操控_牵引力控制_TCS_ASR_TRC等_");
        columnMap.put("安全操控_车身稳定系统(ESP/VDC/VSC/DSC等)","C_安全操控_车身稳定系统_ESP_VDC_VSC_DSC等_");
        columnMap.put("安全操控_并线辅助","C_安全操控_并线辅助");
        columnMap.put("安全操控_车道偏离预警","C_安全操控_车道偏离预警");
        columnMap.put("安全操控_主动安全系统","C_安全操控_主动安全系统");
        columnMap.put("安全操控_前/后驻车雷达","C_安全操控_前_后驻车雷达");
        columnMap.put("安全操控_倒车影像","C_安全操控_倒车影像");
        columnMap.put("安全操控_车侧盲区影像","C_安全操控_车侧盲区影像");
        columnMap.put("安全操控_360度全景影像","C_安全操控_360度全景影像");
        columnMap.put("安全操控_定速巡航系统","C_安全操控_定速巡航系统");
        columnMap.put("安全操控_自适应巡航(ACC)","C_安全操控_自适应巡航_ACC_");
        columnMap.put("安全操控_自动泊车入位","C_安全操控_自动泊车入位");
        columnMap.put("安全操控_发动机自动启停系统","C_安全操控_发动机自动启停系统");
        columnMap.put("安全操控_驻车制动类型","C_安全操控_驻车制动类型");
        columnMap.put("安全操控_自动驻车(AUTOHOLD)","C_安全操控_自动驻车_AUTOHOLD_");
        columnMap.put("安全操控_上坡辅助(HAC)","C_安全操控_上坡辅助_HAC_");
        columnMap.put("安全操控_陡坡缓降(HDC)","C_安全操控_陡坡缓降_HDC_");
        columnMap.put("安全操控_可变悬挂","C_安全操控_可变悬挂");
        columnMap.put("安全操控_发动机电子防盗","C_安全操控_发动机电子防盗");
        columnMap.put("安全操控_车内中控锁","C_安全操控_车内中控锁");
        columnMap.put("安全操控_遥控钥匙","C_安全操控_遥控钥匙");
        columnMap.put("安全操控_无钥匙启动","C_安全操控_无钥匙启动");
        columnMap.put("安全操控_无钥匙进入","C_安全操控_无钥匙进入");
        columnMap.put("外部配置_天窗类型","C_外部配置_天窗类型");
        columnMap.put("外部配置_后雨刷","C_外部配置_后雨刷");
        columnMap.put("外部配置_感应后备箱","C_外部配置_感应后备箱");
        columnMap.put("外部配置_电动后备箱","C_外部配置_电动后备箱");
        columnMap.put("外部配置_行李架","C_外部配置_行李架");
        columnMap.put("外部配置_前照灯类型","C_外部配置_前照灯类型");
        columnMap.put("外部配置_前雾灯","C_外部配置_前雾灯");
        columnMap.put("外部配置_大灯高度调节","C_外部配置_大灯高度调节");
        columnMap.put("外部配置_大灯延时关闭","C_外部配置_大灯延时关闭");
        columnMap.put("外部配置_光感式自动大灯","C_外部配置_光感式自动大灯");
        columnMap.put("外部配置_日间行车灯","C_外部配置_日间行车灯");
        columnMap.put("外部配置_自适应远近光","C_外部配置_自适应远近光");
        columnMap.put("外部配置_大灯随动转向(AFS)","C_外部配置_大灯随动转向_AFS_");
        columnMap.put("外后视镜_前电动车窗","C_外后视镜_前电动车窗");
        columnMap.put("外后视镜_后电动车窗","C_外后视镜_后电动车窗");
        columnMap.put("外后视镜_车窗一键功能","C_外后视镜_车窗一键功能");
        columnMap.put("外后视镜_车窗防夹手功能","C_外后视镜_车窗防夹手功能");
        columnMap.put("外后视镜_外后视镜调节","C_外后视镜_外后视镜调节");
        columnMap.put("外后视镜_外后视镜加热","C_外后视镜_外后视镜加热");
        columnMap.put("外后视镜_外后视镜电动折叠","C_外后视镜_外后视镜电动折叠");
        columnMap.put("外后视镜_后视镜记忆","C_外后视镜_后视镜记忆");
        columnMap.put("外后视镜_内后视镜自动防炫目","C_外后视镜_内后视镜自动防炫目");
        columnMap.put("外后视镜_雨量感应式前雨刷","C_外后视镜_雨量感应式前雨刷");
        columnMap.put("内部配置_皮质方向盘","C_内部配置_皮质方向盘");
        columnMap.put("内部配置_方向盘调节","C_内部配置_方向盘调节");
        columnMap.put("内部配置_多功能方向盘","C_内部配置_多功能方向盘");
        columnMap.put("内部配置_方向盘换挡","C_内部配置_方向盘换挡");
        columnMap.put("内部配置_方向盘加热","C_内部配置_方向盘加热");
        columnMap.put("内部配置_方向盘记忆","C_内部配置_方向盘记忆");
        columnMap.put("内部配置_油耗显示","C_内部配置_油耗显示");
        columnMap.put("内部配置_车外温度显示","C_内部配置_车外温度显示");
        columnMap.put("内部配置_全液晶仪表盘","C_内部配置_全液晶仪表盘");
        columnMap.put("内部配置_液晶仪表尺寸","C_内部配置_液晶仪表尺寸");
        columnMap.put("内部配置_抬头显示系统(HUD)","C_内部配置_抬头显示系统_HUD_");
        columnMap.put("内部配置_夜视系统","C_内部配置_夜视系统");
        columnMap.put("空调配置_手动空调","C_空调配置_手动空调");
        columnMap.put("空调配置_自动空调","C_空调配置_自动空调");
        columnMap.put("空调配置_温度分区控制","C_空调配置_温度分区控制");
        columnMap.put("空调配置_后排空调出风口","C_空调配置_后排空调出风口");
        columnMap.put("空调配置_后排独立空调","C_空调配置_后排独立空调");
        columnMap.put("空调配置_车载空气净化器","C_空调配置_车载空气净化器");
        columnMap.put("座椅配置_皮质座椅","C_座椅配置_皮质座椅");
        columnMap.put("座椅配置_织物/皮双拼座椅","C_座椅配置_织物_皮双拼座椅");
        columnMap.put("座椅配置_驾驶位座椅调节","C_座椅配置_驾驶位座椅调节");
        columnMap.put("座椅配置_副驾驶位座椅调节","C_座椅配置_副驾驶位座椅调节");
        columnMap.put("座椅配置_座椅高低调节","C_座椅配置_座椅高低调节");
        columnMap.put("座椅配置_座椅腰部支撑调节","C_座椅配置_座椅腰部支撑调节");
        columnMap.put("座椅配置_尾排座椅放倒比例","C_座椅配置_尾排座椅放倒比例");
        columnMap.put("座椅配置_副驾驶座椅后排可调","C_座椅配置_副驾驶座椅后排可调");
        columnMap.put("座椅配置_第二排座椅调节","C_座椅配置_第二排座椅调节");
        columnMap.put("座椅配置_第三排座椅","C_座椅配置_第三排座椅");
        columnMap.put("座椅配置_儿童安全座椅接口(ISO FIX/LATCH)","C_座椅配置_儿童安全座椅接口_ISO_FIX_LATCH_");
        columnMap.put("座椅配置_电动座椅记忆","C_座椅配置_电动座椅记忆");
        columnMap.put("座椅配置_前排座椅加热","C_座椅配置_前排座椅加热");
        columnMap.put("座椅配置_第二排座椅加热","C_座椅配置_第二排座椅加热");
        columnMap.put("座椅配置_座椅通风","C_座椅配置_座椅通风");
        columnMap.put("座椅配置_座椅按摩","C_座椅配置_座椅按摩");
        columnMap.put("座椅配置_前座中央扶手","C_座椅配置_前座中央扶手");
        columnMap.put("座椅配置_后座中央扶手","C_座椅配置_后座中央扶手");
        columnMap.put("信息娱乐_CD","C_信息娱乐_CD");
        columnMap.put("信息娱乐_DVD","C_信息娱乐_DVD");
        columnMap.put("信息娱乐_外接音源接口(AUX/USB等)","C_信息娱乐_外接音源接口_AUX_USB等_");
        columnMap.put("信息娱乐_扬声器数量(个)","C_信息娱乐_扬声器数量_个_");
        columnMap.put("信息娱乐_音响品牌","C_信息娱乐_音响品牌");
        columnMap.put("信息娱乐_车载蓝牙","C_信息娱乐_车载蓝牙");
        columnMap.put("信息娱乐_GPS导航系统","C_信息娱乐_GPS导航系统");
        columnMap.put("信息娱乐_手机互联/映射","C_信息娱乐_手机互联_映射");
        columnMap.put("信息娱乐_道路救援呼叫","C_信息娱乐_道路救援呼叫");
        columnMap.put("信息娱乐_中控台彩色屏","C_信息娱乐_中控台彩色屏");
        columnMap.put("信息娱乐_中控屏幕尺寸","C_信息娱乐_中控屏幕尺寸");
        columnMap.put("信息娱乐_多媒体类特色配置","C_信息娱乐_多媒体类特色配置");
        columnMap.put("颜色信息_车身颜色","C_颜色信息_车身颜色");
        columnMap.put("颜色信息_内饰颜色","C_颜色信息_内饰颜色");
        columnMap.put("其他配置_选装包配置项","C_其他配置_选装包配置项");
        columnMap.put("其他配置_其他配置","C_其他配置_其他配置");
        columnMap.put("新能源_电动机总扭矩(N&ot;m)","C_新能源_电动机总扭矩_N_ot_m_");
        /*
        项目流程分为四步:
        1.获取标题TitleList
        2.获取页面内车辆个数,和VersionID建立beanList
        3.取值进行hashMap查找,
        4.插入数据库
         */
        ArrayList<Bean_T_WangYiConfig> ConfigList = new ArrayList<>();
        try{

        //传入读取文件的String内容,进行HTML解析
        Replace_Json replace_json = new Replace_Json();
        Document document = Jsoup.parse(Content);

        Elements CarItems1 = document.select(".car_config_param_head").select(".row_placeholder").select(".row");
        Elements CarItems2A = CarItems1.select(".cell");
        Elements CarItems2B = CarItems1.select(".cell.cell_empty");
        System.out.println(CarItems2A.size());
        System.out.println(CarItems2B.size());
        String product_id = "";
        String brand_id = "";
        String series_id = "";
        String series_name = "";
        String product_name = "";
        String price = "";

        for (int i = 0; i < CarItems2A.size() - CarItems2B.size(); i++) {

            //本循环,创建BeanList,存放车辆的基本数据.
            String jsonStr = CarItems2A.get(i).attr("data-config").replace("'", "");

            String result = replace_json.Method_ReplaceJSON(jsonStr);
            JSONObject jsonObject = JSON.parseObject(result);
            //System.out.println(jsonObject.size());
            product_id = jsonObject.getString("product_id");
            brand_id = jsonObject.getString("brand_id");
            series_id = jsonObject.getString("series_id");
            series_name = jsonObject.getString("series_name");
            product_name = jsonObject.getString("product_name");
            price = jsonObject.getString("price");
//            System.out.println(product_id + "   " + product_name);
//            System.out.println(series_id + "   " + series_name);
//            System.out.println(brand_id);
//            System.out.println(price);

            Bean_T_WangYiConfig bean_t_wangYiConfig = new Bean_T_WangYiConfig();
            bean_t_wangYiConfig.setC_VersionID(product_id);
            bean_t_wangYiConfig.setC_VersionName(product_name);
            bean_t_wangYiConfig.setC_ModelID(series_id);
            bean_t_wangYiConfig.setC_ModelName(series_name);
            bean_t_wangYiConfig.setC_Brand_ID(brand_id);
            bean_t_wangYiConfig.setC_Price(price);
            ConfigList.add(bean_t_wangYiConfig);
            //读配置再来一个循环
        }

        //进入titleName
        Elements TitleItems1 = document.select(".car_config_param_names").get(0).children();
        String titleOne = "";
        String titleTwo = "";
        //String nameList = "";
        System.out.println(TitleItems1.size());
        ArrayList<String> TitleList = new ArrayList<String>();
        for (int j = 0; j < TitleItems1.size(); j++) {
            //System.out.println(Items1.get(j));
            String tempSting = TitleItems1.get(j).select("div").attr("class");
            //System.out.println(tempSting);
            if (tempSting.indexOf("row_head") > -1) {
                //System.out.println("拿到一级标题了");
                titleOne = TitleItems1.get(j).select(".row_head").select(".cell_text").text();
                //System.out.println("TitleOne : "+titleOne);
            } else {
                //System.out.println("拿到二级标题了");
                titleTwo = TitleItems1.get(j).select(".row").select(".cell_text").attr("title");
                //System.out.println("TitleTwo : "+titleTwo);
                if (!titleTwo.equals("")) {
                    String Finallname = titleOne + "_" + titleTwo;
                    //System.out.println(Finallname);
                    TitleList.add(Finallname);
                }
                //System.out.println("跳出第一次循环");
            }
            //System.out.println(nameList);
        }

        
        System.out.println(TitleList.size());
        //进入解析配置的具体数据
        Elements ConfigDateItems1 = document.select(".car_config_param_list");
        System.out.println(ConfigDateItems1.size());
        Elements ConfigDateItems2 = ConfigDateItems1.select(".row");
        System.out.println(ConfigDateItems2.size());

        ArrayList<String> DateList = new ArrayList<>();
        for (int i = 0; i < ConfigDateItems2.size(); i++) {
            Elements ConfigDateItems3A = ConfigDateItems2.get(i).select(".cell");
            Elements ConfigDateItems3B = ConfigDateItems2.get(i).select(".cell.cell_empty");
//            System.out.println("A  "+ConfigDateItems3A.size());
//            System.out.println("B  "+ConfigDateItems3B.size());
            String titleName = TitleList.get(i);
           // System.out.println(titleName);

            for (int j = 0; j < ConfigDateItems3A.size()-ConfigDateItems3B.size(); j++) {
                //j是车辆个数
                Elements DateItems1 = ConfigDateItems3A.get(j).select(".cell_text");
                String date = DateItems1.text();
               // System.out.println(date);

                Class c = ConfigList.get(j).getClass();
                Field field = c.getDeclaredField(columnMap.get(titleName));
                field.setAccessible(true);
                field.set(ConfigList.get(j),date);
            }
           // System.out.println(ConfigDateItems3A.size()-ConfigDateItems3B.size());
        }
    }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return ConfigList;
    }
}
