package custom.orderapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class order {
    public order() {
        super();
    }

    public static void main(String[] args) {
        order order = new order();
        //ResultSet rs= order.getorderinfo(101, 1);
        String result = order.getorderinfo(101, 1);
        System.out.println(result);
    }

    public int getordercount()
    {
        int ordercount = 0;
        return ordercount;
    }
    
    public int getlinecount(int ordernumber)
    {
      int orderlinecount =0;
      return orderlinecount;
    }

/*    
    public static List<JSONObject> getorderinfo(int ordernumber, int offset)
    {      
    }
*/
    public String getorderinfo(int ordernumber, int offset)  {
        System.out.println("Inside getorderinfo"); 
        System.out.println("ordernumber : " + ordernumber);
        System.out.println("offset : " + offset);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection con = null;
        PreparedStatement  pstmt= null;
        ResultSet rs=null;
        StringBuffer result = new StringBuffer();
        try
        {
          //con = databaseConnection.getOracleConnection();
          con = databaseConnection.getMySQLConnection();
          StringBuffer querysb = new StringBuffer();
          querysb.append("select oh.order_number, oh.source_location, oh.destination_location, oh.transport_mode, oh.order_reference_type, oh.order_creation_date, ol.item_description, ol.uom_code, ol.declared_value");
          querysb.append(" from order_header oh, order_lines ol");
          querysb.append(" where oh.order_header_id = ol.order_header_id and oh.order_number=?");

          String selectsql = querysb.toString();
            
          System.out.println("Query : " + selectsql);
            
          pstmt=con.prepareStatement(selectsql);                         
          pstmt.setInt(1, ordernumber);
                    
          rs= pstmt.executeQuery();          
            
          while(rs.next())  
          {
             result.append(" Order Number " + rs.getInt(1) + "|" + " Source Location " + rs.getString(2) + "|" + " Item Description " + rs.getString(7));
          }
          
          //System.out.println(result.toString());
          con.close();
        }
        catch(SQLException se)
        {
            System.err.println("***SQL Exception***");
            se.printStackTrace();
        }
        catch(Exception ex) {
                   System.err.println("***exception trying to connect***");
                   ex.printStackTrace();
                 }
        finally
        { 
            try
            {
            if (con != null)
                con.close();   
            }
            catch(SQLException secon)
            {
                System.err.println("***SQL Exception***");
                secon.printStackTrace();     
            }    
            try
            {
            if (pstmt!= null)
                pstmt.close();
            }    
            catch(SQLException sepstmt)
            {
                System.err.println("***SQL Exception***");
                sepstmt.printStackTrace();     
            }                
        }
        //return rs;
        return result.toString();
    }

}
