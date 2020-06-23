package br.com.planos.planos.endpoints.advise;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName){
        super("Resource: " + resourceName + " not found");
    }
}
