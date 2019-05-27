/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.FilmActor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Okala
 */
@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer>{
    
}
