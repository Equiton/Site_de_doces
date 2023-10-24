package com.doces.doces.Controller;

import java.util.List;

import com.doces.doces.Model.Pedidos;
import com.doces.doces.Repository.PedidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidosRepository pedidosRepo;

    @GetMapping
    public String pedidos() {
        return "pedidos.html";
    }

    @GetMapping("/listarPedidos")
    public ModelAndView listarPedidos() {
        List<Pedidos> listarPedidos = pedidosRepo.findAll();
        ModelAndView mav = new ModelAndView("listarPedidos");
        mav.addObject("Pedidos", listarPedidos);
        return mav;
    }

    @GetMapping("/adicionarPedidos")
    public ModelAndView adicionarPedidos() {
        ModelAndView mav = new ModelAndView("adicionarPedidos");
        Pedidos pedidos = new Pedidos();
        mav.addObject("pedidos", pedidos);
        return mav;
    }

    @PostMapping("/salvarPedidos")
    public String salvarPedidos(Pedidos pedidos) {
        pedidosRepo.save(pedidos);
        return "redirect:/pedidos";
    }

}
