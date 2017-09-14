package com.paresh.springlearning.spring5webapp.bootstrap;

import com.paresh.springlearning.spring5webapp.model.Author;
import com.paresh.springlearning.spring5webapp.model.Book;
import com.paresh.springlearning.spring5webapp.model.Publisher;
import com.paresh.springlearning.spring5webapp.repositories.AuthorRepository;
import com.paresh.springlearning.spring5webapp.repositories.BookRepository;
import com.paresh.springlearning.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//This class will be used to create a context when we start our service, it will create some objects and put them in database on start up
//When we user @Component then this tells spring that this is a bean and should be taken into context at startup
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author steven = new Author("Steven","Erikson");
        Publisher tor = new Publisher("Tor","Vienna");
        Book gotm = new Book("Gardens of the moon","12345",tor);
        steven.getBooks().add(gotm);
        gotm.getAuthors().add(steven);

        authorRepository.save(steven);
        publisherRepository.save(tor);
        bookRepository.save(gotm);

        Author scott = new Author("Scott","Baker");
        Publisher batman = new Publisher("Batman","NewYork");
        Book dtcb = new Book("Darkness that comes before","54321",batman);
        scott.getBooks().add(dtcb);
        dtcb.getAuthors().add(scott);

        authorRepository.save(scott);
        publisherRepository.save(batman);
        bookRepository.save(dtcb);
    }

}
