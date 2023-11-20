package th.mfu.Controller;

import th.mfu.Domain.*;
import th.mfu.Repository.*;
import th.mfu.Service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/barista")
public class BaristaController {

    @Autowired
    private AdminService adminService; // AdminService เป็น Service ที่ให้บริการการสื่อสารกับ Admin

    @PostMapping("/daily-sales")
    public ResponseEntity<String> sendDailySales(@RequestBody Dailytotalsale dailySalesData) {
        // ทำการส่งข้อมูลไปยัง Admin
        adminService.processDailySales(dailySalesData);

        return new ResponseEntity<>("Daily sales sent to admin successfully", HttpStatus.OK);
    }
//     @WebServlet(urlPatterns ="/sum")
// public class CalculatorServlet extends HttpServlet{
//     @Override
//     protected void doGet(HttpServletRequest request,
//             HttpServletResponse response) throws ServletException, IOException {
//         //TODO: retreive the parameter num1 and num2 from the request 
//         String string1 = request.getParameter("num1");
//         String string2 = request.getParameter("num2");
//         String string3 = request.getParameter("num3");
//         //TODO: convert the parameter values from String to int
//        int num1 = Integer.parseInt(string1);
//        int num2 = Integer.parseInt(string2);
//        int num3 = Integer.parseInt(string3); 
//        int num4 = for
//         //TODO: print out result as <h2>Result is 10</h2>
//         response.setContentType("text/html");
//         PrintWriter pw =response.getWriter();
//         pw.print("<h2>Result is "+num3+"</h2>");
//     }

//     @Override
//     protected void doPost(HttpServletRequest request,
//             HttpServletResponse response) throws ServletException, IOException {
//         //TODO: this method should work the same way as doGet()
//        doGet(request, response);
//     }
// }
}
