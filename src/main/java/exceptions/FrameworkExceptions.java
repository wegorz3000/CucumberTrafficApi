package exceptions;

public class FrameworkExceptions extends Exception {

    private ExceptionType exceptionType;
    private String errorMessage;

    public FrameworkExceptions(ExceptionType type, String errorMessage) {
        this.exceptionType = type;
        this.errorMessage = errorMessage;
    }


    public enum ExceptionType {
        noBodyContains(1);

        int errorNumber;
        String errorMessage;
        private String exceptionType;

        ExceptionType(int errorNumber) {
            this.errorNumber = errorNumber;
        }

        @Override
        public String toString() {
          return "Error type: " + exceptionType + ". Message: " + errorMessage;
        }

    }
}
