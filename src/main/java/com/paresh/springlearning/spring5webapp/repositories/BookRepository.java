package com.paresh.springlearning.spring5webapp.repositories;
import com.paresh.springlearning.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;
//Spring Data JPA is part of Spring Data projects. It provides us with an Interface which can be used to talk to database layer at runtime.
//wherever this interface is used we can get objects from database or create objects in database. (Interface will provide us with the object)
//CRUD means: create read update and delete so CurdRepository provides us with these functionalities.
// you will need to provvide curd a JPA entitry in our case it is Book and a unique value identifier type (id of Book) which is long
public interface BookRepository extends CrudRepository<Book, Long> {
}
