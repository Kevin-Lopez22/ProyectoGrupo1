/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.util.function.Predicate;

/**
 *
 * @author luism
 */
public class Validator<E> {
    private final E target;
    private final Predicate<E> predicate;

    public Validator(E target, Predicate<E> predicate) {
        this.target = target;
        this.predicate = predicate;
    }
    
    public boolean test(){
        return predicate.test(target);
    }
}
