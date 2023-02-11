package jiratask.PageSteps;


import jiratask.elements.TaskElement;

import static jiratask.elements.TaskElement.activeSprint;
import static jiratask.elements.TaskElement.taskName;


public class TaskPage {

    public void choiceTask() {
        activeSprint.click();
        taskName.click();
    }
    public String getStatus() {
        return TaskElement.status.getText();
    }

    public String getVersion() {
        return TaskElement.version.getText();
    }

}