package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expedition")
public interface MicroserviceExpeditionProxy {

    @PostMapping(value = "/microservice-expedition/expedition")
    ExpeditionBean ajouterExpedition(@RequestBody ExpeditionBean expedition);

    @GetMapping(value = "/microservice-expedition/expedition/{id}")
    ExpeditionBean etatExpedition(@PathVariable("id") int id);

    @PutMapping(value = "/microservice-expedition/expedition")
    void mettreAJourExpedition(@RequestBody ExpeditionBean expedition);

}
