package com.example.xiugou.controller;

import com.example.xiugou.bean.BiLiBiLiJsonBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MessageController {
    RestTemplate restTemplate=new RestTemplate();


    @RequestMapping("/index/{id}")
//    @ResponseBody
    public String getMessage(Model model, @PathVariable("id") int id) throws JsonProcessingException {
        System.out.println("id"+id);
        String re = restTemplate.getForObject("https://api.live.bilibili.com/room/v1/Danmu/getConf?room_id="+id+"&platform=pc&player=web", String.class);
        ObjectMapper objectMapper=new ObjectMapper();
        BiLiBiLiJsonBean bean=objectMapper.readValue(re,BiLiBiLiJsonBean.class);
        String url="wss://"+bean.getData().getHost_server_list().get(bean.getData().getHost_server_list().size()-1).getHost()+":"+bean.getData().getHost_server_list().get(0).getWss_port()+"/sub";
        model.addAttribute("roomId",id);
        model.addAttribute("url",url);
        model.addAttribute("token",bean.getData().getToken());
        return "index";
    }
}
