package Dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class Dao_Father {
    private Connection conn = null;
    private Statement stmt = null;

    private String DirverName;
    private String URL;
    private String UserName;
    private String UserPass;

    private String PrimaryKey;
    private String PackageName;
    private String TableName;
    private String EntityName;

    public Dao_Father(int Chose) throws IOException {
        String JSONPath = "F:/Workplace/Wangyi-Demo/Config.json";
        File file = new File(JSONPath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer Jsonconent = new StringBuffer();
        String text = "";
        while ((text = reader.readLine()) != null) {
            Jsonconent.append(text);
        }
        reader.close();

        JSONObject jsonObject = JSONObject.parseObject(Jsonconent.toString());
        JSONArray jsonDBArry = jsonObject.getJSONArray("DBList");
        JSONObject DBObject = jsonDBArry.getJSONObject(Chose);
        this.DirverName = DBObject.getString("DBDriver");
        this.URL = DBObject.getString("DBConnectionURL");
        this.UserName = DBObject.getString("DBUserName");
        this.UserPass = DBObject.getString("DBUserPass");

        JSONArray jsonEntityArry = jsonObject.getJSONArray("EntityList");
        JSONObject EntityObject = jsonEntityArry.getJSONObject(Chose);
        this.TableName = EntityObject.getString("TableName");
        this.PrimaryKey = EntityObject.getString("EntityPrimaryKey");
        this.EntityName = EntityObject.getString("EntityName");
        this.PackageName = jsonObject.getString("EntityPackage") + EntityName;
    }

    public void Method_CreateObject() {
        try {
            Class.forName(DirverName);
            if (null == conn || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, UserName, UserPass);
            }
            if (null == stmt || stmt.isClosed()) {
                stmt = conn.createStatement();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void Method_I_U_D(String sql) {
        try {
            Method_CreateObject();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void Method_Insert(Object object) {
        try {
            Class I = object.getClass();
            Method[] methods = I.getDeclaredMethods();
            String columenList = "";
            String valueList = "";
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals("get" + PrimaryKey)) {
                    continue;
                }
                if (methods[i].getName().startsWith("get")) {
                    String columenName = methods[i].getName().replace("get", "");
                    columenList += columenName + ",";
                    String value = methods[i].invoke(object).toString();
                    if (methods[i].getReturnType() == String.class) {
                        valueList += "'" + value + "'" + ",";
                    } else {
                        valueList += value + ",";
                    }
                }
            }
            columenList = columenList.substring(0, columenList.length() - 1);
            valueList = valueList.substring(0, valueList.length() - 1);
            String sql = "Insert into " + this.TableName + "(" + columenList + ")values(" + valueList + ")";
            System.out.println(sql);
            Method_I_U_D(sql);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void Method_Insert2(Object object) {
        try {
            Class I = object.getClass();
            Method[] methods = I.getDeclaredMethods();
            String columenList = "";
            String valueList = "";
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals("get" + PrimaryKey)) {
                    continue;
                }
                if (methods[i].getName().startsWith("get")) {
                    String columenName = methods[i].getName().replace("get", "");
                    columenList += columenName + ",";
                    //String value = methods[i].invoke(object).toString();
                    String value = methods[i].invoke(object) == null ? "-" : methods[i].invoke(object).toString();
                    if (methods[i].getReturnType() == String.class) {
                        valueList += "'" + value + "'" + ",";
                    } else {
                        valueList += value + ",";
                    }
                }
            }
            columenList = columenList.substring(0, columenList.length() - 1);
            valueList = valueList.substring(0, valueList.length() - 1);
            String sql = "Insert into " + this.TableName + "(" + columenList + ")values(" + valueList + ")";
            System.out.println(sql);
            Method_I_U_D(sql);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public ArrayList<Object> Method_Find(){
        ArrayList<Object> results = new ArrayList<Object>();
        try{
            /*
            find方法较难理解,个人难点在于返回值上,查询语句并不难理解,但在后续编码中较为重要;
            在find方法中如果传入参数为Object,则使用Class F = obj.getClass()
            如果传入参数为packageName,则使用Class F = Class.forName("packageName")
             */
            String query ="SELECT*FROM "+this.TableName;
            Method_CreateObject();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){

                Class F = Class.forName(PackageName);
                //Class F = obj.getClass();
                //实例化
                Object Find = F.newInstance();
                //获取列名
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                //获取列数
                int lieNumber = resultSetMetaData.getColumnCount();
                //System.out.println(lieNumber);

                for (int i = 0; i < lieNumber; i++) {
                    //通过序号获取列名
                    String columnName = resultSetMetaData.getColumnName(i+1);
                    //获取值
                    Object columnValue = resultSet.getObject(i+1);
                    //根据列名获取属性.getDeclaredField,获取类中所有的声明字段
                    Field field = F.getDeclaredField(columnName);
                    //可以向私有属性中写值,将private变为public
                    field.setAccessible(true);
                    //写值
                    field.set(Find, columnValue);
                }
                results.add(Find);
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return results;
    }

    public ArrayList<Object> Method_Find2(String VersionID){
        ArrayList<Object> results = new ArrayList<Object>();
        try{
            /*
            find方法较难理解,个人难点在于返回值上,查询语句并不难理解,但在后续编码中较为重要;
            在find方法中如果传入参数为Object,则使用Class F = obj.getClass()
            如果传入参数为packageName,则使用Class F = Class.forName("packageName")
             */
            String query ="SELECT*FROM "+this.TableName+" Where C_VersionID ='"+VersionID+"'";
            Method_CreateObject();
            //System.out.println(query);
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){

                Class F = Class.forName(PackageName);
                //Class F = obj.getClass();
                //实例化
                Object Find = F.newInstance();
                //获取列名
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                //获取列数
                int lieNumber = resultSetMetaData.getColumnCount();
                //System.out.println(lieNumber);

                for (int i = 0; i < lieNumber; i++) {
                    //通过序号获取列名
                    String columnName = resultSetMetaData.getColumnName(i+1);
                    //获取值
                    Object columnValue = resultSet.getObject(i+1);
                    //根据列名获取属性.getDeclaredField,获取类中所有的声明字段
                    Field field = F.getDeclaredField(columnName);
                    //可以向私有属性中写值,将private变为public
                    field.setAccessible(true);
                    //写值
                    field.set(Find, columnValue);
                }
                results.add(Find);
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return results;
    }

    public void Method_Update(String sql){
        try{
            Method_CreateObject();
            Method_I_U_D(sql);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }


//    public ArrayList<Object>

}
