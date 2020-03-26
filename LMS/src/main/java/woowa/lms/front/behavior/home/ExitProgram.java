package woowa.lms.front.behavior.home;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExitProgram implements Behavior {

    private static final ExitProgram CLICK_EXIT = new ExitProgram();

    public static ExitProgram getInstance() {
        return CLICK_EXIT;
    }

    @Override
    public void handle(ActionEvent event) {
        HomeController.getController().showExitDialog();
    }
}
