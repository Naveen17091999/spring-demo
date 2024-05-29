package com.example.SpringRestApi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class MyController {


    private static List<String> list = new <String>ArrayList();

    @GetMapping
    public List<String> getApi(){
        return list;
    }

    @PostMapping
    public String postApi(@RequestBody String name){
        list.add(name);
        return "Name added to list";
    }

    @PutMapping("/{index}")
    public String putApi(@RequestBody String name, @PathVariable int index){
        System.out.println(list.size());
        if(list.size()> index) {
            list.set(index, name       );
            return "List updated.";
        }
        return "Index not present.";
    }

    @DeleteMapping("/")
    public String deleteApi(@RequestParam int index){
        list.remove(index);
        return "Delete Api called";
    }

    @GetMapping(path="/getbyindex")
    public String getByIndex(@RequestParam int index){
        return list.get(index);
    }
}
