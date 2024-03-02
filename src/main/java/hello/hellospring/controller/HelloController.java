package hello.hellospring.controller;

import lombok.Getter;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name1, Model model){
        model.addAttribute("name",name1);
        return "hello-template";
    }
    @GetMapping("hello-mvc2")
    public String helloMvc2(@RequestParam("name1") String name1, @RequestParam("name2") String name2, Model model) {
        model.addAttribute("name1", name1);
        model.addAttribute("name2", name2);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;


        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
