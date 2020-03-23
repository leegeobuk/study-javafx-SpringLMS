package woowa.lms.front.foolproof;

import lombok.Getter;
import woowa.lms.front.foolproof.signup.*;

public enum FoolProofType {

    ID_FIELD(IdFieldFoolProof.getInstance()),
    PW_FIELD(PasswordFieldFoolProof.getInstance()),
    CONFIRM_PW_FIELD(ConfirmPasswordFieldFoolProof.getInstance()),
    NAME_FIELD(NameFieldFoolProof.getInstance()),
    CONTACT_FIELD(ContactFieldFoolProof.getInstance());

    @Getter
    private FieldFoolProof foolProof;

    FoolProofType(FieldFoolProof foolProof) {
        this.foolProof = foolProof;
    }
}