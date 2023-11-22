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
    
        adminService.processDailySales(dailySalesData);

        return new ResponseEntity<>("Daily sales sent to admin successfully", HttpStatus.OK);
    }
}
