package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        // spring will automatically auto-wire the BookRepository in
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        // spring passes an implementation of the model interface as a parameter

        model.addAttribute("books", bookRepository.findAll()); // sets the name of the array in th:each

        return "books"; // associates with the thymeleaf view - this must be the name of the view
    }
}
