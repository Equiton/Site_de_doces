package com.doces.doces.Controller;

import java.util.List;

import com.doces.doces.Model.Dependentes;
import com.doces.doces.Repository.DependentesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    DependentesRepository dependentesRepo;

    @PostMapping("/adicionarDependente")
    public String salvarDependentes(Dependentes dependentes) {
        dependentesRepo.save(dependentes);
        return "redirect:/cadastrar";

    }

    @GetMapping("/listarDependentes")
    public ModelAndView listarDependentes() {
        List<Dependentes> listarDependentes = dependentesRepo.findAll();
        ModelAndView mav = new ModelAndView("listarDependentes");
        mav.addObject("dependentes", listarDependentes);
        return mav;
    }

    @GetMapping("/editarDependente/{id}")
    public ModelAndView editarDependente(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("editarPessoa");
        Dependentes editar = dependentesRepo.findById(id).orElseThrow();
        mav.addObject("dependente", editar);
        return mav;
    }

    @PostMapping("/listarEditarDependente/{id}")
    public String listarEditarDependente(@PathVariable("id") Long id, Dependentes depedente) {
        Dependentes lista = dependentesRepo.findById(id).orElseThrow();
        lista.setDataNascimentoDepen(depedente.getDataNascimentoDepen());
        lista.setGeneroDepen(depedente.getGeneroDepen());
        lista.setNomeDependente(depedente.getNomeDependente());
        dependentesRepo.save(lista);
        return "redirect:/listarClientes";
    }

    @GetMapping("/removerDependente/{id}")
    public String removerDependentes(@PathVariable("id") Long id) {
        dependentesRepo.deleteById(id);
        return "redirect:/listar";
    }

}
