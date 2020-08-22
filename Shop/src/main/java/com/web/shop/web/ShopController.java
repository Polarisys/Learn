package com.web.shop.web;

import com.web.shop.entity.Admin;
import com.web.shop.entity.Item;
import com.web.shop.entity.User;
import com.web.shop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @anthor sily
 * @date 2019/12/28 - 20:55
 */
@Controller
@RequestMapping("/shops")
public class ShopController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ShopService shopService;

    //获取商品列表
    @RequestMapping(value = "/shopList", method = RequestMethod.GET)
    private String List(Model model) {
        List<Item> list = shopService.queryAll(1, 5);
        model.addAttribute("list", list);
        return "shopList";
    }

    //根据商品标题搜索商品
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收页面的值
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        title = title.trim();
        //向页面传值
        request.setAttribute("title",title);
        request.setAttribute("list",shopService.querySome(title));
        request.getRequestDispatcher("/WEB-INF/jsp/shopList.jsp").forward(request,response);
    }

    //实现分页
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    private List<Item> pageList(HttpServletResponse response,HttpServletRequest request){
        String secondColumn = request.getParameter("columnNumber");
        String record = request.getParameter("recordNumber");
        List<Item> list = null;
        if(record.equals("")){
            record = "5";
        }
        if(secondColumn!=null){
            Integer pageNumber = Integer.parseInt(secondColumn);
            Integer recordNumber = Integer.parseInt(record);
            list = shopService.queryAll(pageNumber,recordNumber);
        }else {
            list = shopService.queryAll(1,5);
        }
        return  list;
    }

    //验证用户输入的账号是否正确
    @RequestMapping(value = "/verifyCustomer",method = RequestMethod.POST)
    @ResponseBody
    private Map validateCustomer(HttpServletRequest request,HttpServletResponse response){
        Map userMap = new HashMap();
        User user = null;
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        user = shopService.validateUser(username,password);
        System.out.println(user);
        if(user!=null){
            userMap.put("result","SUCCESS");
            return userMap;
        }else{
            userMap.put("result","FAILED");
            return userMap;
        }
    }

    //验证管理员的账号是否正确
    @RequestMapping(value = "/verifyAdmin",method = RequestMethod.POST)
    @ResponseBody
    private Map validateAdmin(HttpServletResponse response,HttpServletRequest request){
        Map adminMap = new HashMap();
        Admin admin = null;
        String adminId = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(adminId);
        System.out.println(password);
        admin = shopService.validateAdmin(adminId,password);
        System.out.println(admin);
        if(admin != null){
            adminMap.put("result","SUCCESS");
            System.out.println("success");
            return adminMap;
        }else{
            adminMap.put("result", "FAILED");
            return adminMap;
        }
    }

    //查看商品的的详细情况
    //@PathVariable是请求占位符的意思
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("id") Long id,Model model){
        Item item = shopService.getById(id);
        if(item == null){
            return "forward:/shops/shopList";
        }
        model.addAttribute("item",item);
        return "detail";
    }

    //添加商品到购物车


}
