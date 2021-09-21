package com.sp.senac.br.demo.controller;

import com.sp.senac.br.demo.dao.RepositorioDAO;
import com.sp.senac.br.demo.model.RepositorioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RepositorioController {

    @Autowired
    private RepositorioDAO dao;

    @PostMapping("/salvarRepositorio")
    public String salvarRepositorio(@ModelAttribute RepositorioEntity repositorio){
        dao.save(repositorio);
        return "index";
    }

    @GetMapping("/cadastrar_repositorio")
    public ModelAndView paginaCadastroRepositorio(RepositorioEntity repositorio){
        ModelAndView mv = new ModelAndView("cadastro_repositorio");
        mv.addObject("repositorio", repositorio);

        return mv;
    }
}
