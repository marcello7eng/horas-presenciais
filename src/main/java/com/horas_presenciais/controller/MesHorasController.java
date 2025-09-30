package com.horas_presenciais.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.horas_presenciais.entity.MesHoras;
import com.horas_presenciais.enums.Mes;
import com.horas_presenciais.repository.MesHorasRepository;

@Controller
public class MesHorasController {

    private final MesHorasRepository repository;

    public MesHorasController(MesHorasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<MesHoras> meses = repository.findAll(); // ✅ usar o repository injetado

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("pt", "BR"));
        for (MesHoras m : meses) {
            YearMonth ym = YearMonth.parse(m.getMes());
            m.setMesFormatado(ym.format(formatter));
        }

        model.addAttribute("meses", meses);
        return "index";
    }



    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("mesHoras", new MesHoras());
        model.addAttribute("mesesEnum", Mes.values());
        model.addAttribute("anoAtual", LocalDate.now().getYear());
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute MesHoras mesHoras) {
        repository.save(mesHoras);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        MesHoras mesHoras = repository.findById(id).orElse(new MesHoras());
        model.addAttribute("mesHoras", mesHoras);
        model.addAttribute("mesesEnum", Mes.values());
        model.addAttribute("anoAtual", LocalDate.now().getYear());
        return "form";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}