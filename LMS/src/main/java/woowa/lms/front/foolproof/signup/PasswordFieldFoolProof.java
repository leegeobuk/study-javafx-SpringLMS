package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import woowa.lms.front.foolproof.FieldFoolProof;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordFieldFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Password should contain at least one special character without whitespace with length of 8 to 15";
    private static final String PATTERN = "(?=.*[!@#$%^&+=])(?=\\S+$).{8,15}";
    private static final PasswordFieldFoolProof INSTANCE = new PasswordFieldFoolProof();

    public PasswordFieldFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static PasswordFieldFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        matcher = pattern.matcher(textField.getText());
        return matcher.matches();
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
