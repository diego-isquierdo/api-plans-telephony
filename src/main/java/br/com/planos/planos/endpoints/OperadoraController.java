package br.com.planos.planos.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/operadora")
public class OperadoraController {

    @ResponseBody
    @RequestMapping
    public String controla(){
        return "Operadora";
    }

}
