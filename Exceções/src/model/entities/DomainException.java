package model.entities;

public class DomainException extends RuntimeException{
    private static final long serialVersionsUID = 1L;

    public DomainException(String msg){
        super(msg);
    }

}
