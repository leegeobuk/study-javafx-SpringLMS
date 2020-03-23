package woowa.lms.front.component.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import lombok.Builder;
import lombok.Setter;
import woowa.lms.front.component.font.CustomFont;
import woowa.lms.front.component.font.FontBuilder;

import static woowa.lms.front.component.font.FontBuilder.*;

@Builder
@Setter
public class LabelBuilder implements CustomLabel {

    public static final LabelBuilder DEFAULT_LABEL = LabelBuilder.builder().build();
    private static LabelBuilder pageHeader =
        LabelBuilder.builder().textFill("white").font(PAGE_FONT).build();
    private static LabelBuilder dialogLabel = LabelBuilder.builder().build();

    @Builder.Default
    private String text = "";

    @Builder.Default
    private String textFill = "black";

    @Builder.Default
    private CustomFont font = DEFAULT_FONT;

    public static LabelBuilder getPageLabel(String text) {
        pageHeader.setText(text);
        return pageHeader;
    }

    public static LabelBuilder getDialogHeader(String text) {
        FontBuilder dialogFont = getDialogFont(20);
        dialogLabel.setFont(dialogFont);
        dialogLabel.setText(text);
        return dialogLabel;
    }

    public static LabelBuilder getDialogContent(String text) {
        FontBuilder dialogFont = getDialogFont(15);
        dialogLabel.setFont(dialogFont);
        dialogLabel.setText(text);
        return dialogLabel;
    }

    @Override
    public Label toLabel() {
        Label label = new Label(text);
        label.setTextFill(Paint.valueOf(textFill));
        label.setFont(font.toFont());
        return label;
    }
}