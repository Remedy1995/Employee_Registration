package com.work;

import java.sql.*;

public class WorkDao {

    public int Register(Workmodel workmodel) throws ClassNotFoundException {
          Connection connection;
          int result=0;
        String insert="INSERT into employers"+"(firstname,lastname,username,password,address,contact)VALUES"+"(?,?,?,?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
try{
    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
    PreparedStatement preparedStatement=connection.prepareStatement(insert);

    preparedStatement.setString(1,workmodel.getFirstname());
    preparedStatement.setString(2,workmodel.getLastname());
    preparedStatement.setString(3,workmodel.getUsername());
    preparedStatement.setString(4,workmodel.getPassword());
    preparedStatement.setString(5,workmodel.getAddress());
    preparedStatement.setString(6,workmodel.getContact());

    result=preparedStatement.executeUpdate();


} catch (SQLException e) {
    e.printStackTrace();
}
return result;
    }
}
