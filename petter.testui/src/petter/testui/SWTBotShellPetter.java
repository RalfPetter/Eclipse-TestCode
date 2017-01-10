package petter.testui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.BoolResult;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

public class SWTBotShellPetter extends SWTBotShell {

	public SWTBotShellPetter(Shell shell) throws WidgetNotFoundException {
		super(shell);
	}

	public String resize(int x, int y) {
		new SWTBot().waitUntil(new DefaultCondition() {
			public boolean test() {
				return syncExec(new BoolResult() {
					public Boolean run() {
						widget.setSize(x,y);
						if(widget.getSize().x==x||widget.getSize().y==y)
							return true;
						else
							return false;
					}
				});
			}
			public String getFailureMessage() {
				return "Timed out waiting for the shell to get maximized";
			}
		});
		return "ok";
	}
}
