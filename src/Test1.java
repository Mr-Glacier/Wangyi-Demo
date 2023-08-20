import Anslysis.Analysis_Brand;
import Anslysis.Analysis_Factory;
import Anslysis.Analysis_Model;
import Entity.Bean_T_WangYiBrand;
import Entity.Bean_T_WangYiFactory;
import Entity.Bean_T_WangYiModel;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        Analysis_Brand AS_Brand = new Analysis_Brand();
        Analysis_Factory AS_Factory = new Analysis_Factory();
        Analysis_Model AS_Model = new Analysis_Model();
        ArrayList<Bean_T_WangYiBrand> BrandList = AS_Brand.Method_Analysis_Brand();
        for (int i = 0; i < BrandList.size(); i++) {
            String BrandURL = BrandList.get(i).getC_BrandURL();
            String BrandID = BrandList.get(i).getC_BrandID();
            //System.out.println(BrandURL);

            ArrayList<Bean_T_WangYiFactory> FactoryList = AS_Factory.Method_Analysis_Factory(BrandURL, BrandID);
            for (int j = 0; j < FactoryList.size(); j++) {
                String factoryID = FactoryList.get(j).getC_FactoryID();
                String factoryName = FactoryList.get(j).getC_FactoryName();
                String factoryURL = FactoryList.get(j).getC_FactoryURL();
                String brandID = FactoryList.get(j).getC_BrandID();
//                System.out.println(brandID);
//                System.out.println(factoryID);
//                System.out.println(factoryName);
//                System.out.println(factoryURL);
                System.out.println("++++++++++++++++++++++++++++");

                ArrayList<Bean_T_WangYiModel> ModelList = AS_Model.Method_Analysis_Model(factoryURL, factoryID);
                for (int k = 0; k < ModelList.size(); k++) {
                    String ModelID = ModelList.get(k).getC_ModelID();
                    String ModelName = ModelList.get(k).getC_ModelName();
                    String ModelURL = ModelList.get(k).getC_ModelURL();
                    System.out.println(ModelID+"\n"+ModelName+"\n"+ModelURL);
                }
            }
        }
    }
}
