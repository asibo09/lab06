package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException {

    public NetworkException(final String messageBeingSent){
        super("Error: "+messageBeingSent);
    }

    public NetworkException(){
        super("Network error: no response");
    }


}
