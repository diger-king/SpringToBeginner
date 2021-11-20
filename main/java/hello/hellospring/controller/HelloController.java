package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // hello url로 들어가면 보여줄것들
    public String hello(Model model) {
        //data라는 속성에 Spring!!이라는 값을 넣어주는 문장
        model.addAttribute("data", "Spring!!");
        return "hello";
        // hello라는 템플릿 파일(view)로 경로 안내 ( 렌더링 해주는 것)
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP 통신에서의 Head Body 중 Body에 아래 데이터를 넣는다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }



    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
