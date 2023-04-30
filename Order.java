/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author admin
 */
@WebService(serviceName = "employee")
public class employee {

    /**
     * This is a sample web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getDetails")
    public String getDetails(@WebParam(name = "id") int id) {
        String s="";
        
        String d="";
        try{
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/employee092");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from untitled where uid="+id);
            while(rs.next()){
                if(rs.getInt(1)==id){
                    s=rs.getString(2);
                     
                      d=rs.getString(3);
                    break;
                            }
                
            }
            
        }
        catch(Exception e){
            
        }
        if(s!=null && d!=null){
                return s +"   "+ d ;
            }
            else{
                return "no data found";
            }
    }
}