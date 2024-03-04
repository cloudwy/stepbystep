package com.wy.stepbystep;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.annotation.*;

@Controller("/")
public class FirstController {
    private DomainRepository domainRepository;

    public FirstController(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }


    @Get("/")
    public String getAllDomains(){
        return domainRepository.convertToString();
    }

    @Post("/new-domain")
    public String createNewDomain(Integer domainId, String domainName){
        if (StringUtils.isEmpty(domainName))
                return null;
        String str = "Create New Domain: {" + domainId + ": " + domainName + "}";
        return str;
    }
}
