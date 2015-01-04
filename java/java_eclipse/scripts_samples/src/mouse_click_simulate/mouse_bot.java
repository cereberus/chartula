package mouse_click_simulate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class mouse_bot {

	public static void click(int x, int y) throws AWTException{
	    Robot bot = new Robot();
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void main(String[] args) throws AWTException {
		click(1300, 20);
	}
	
	
}
