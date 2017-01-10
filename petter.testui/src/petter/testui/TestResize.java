package petter.testui;



import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SWTBotJunit4ClassRunner.class)
public class TestResize {
	private static SWTBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTBot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SWTBotShellPetter shell = new SWTBotShellPetter(bot.shell("TestRCP").widget);
		shell.activate();
		shell.resize(1024, 800);
		animateWindow(shell);
	}

	private void animateWindow(SWTBotShellPetter shell) {
		try {
			for (int i = 1; i < 600; i++) {
				shell.resize(1024 - i, 800);

				Thread.sleep(10);

			}
			for (int i = 600; i >0; i--) {
				shell.resize(1024 - i, 800);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
