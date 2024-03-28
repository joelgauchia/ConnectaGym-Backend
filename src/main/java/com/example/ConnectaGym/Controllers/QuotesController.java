package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Quota;
import com.example.ConnectaGym.Security.dto.QuotaDto;
import com.example.ConnectaGym.Services.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/quotes")
@RestController
public class QuotesController {

    @Autowired
    QuotesService quotesService;

    @GetMapping("/llistat")
    public List<QuotaDto> getQuotes() {
        return this.mapToQuotaDto(quotesService.getQuotes());
    }

    @GetMapping("/perGimnas")
    public List<QuotaDto> getQuotesByGimnasNom(@RequestParam("nomGimnas") String nomGimnas) {
        return this.mapToQuotaDto(quotesService.getQuotesByGimnasNom(nomGimnas));
    }

    @GetMapping("/{id}")
    public Quota getQuoteById(@PathVariable("id") Long id) {
        return this.quotesService.getQuoteById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> afegirQuota(@RequestBody Quota q) {
       try {
           Quota quota = quotesService.afegirQuote(q);
           return ResponseEntity.status(HttpStatus.CREATED).body("Quota creada amb èxit");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació de la quota");
       }
    }

    @PutMapping("/{id}")
    public QuotaDto editarQuota(@PathVariable("id") Long id, @RequestBody Quota q) {
        return this.mapToQuotaDto(quotesService.editarQuote(id, q));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> esborrarQuota(@PathVariable("id") Long id) {
        try {
            quotesService.esborrarQuote(id);
            return ResponseEntity.ok("Quota esborrada amb èxit");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private QuotaDto mapToQuotaDto(Quota quota) {
        QuotaDto quotaDto = new QuotaDto();
        quotaDto.setId(quota.getId());
        quotaDto.setNom(quota.getNom());
        quotaDto.setPreu(quota.getPreu());
        quotaDto.setTipus(quota.getTipus());
        quotaDto.setMesos(quota.getMesos());
        quotaDto.setGimnas(quota.getGimnas());
        quotaDto.setCreador(quota.getCreador());
        quotaDto.setDataCreacio(quota.getDataCreacio());
        quotaDto.setDataModificacio(quota.getDataModificacio());
        return quotaDto;
    }

    private List<QuotaDto> mapToQuotaDto(List<Quota> quotes) {
        List<QuotaDto> quotesDto = new ArrayList<>();
        for (Quota quota : quotes) {
            quotesDto.add(mapToQuotaDto(quota));
        }
        return quotesDto;
    }
}