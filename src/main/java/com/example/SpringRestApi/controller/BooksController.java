package com.example.SpringRestApi.controller;

import com.example.SpringRestApi.model.Books;
import com.example.SpringRestApi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository repo;

    @GetMapping
    public  String test(){
        return "tast api works.";
    }

    @GetMapping("/test2")
    public String test1()
    {
        return "test2 works";
    }

    @PostMapping("/{name}/{age}/{city}")
    public String  addBook(@PathVariable String name, @PathVariable int age, @PathVariable String city,@PathVariable int id){
        return "My name is "+name+"\n"+"My age is "+age+"\n My city is "+city+"\n My id is "+id;
    }

    @PostMapping("/query")
    public String queryTest(@RequestParam String name,@RequestParam int age){
        return "My name is "+name+"\n"+"My age is "+age;
    }
    @PostMapping("/body")
    public String bodyTest(@RequestBody String value){
        return "My name is "+value;
    }


    @PostMapping("/body/json")
    public String bodyJsonTest(@RequestBody HashMap<String ,String > value){
        return "My name is "+value.get("name")+"\n"+"My age is "+value.get("age")+"\n My city is "+value.get("city");
    }

    @PostMapping("/body/json/books")
    public String bodyBookTest(@RequestBody Books value){
        return "Book name is "+value.getName()+"\n"+"Book year is "+value.getYear()+"\n Books author is "+value.getAuthor();
    }

    @PostMapping("/body/save")
    public Books bodyBook(@RequestBody Books value){
        return repo.save(value);
    }

    @GetMapping("/body/getAll")
    public List<Books> bodyBook(){
        return repo.findAll();
    }

    @GetMapping("/body/get/{id}")
    public Books bodyBookById(@PathVariable long id){
        return repo.findById(id).get();
    }

    @PutMapping("/body/update")
    public Books bodyBookupdate(@RequestBody Books value){
        return repo.save(value);
    }

    @DeleteMapping("/body/{id}")
    public void bodyBookupdate(@PathVariable long id){
         repo.deleteById(id);
    }

}
