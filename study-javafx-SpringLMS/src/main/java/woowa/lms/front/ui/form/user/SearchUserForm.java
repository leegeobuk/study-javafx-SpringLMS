package woowa.lms.front.ui.form.user;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.form.SearchFormFoolProof;
import woowa.lms.front.ui.form.AbstractForm;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.SEARCH_USER;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.NOT_EMPTY;

public class SearchUserForm extends AbstractForm {

    private Label idLabel;
    private Label nameLabel;
    private Label contactLabel;
    private InputField idInputField = InputField.of(TEXT, NOT_EMPTY, "Id");
    private InputField nameInputField = InputField.of(TEXT, NOT_EMPTY, "Name");
    private InputField contactInputField = InputField.of(TEXT, NOT_EMPTY, "Contact");

    private static final double WIDTH = 430;
    private static final double HEIGHT = 360;
    private static final String TITLE = "Search User Form";
    private static final String HEADER = "Search User";
    private static final SearchUserForm FORM = new SearchUserForm();

    private SearchUserForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        inputFields = List.of(idInputField, nameInputField, contactInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static SearchUserForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        idLabel = LabelBuilder.getFormLabel("Id");
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SEARCH_USER);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        formPane.addRow(0, idLabel, idInputField.toTextField());
        formPane.addRow(1, nameLabel, nameInputField.toTextField());
        formPane.addRow(2, contactLabel, contactInputField.toTextField());
        formPane.add(errorLabel, 0, 3, 2, 2);
        formPane.setHgap(WIDTH * 0.1);
        formPane.setVgap(HEIGHT * 0.02);
        formPane.setAlignment(Pos.CENTER);
        getFields().forEach(textField -> textField.setPrefWidth(WIDTH * 0.45));
        super.setUpPage();
    }

    @Override
    public void setFoolProof() {
        formFoolProof = SearchFormFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        inputFields.forEach(inputField -> inputField.setOnKeyReleased(formFoolProof));
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(UserTable.getTable());
    }
}
