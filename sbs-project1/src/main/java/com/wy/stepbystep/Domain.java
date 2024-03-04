//package com.wy.stepbystep;
//
//import io.micronaut.core.annotation.NonNull;
//import jakarta.inject.Singleton;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.UUID;
//
//@Singleton
//public class Domain {
//    @NotNull
//    private UUID domainId;
//
//    private String domainName;
//
//    public Domain(@NonNull UUID domainId, String domainName) {
//        this.domainId = domainId;
//        this.domainName = domainName;
//    }
//
//    public Domain addDomain(String domainName){
//        UUID domainId = UUID.randomUUID();
//        return new Domain(domainId, domainName);
//    }
//
//}
