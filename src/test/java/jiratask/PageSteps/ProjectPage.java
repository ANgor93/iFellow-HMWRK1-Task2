package jiratask.PageSteps;

import com.codeborne.selenide.Condition;

import static jiratask.elements.ProjectElement.*;

public class ProjectPage {

    public void openTasksList() {
        taskMenu.click();
        switchFilter.click();
        butnAllTask.click();
    }
    public static int getNumberOfTasks() {
        return Integer.parseInt(numberOfTasks.getText().split(" ")[2]);
    }

    public void numbersOfTaskPageProject() {
        numberOfTasks.shouldBe(Condition.visible);
    }
}
