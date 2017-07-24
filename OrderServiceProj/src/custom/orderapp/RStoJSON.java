package custom.orderapp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RStoJSON {
    public RStoJSON() {
        super();
    }
    /*
    public String getJSONFromResultSet(ResultSet rs)
    {
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()) 
        {
          int numColumns = rsmd.getColumnCount();
          JSONObject obj = new JSONObject();
            for (int i=1; i<=numColumns; i++) 
            {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }
          json.put(obj);
    }
    return json;
    }
    
    public String getJSONFromResultSet(ResultSet rs,String keyName) {
        Map jsonmap = new HashMap(); 
        List jsonlist = new ArrayList();
        if(rs!=null)
        {
            jsonmap.put(keyName, jsonlist);
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                while(rs.next())
                {
                    Map<String,Object> columnMap = new HashMap<String, Object>();
                    try {
                        for (int columnIndex = 1; columnIndex <= metaData.getColumnCount(); columnIndex++) 
                        {
                           if(rs.getString(metaData.getColumnName(columnIndex))!=null)
                               columnMap.put(metaData.getColumnLabel(columnIndex), rs.getString(metaData.getColumnName(columnIndex)));
                           else
                               columnMap.put(metaData.getColumnLabel(columnIndex), "");
                        }
                        jsonlist.add(columnMap);                                                
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally
            {
                System.out.println("In Finally Block");
            }
        }
        return JSONValue.toJSONString(jsonmap);
        //return "ok";
    }
*/
}
