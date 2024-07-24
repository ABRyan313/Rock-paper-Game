package Itransition_Java_TAsk3;

public class ValidationError {
    private String message;

    protected ValidationError(String message) {
        this.message = message;
    }

    public static ValidationError InvalidLength = new ValidationError("Please enter an odd number of moves.");
    public static ValidationError InvalidArguments = new ValidationError("All moves must be distinct.");

    @Override
    public String toString() {
        return String.join("\n",
                "Argument error.",
                message,
                "Example: java -jar Main.jar rock paper scissors");
    }
}
