package woowa.lms.front.ui.form;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignUpForm extends AbstractForm {

    protected Label idLabel;
    protected Label pwLabel;
    protected Label confirmPwLabel;
    protected Label nameLabel;
    protected Label contactLabel;
    protected InputField idInputField = InputField.of(TEXT, ID, "ID");
    protected InputField pwInputField = InputField.of(PASSWORD, PW, "Password");
    protected InputField confirmPwInputField = InputField.of(PASSWORD, CONFIRM_PW, "Confirm password");
    protected InputField nameInputField = InputField.of(TEXT, NAME, "Name");
    protected InputField contactInputField = InputField.of(TEXT, CONTACT, "Enter without -");

    public SignUpForm(double width, double height, String title, String header) {
        super(width, height, title, header);
        inputFields = List.of(idInputField, pwInputField,
            confirmPwInputField, nameInputField, contactInputField);
    }

    @Override
    public void setUpComponents() {
        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");
        confirmPwLabel = LabelBuilder.getFormLabel("Confirm Password");
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        formPane.addRow(0, idLabel, idInputField.toTextField());
        formPane.addRow(1, pwLabel, pwInputField.toTextField());
        formPane.addRow(2, confirmPwLabel, confirmPwInputField.toTextField());
        formPane.addRow(3, nameLabel, nameInputField.toTextField());
        formPane.addRow(4, contactLabel, contactInputField.toTextField());
        formPane.add(errorLabel, 0, 5, 2, 4);
        formPane.setHgap(this.getWidth() * 0.08);
        formPane.setVgap(this.getHeight() * 0.02);
        formPane.setAlignment(Pos.CENTER);
        super.setUpPage();
    }

    @Override
    public void setFoolProof() {
        confirmPwInputField.setPasswordField(pwInputField);
        super.setFoolProof();
    }
}
