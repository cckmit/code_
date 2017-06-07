package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Message;
import com.mika.credit.facade.globaleagle.core.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 2016/12/20.
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/customer/mesCaution")
    public @ResponseBody String mesCaution(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        List<Map<String, String>> listMesCaution = new ArrayList<Map<String,String>>();
        Integer toIdInt = 0;
        String toId = "";
        if (customer != null ) {
            toIdInt = customer.getId();
            toId = String.valueOf(toIdInt);
            if(!"1".equals(toId)){
                return "200";
            } else {
                listMesCaution = this.messageService.mesCaution(toIdInt, "否");
                if (listMesCaution.size() == 0){
                    listMesCaution.addAll(new ArrayList<Map<String, String>>());
                }
            }
        }
        return JSON.toJSONString(listMesCaution);
    }




    @RequestMapping(value = "/customer/insMessage")
    public @ResponseBody Message insMessage(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        String textContent = "";
        String url = "";
        String fromId = request.getParameter("fromId");
        String toId = request.getParameter("toId");
        if (fromId != "" && fromId != null) {
            textContent = request.getParameter("textContent");
            url = request.getParameter("url");
        } else {
            textContent = request.getParameter("textContent");
            url = request.getParameter("url");
            Integer toIdInt = customer.getId();
            toId = String.valueOf(toIdInt);
            fromId = "1";
        }
        Message message = this.messageService.insMessage(textContent, url, fromId, toId);
        return message;
    }

    @RequestMapping(value = "/customer/loadMessage")
    public @ResponseBody List<Message> queryMes(HttpServletRequest request) {
        String toId = request.getParameter("toId");
        String fromId = request.getParameter("fromId");
        Map<String, String> map = new HashMap<String, String>();
        if (fromId != null && fromId != "") {
            Map<String, String> mapUpd = new HashMap<String,String>();
            mapUpd.put("fromId", fromId);
            mapUpd.put("isRead", "是");
            this.messageService.updateByFromId(mapUpd);
        } else {
            Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
            Integer toIdInt = customer.getId();
            toId = String.valueOf(toIdInt);
            fromId = "1";
        }
            map.put("fromId", fromId);
            map.put("toId", toId);
            List<Message> listAll = this.messageService.queryMessage(map);
            return listAll;

    }


}
