package com.example.consumindoCepApi.controller;

import com.example.consumindoCepApi.dto.ConsultaCepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta")
public class ConsultaCep {

    @GetMapping("{cep}")
    public ConsultaCepDTO getCep(@PathVariable("cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCepDTO> result =
                restTemplate.getForEntity( String.format("https://viacep.com.br/ws/%s/json/", cep),
                        ConsultaCepDTO.class);

        System.out.println("");
        System.out.println("Seu bairro: " + result.getBody().getBairro());
        System.out.println("Seu cep: " + result.getBody().getCep());
        System.out.println("Seu DDD: " + result.getBody().getDdd());
        System.out.println("Sua cidade: " + result.getBody().getLocalidade());
        System.out.println("Seu estado: " + result.getBody().getUf());
        System.out.println("");

        return  result.getBody();
    }

}
