package com.doces.doces.Controller;

import java.util.List;

import com.doces.doces.Model.Produto;
import com.doces.doces.Repository.ProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutosRepository produtoRepo;

    @GetMapping()
    public String index() {
        return "produtos.html";
    }

    @PostMapping("/adicionarProdutos")
    public String salvarProduto(Produto produto) {
        produtoRepo.save(produto);
        return "redirect:listarProdutos";
    }

    // Método para listar os produtos
    @GetMapping("/listarProdutos")
    public ModelAndView listarProdutos() {
        List<Produto> listarProdutos = produtoRepo.findAll();
        ModelAndView mav = new ModelAndView("listarProdutos");
        mav.addObject("produtos", listarProdutos);
        return mav;
    }

    @GetMapping("/editarProduto/{id}")
    public ModelAndView editarProduto(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("editarProduto");
        Produto produto = produtoRepo.findById(id).orElseThrow();
        mav.addObject("produto", produto);
        return mav;
    }

    @PostMapping("/listarEditarProduto/{id}")
    public String listarEditarProduto(@PathVariable("id") Long id, Produto produto) {
        Produto lista = produtoRepo.findById(id).orElseThrow();
        lista.setAltura(produto.getAltura());
        lista.setDataDeCadastro(produto.getDataDeCadastro());
        lista.setLargura(produto.getLargura());
        lista.setMarca(produto.getMarca());
        lista.setNomeDoProduto(produto.getNomeDoProduto());
        lista.setPeso(produto.getPeso());
        lista.setPrecoDeCompra(produto.getPrecoDeCompra());
        lista.setPrecoDeVenda(produto.getPrecoDeVenda());
        lista.setProfundidade(produto.getProfundidade());
        lista.setVolume(produto.getVolume());
        produtoRepo.save(lista);
        return "redirect:/produtos/listarProdutos";
    }

    @GetMapping("/removerProdutos/{id}")
    public String removerProduto(@PathVariable("id") Long id) {
        produtoRepo.deleteById(id);
        return "redirect:/produtos/listarProdutos";
    }

    @PostMapping("/pesquisar")
    public ModelAndView pesquisar(@RequestParam String campoTexto) {
        ModelAndView mav = new ModelAndView("barraPesquisar");
        Boolean isNumeric = true;
        for (int i = 0; i < campoTexto.length(); i++) {
            if (Character.isDigit(campoTexto.charAt(i))) {
                isNumeric = false;
            }
        }
        if (isNumeric == false) {
            mav.addObject("produto", produtoRepo.findByPeso(Float.valueOf(campoTexto)));
        } else{
            mav.addObject("produto", produtoRepo.findByNome(campoTexto));
        }
        return mav;
    }
}
