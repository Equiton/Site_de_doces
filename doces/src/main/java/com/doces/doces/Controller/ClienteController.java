package com.doces.doces.Controller;

import com.doces.doces.Model.Cliente;
import com.doces.doces.Model.Dependentes;
import com.doces.doces.Model.Produto;
import com.doces.doces.Repository.ClienteRepository;
import com.doces.doces.Repository.DependentesRepository;
import com.doces.doces.Repository.ProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

    @Autowired
    DependentesRepository dependentesRepo;

    @Autowired
    ProdutosRepository produtoRepo;

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarClientes() {
        ModelAndView mav = new ModelAndView("cadastrar");
        Cliente cliente = new Cliente();
        Dependentes dependentes = new Dependentes();
        Produto produto = new Produto();
        mav.addObject("cliente", cliente);
        mav.addObject("dependente", dependentes);
        mav.addObject("produto", produto);
        return mav;
    }

    @PostMapping("/adicionarCliente")
    public String adicionarCliente(Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/cadastrar";
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("listar");
        return mav;

    }

    @GetMapping("/listarClientes")
    public ModelAndView listarPessoas() {
        ModelAndView mav = new ModelAndView("listarPessoas");
        mav.addObject("listarClientes", clienteRepo.findAll());
        mav.addObject("listarDependentes", dependentesRepo.findAll());
        return mav;
    }

    @GetMapping("/editarCliente/{id}")
    public ModelAndView getEditarCliente(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("editarPessoa");
        Cliente cliente = clienteRepo.findById(id).orElseThrow();
        mav.addObject("cliente", cliente);
        return mav;
    }

    @PostMapping("/listarEditarCliente/{id}")
    public String editarListarCliente(@PathVariable("id") Long id, Cliente cliente) {
        Cliente lista = clienteRepo.findById(id).orElseThrow();
        lista.setCep(cliente.getCep());
        lista.setCidade(cliente.getCidade());
        lista.setDataNascimento(cliente.getDataNascimento());
        lista.setEmail(cliente.getEmail());
        lista.setEnderecoCompleto(cliente.getEnderecoCompleto());
        lista.setGenero(cliente.getGenero());
        lista.setNomeCompleto(cliente.getNomeCompleto());
        clienteRepo.save(lista);
        return "redirect:/listarClientes";
    }

    @GetMapping("/removerCliente/{id}")
    public String deletarCliente(@PathVariable("id") Long id) {
        clienteRepo.deleteById(id);
        return "redirect:/listar";
    }

}
