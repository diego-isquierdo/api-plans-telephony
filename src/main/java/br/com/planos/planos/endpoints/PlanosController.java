package br.com.planos.planos.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("planos")
public class PlanosController {

    @ResponseBody
    @RequestMapping("/")
    public String consultar(){
        return "Hello Word";
    }
}
