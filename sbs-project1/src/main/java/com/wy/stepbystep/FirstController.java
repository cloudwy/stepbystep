package com.wy.stepbystep;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.annotation.*;

@Controller("/")
public class FirstController {
    private DomainService domainService;

    public FirstController(DomainService domainService) {
        this.domainService = domainService;
    }


    @Get("/")
    public String getAllDomains(){
        return domainService.convertToString();
    }

    @Post("/new-domain")
    public String createNewDomain(Integer domainId, String domainName){
        if (StringUtils.isEmpty(domainName))
                return null;
        String str = "Create New Domain: {" + domainId + ": " + domainName + "}";
        return str;
    }
}
