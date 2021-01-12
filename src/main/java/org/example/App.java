package org.example;

import org.example.model.Pet;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Pet> pets = Arrays.asList(
                new Pet(1, "Fluffy", LocalDate.now(), true),
                new Pet(2, "Simon the dog", LocalDate.parse("2000-01-21"), false),
                new Pet(3, "Kent", LocalDate.parse("2015-03-12"), true)
        );

        foo(pets, Pet::isAlive, Pet::toString)
                .forEach(System.out::println);

        bar(pets, pet -> pet.getName().startsWith("S"), Pet::idAndName, HashSet::new)
                .forEach(System.out::println);

        Comparator<Pet> petComparator = Comparator.comparing(Pet::getBirthDate)
                .thenComparing(Pet::getName);

        Comparator<Pet> petComparator2 = Comparator.comparing(Pet::getBirthDate).reversed();

        pets.sort(petComparator2);

        System.out.println("*******");
        pets.forEach(System.out::println);



    }



    public static Collection<String> foo(Collection<Pet> source, Predicate<Pet> filter, Function<Pet, String> mapping){
        Collection<String> result = new ArrayList<>();
        for(Pet t : source){
            if(filter.test(t)){
                String r = mapping.apply(t);
                result.add(r);
            }
        }
        return result;
    }

    public static <T,R> Collection<R> bar(
            Collection<T> source,
            Predicate<T> filter,
            Function<T, R> mapper,
            Supplier<Collection<R>> supplier
    ){
        Collection<R> result = supplier.get();
        for(T p : source){
            if(filter.test(p)){
                result.add(mapper.apply(p));
            }
        }
        return result;
    }

    public static List<Pet> filterPets(Collection<Pet> source, Predicate<Pet> filter){
        List<Pet> out = new ArrayList<>();
        for(Pet p : source){
            if(filter.test(p)){
                out.add(p);
            }
        }
        return out;
    }
}
