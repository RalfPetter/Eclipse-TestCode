 
package petter.testrcp;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import javax.annotation.PreDestroy;

public class TestView {
	FormToolkit toolkit;
	@Inject
	public TestView() {	
	}
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout());
		toolkit = new FormToolkit(parent.getDisplay());
		ScrolledForm form = toolkit.createScrolledForm(parent);
		form.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		form.setText("Hello, Eclipse Forms");
		toolkit.decorateFormHeading(form.getForm());
		
	}
	@PreDestroy
	public void preDestroy() {
		toolkit.dispose();
	}
}