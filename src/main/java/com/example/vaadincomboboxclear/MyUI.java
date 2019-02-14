package com.example.vaadincomboboxclear;

import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {
	
	private static final long serialVersionUID = 1L;

	@Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        layout.addComponent(new Label("Breaking Vaadin ComboBox with: " + 
        		com.vaadin.shared.Version.getFullVersion()));
        Label issueLabel = new Label("Demonstrate ComboBox problem at <a href=\"https://github.com/vaadin/framework/issues/1122\">Vaadin ComboBox default value is not cleared when setting with selectByText</a><br>");
        issueLabel.setContentMode(ContentMode.HTML);
        layout.addComponent(issueLabel);
        
        String comboBoxValuesString = "First Entry,Second Entry,Third entry, Fourth entry";
        List<String> comboBoxValues = Arrays.asList((comboBoxValuesString).split(","));
        
	    // Create new ComboBox and pre-select the third entry
        ComboBox<String> demobox = new ComboBox<>();
        demobox.setItems(comboBoxValues);
        demobox.setEmptySelectionAllowed(false);
        // demobox.setTextInputAllowed(false); <-- this also fixes the issue
        demobox.setTextInputAllowed(true);
        demobox.setId("testbox");
        demobox.setValue("Third Entry");
        
        layout.addComponent(demobox);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }
    
}
