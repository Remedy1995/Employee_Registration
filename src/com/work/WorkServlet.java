package com.work;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorkServlet  extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
         String username=request.getParameter("username");
         String password=request.getParameter("password");
         String address=request.getParameter("address");
         String contact=request.getParameter("contact");

        WorkDao workDao=new WorkDao();
        Workmodel workmodel=new Workmodel();
        workmodel.setFirstname(firstname);
        workmodel.setLastname(lastname);
        workmodel.setUsername(username);
        workmodel.setPassword(password);
        workmodel.setAddress(address);
        workmodel.setContact(contact);
        try  {


            workDao.Register(workmodel);

            PrintWriter out= response.getWriter();

            out.println("Employee has been registered successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error while registering user");
        }
    }
}
