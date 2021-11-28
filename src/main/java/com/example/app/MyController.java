package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MyController {
    @Autowired

    private EndToEndRepository endToendRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewMessage(@RequestParam String name
            , @RequestParam String message) {
        EndToEnd n = new EndToEnd();
        n.setName(name);
        n.setMessage(message);
        endToendRepository.save(n);
        return "Saved";
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    String removeMessage(@PathVariable Integer id) {
        endToendRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<EndToEnd> getAllEndToEnds() {
        return endToendRepository.findAll();
    }


    @PutMapping("/{id}")
    public @ResponseBody
    String replaceMessage(@RequestParam String name, @RequestParam String message, @PathVariable Integer id) {

        return endToendRepository.findById(id)
                .map(n -> {
                    n.setName(name);
                    n.setMessage(message);
                    endToendRepository.save(n);
                    return "updated";
                })
                .orElseGet(() -> {
                    EndToEnd n = new EndToEnd();
                    n.setName(name);
                    n.setMessage(message);
                    endToendRepository.save(n);
                    return "not updated, but created";
                });
    }
}
