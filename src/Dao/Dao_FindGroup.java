package Dao;

import Entity.Bean_T_WangYiVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_FindGroup {
    public ArrayList<Bean_T_WangYiVersion> Methoy_FindGroup(String tableName, String groupid){
        ArrayList<Bean_T_WangYiVersion> resultsList = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=T_ZD_Work","sa","7777");
            Statement statement = connection.createStatement();
            String sql = "SELECT*FROM "+tableName+"  where C_Group = "+groupid;
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Bean_T_WangYiVersion bean_t_wangYiVersion = new Bean_T_WangYiVersion();
                bean_t_wangYiVersion.setC_VersionID(resultSet.getString(4));
                //bean_t_wangYiVersion.(resultSet.getString(7));
                bean_t_wangYiVersion.setC_DownState(resultSet.getString(7));
                resultsList.add(bean_t_wangYiVersion);
            }
            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception ex){
            System.out.println(ex);
        }
        return resultsList;
    }
}
