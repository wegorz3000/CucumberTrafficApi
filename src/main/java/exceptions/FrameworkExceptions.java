package exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameworkExceptions extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkExceptions.class);


    private ExceptionType exceptionType;
    private String errorMessage;

    public FrameworkExceptions(ExceptionType type, String errorMessage) {
        this.exceptionType = type;
        this.errorMessage = errorMessage;
    }


    public enum ExceptionType {
        NoBodyContains,
        NoHeaders,
        CannotSetRequestURL,
        CannotAddQueryParameter,
        CannotAddQueryParameters,
    }

    public void Message(ExceptionType exceptionType) {
        switch (exceptionType) {
            case CannotAddQueryParameter:
                logger.error("Error type: "+exceptionType+". Can't add query parameter to request");
                break;
            case CannotAddQueryParameters:
                logger.error("Error type: "+exceptionType+". Can't add query parameters to request");
            default:
                logger.error("Error not identify");

        }
    }


}
