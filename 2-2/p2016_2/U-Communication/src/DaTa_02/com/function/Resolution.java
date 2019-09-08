package DaTa_02.com.function;

import java.awt.Toolkit;

public class Resolution {
	public static final int x;
	public static final int y;
	
	static
	{
		x = Toolkit.getDefaultToolkit().getScreenSize().width;
		y = Toolkit.getDefaultToolkit().getScreenSize().height;
	}
}
