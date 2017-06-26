package Iview;

import java.awt.Frame;

public interface IView {

	public void frame() throws Exception;
	
	public int getFrameWidth();

	public int getFrameHeight();

	public Frame getFrame();

	public void setFrameWidth(int i);

	public void setFrameHeight(int i);
	
	public void win() throws InterruptedException;

	public void lose() throws InterruptedException;

}
