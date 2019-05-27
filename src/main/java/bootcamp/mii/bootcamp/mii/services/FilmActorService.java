/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Actor;
import bootcamp.mii.bootcamp.mii.entities.FilmActor;
import bootcamp.mii.bootcamp.mii.repositories.ActorRepository;
import bootcamp.mii.bootcamp.mii.repositories.FilmActorRepository;
import bootcamp.mii.bootcamp.mii.repositories.FilmRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Okala
 */
@Service
public class FilmActorService {
    
    @Autowired
    private ActorRepository actorImplement;

    @Autowired
    private FilmRepository filmImplement;

    @Autowired
    private FilmActorRepository filmActorImplement;
    
    public Optional<FilmActor> findFilmActionById(String var) {
        return filmActorImplement.findById(Integer.parseInt(var));
    }
    
    public Iterable<Actor> findAllActor(){
        return actorImplement.findAll();
    }
    
//    public <Actor> saveActor(Actor){
//        return actorImplement.save(actor);
//    }
    
//    public FilmActor findFilmAndActor(String id){
//        return filmActorImplement.findByActorId(Integer.parseInt(id));
//    }
}
