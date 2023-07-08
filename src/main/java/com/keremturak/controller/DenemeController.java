package com.keremturak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/deneme")
@RequiredArgsConstructor
public class DenemeController {

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deneme");

        String kullaniciAdi = "Kullanici Adi: ";
        String sifre = "Şifre: ";

        modelAndView.addObject("ka",kullaniciAdi);
        modelAndView.addObject("psw",sifre);
        return modelAndView;
    }
    //10:37
    @PostMapping("/doLogin")
    public ModelAndView login(String txtkullaniciAdi, String txtSifre){
        ModelAndView modelAndView = new ModelAndView();
        if(txtkullaniciAdi.equals("ali") && txtSifre.equals("123")){
            modelAndView.setViewName("detaySayfasi");
        }else {
            modelAndView.setViewName("hataSayfasi");
        }
        return modelAndView;
    }

}