/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.Actor;
import bootcamp.mii.bootcamp.mii.repositories.ActorRepository;
import bootcamp.mii.bootcamp.mii.services.FilmActorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Okala
 */
@Controller
public class MainController {

    @Autowired
    private FilmActorService filmActorService;
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/")
    public String index(Model model) {
        String idnya = "2";
        model.addAttribute("dataActor", filmActorService.findAllActor());
        return "index";
    }

//    @PostMapping("/addactor")
//    public String addActor(@Valid Actor actor, Model model) {
////        if (result.hasErrors()) {
////            return "index";
////        }
//        actorRepository.save(actor);
//        model.addAttribute("actor", actorRepository.findAll());
//        return "index";
//    }
//    @RequestMapping(value = "/addData", method = RequestMethod.POST)

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Short id, Model model) {
        Short ida = id;
        int id_actor= ida.intValue();
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid actor Id:" + id));

        model.addAttribute("actor", actor);
        return "updateActor";
    }

    @PostMapping("/addData")
    public String addData (@Valid Actor actor){
        actorRepository.save(actor);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/";
    }
    
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @GetMapping("/update")
    public String updateActor(@Valid Actor actor) {
//        if (result.hasErrors()) {
//            actor.setActorId(id);
//            return "updateActor";
//        }
        actorRepository.save(actor);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable("id") Short id, Model model) {
        Short ida = id;
        int id_actor= ida.intValue();
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid actor Id:" + id));
        actorRepository.delete(actor);
        model.addAttribute("actor", actorRepository.findAll());
        return "index";
    }
}
