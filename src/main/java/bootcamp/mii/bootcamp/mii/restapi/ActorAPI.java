/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.restapi;

import bootcamp.mii.bootcamp.mii.entities.Actor;
import bootcamp.mii.bootcamp.mii.repositories.ActorRepository;
import bootcamp.mii.bootcamp.mii.services.FilmActorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Okala
 */
@RestController
@RequestMapping("/json/actor")
public class ActorAPI {

    @Autowired
    private FilmActorService filmActorService;
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/all/get")
    public String getActor() {
        return "{\"actor\":" + actorRepository.findAll().toString() + "}";
    }

    @GetMapping("/{id}/get")
    public String getActorId(@PathVariable short id) {
        return "{\"actor\":" + actorRepository.findById(id).toString() + "}";
    }

    @PostMapping("/save/post")
    public String saveActor(@RequestBody Actor actor) {
        actorRepository.save(actor);
        return "OK "+actor.getActorId()+"";
    }

//    @PutMapping("/{id}")
//    public String replaceEmployee(@RequestBody Actor actor, @PathVariable short id) {
//
//        return actorRepository.findById(id).map(actor -> { actor.)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//    @PostMapping("/{id}/del/post")
//    public String setActor(@PathVariable short id) {
//        Actor actor = new Actor(id);
//        actorRepository.delete(actor);
//        return "";
//    }
    @PostMapping("/delete/{id}/post")
    public String deleteActor(@PathVariable short id) {
        actorRepository.deleteById(id);
        return "OK";
    }
}
