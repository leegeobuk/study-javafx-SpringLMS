package woowa.lms.front.controller.account;

import woowa.lms.front.ui.dialog.error.ErrorDialog;
import woowa.lms.front.ui.dialog.prompt.SignOutDialog;
import woowa.lms.front.ui.dialog.success.SuccessDialog;

public class AccountDialogController {

    private static final AccountDialogController CONTROLLER = new AccountDialogController();

    public static AccountDialogController getController() {
        return CONTROLLER;
    }

    public void showSignUpSuccessfulDialog() {
        String title = "Sign Up Successful Dialog";
        String header = "You are successfully signed up!";
        String content = "Welcome to Woowa library!";
        SuccessDialog.getSuccessDialog(title, header, content).show();
    }

    public void showSignUpErrorDialog() {
        String title = "Sign Up Error Dialog";
        String header = "ID already exists!";
        String content = "Please try again :(";
        ErrorDialog.getErrorDialog(title, header, content).show();
    }

    public void showSignInErrorDialog(String errorMessage) {
        String title = "Sign In Error Dialog";
        String content = "Please try again :(";
        ErrorDialog.getErrorDialog(title, errorMessage, content).show();
    }

    public void showEditUserErrorDialog(String errorMessage) {
        String title = "Edit User Error Dialog";
        String content = "Please try again :(";
        ErrorDialog.getErrorDialog(title, errorMessage, content).show();
    }

    public void showSignOutDialog() {
        SignOutDialog.getDialog().show();
    }
}
