/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.tests;

import java.util.LinkedList;
import java.util.Random;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.terminal.gwt.client.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Root.LegacyWindow;
import com.vaadin.ui.Select;

public class UsingObjectsInSelect extends
        com.vaadin.Application.LegacyApplication implements ValueChangeListener {

    private final Select select = new Select();
    private final Label selectedTask = new Label("Selected task",
            ContentMode.XHTML);

    public LinkedList<?> exampleTasks = new LinkedList<Object>();

    public static Random random = new Random(1);

    @Override
    public void init() {
        final LegacyWindow main = new LegacyWindow("Select demo");
        setMainWindow(main);

        final Panel panel = new Panel("Select demo");
        panel.addComponent(select);
        final Panel panel2 = new Panel("Selection");
        panel2.addComponent(selectedTask);

        select.setCaption("Select component");
        select.addListener(this);
        select.setImmediate(true);

        main.addComponent(panel);
        main.addComponent(panel2);

        createExampleTasks();
    }

    public void createExampleTasks() {
        final String[] assignedTo = new String[] { "John", "Mary", "Joe",
                "Sarah", "Jeff", "Jane", "Peter", "Marc", "Josie", "Linus" };
        final String[] type = new String[] { "Enhancement", "Bugfix",
                "Testing", "Task" };
        for (int j = 0; j < 100; j++) {
            final Task task = new Task(
                    type[(int) (random.nextDouble() * (type.length - 1))],
                    assignedTo[(int) (random.nextDouble() * (assignedTo.length - 1))],
                    random.nextInt(100));
            select.addItem(task);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Task task = (Task) select.getValue();
        selectedTask.setValue("<b>Type:</b> " + task.getType()
                + "<br /><b>Assigned to:</b> " + task.getAssignedTo()
                + "<br /><b>Estimated hours: </b>" + task.getEstimatedHours());
    }

    /**
     * Sample class which is bound to Vaadin components
     * 
     */
    public class Task {

        private String type;
        private String assignedTo;
        private int estimatedHours;

        public Task(String type, String assignedTo, int estimatedHours) {
            this.type = type;
            this.assignedTo = assignedTo;
            this.estimatedHours = estimatedHours;
        }

        @Override
        public String toString() {
            return type + ", " + assignedTo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAssignedTo() {
            return assignedTo;
        }

        public void setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
        }

        public float getEstimatedHours() {
            return estimatedHours;
        }

        public void setEstimatedHours(int estimatedHours) {
            this.estimatedHours = estimatedHours;
        }
    }

}
