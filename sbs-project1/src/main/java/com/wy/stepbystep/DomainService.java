package com.wy.stepbystep;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class DomainService {

    private Map<Integer, String> domains = new HashMap<>();

    public DomainService() {
        domains.put(Integer.valueOf(1), "yahoo");
        domains.put(Integer.valueOf(2), "google");
    }
    public void addNewDomain(Integer domainId, String domainName){
        System.out.println("Add New Domain...");
        System.out.println(domainId + ": " + domainName);
        domains.put(domainId, domainName);
    }

    public Map<Integer, String> getDomains(){
        System.out.println("Get Domains...");
        domains.forEach((key, value) -> System.out.println( key + ": " + value));
        return domains;
    }

    public String convertToString(){
        String domainsAsString = domains.keySet().stream().map(key -> key + "=" + domains.get(key)).
                collect(Collectors.joining(",", "{", "}"));
        return domainsAsString;
    }

    public void clearAllDomains(){
        domains.clear();
    }

}
