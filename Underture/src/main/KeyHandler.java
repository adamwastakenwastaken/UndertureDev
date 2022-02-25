package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	 public boolean upPressed, downPressed, leftPressed, rightPressed, upkeyrealesed, downkeyrealesed, leftkeyrealesed, rightkeyrealesed;

	    @Override
	    public void keyTyped(KeyEvent e) {
	        //UNUSED
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	        int code = e.getKeyCode();

	        if(code == KeyEvent.VK_W){
	            upPressed = true;
	            upkeyrealesed = false;
	        }

	        if(code == KeyEvent.VK_A){
	            leftPressed = true;
	            leftkeyrealesed = false;
	        }

	        if(code == KeyEvent.VK_S){
	            downPressed = true;
	            downkeyrealesed = false;
	        }

	        if(code == KeyEvent.VK_D){
	            rightPressed = true;
	            rightkeyrealesed = false;
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	        int code = e.getKeyCode();

	        if(code == KeyEvent.VK_W){
	            upPressed = false;
	            upkeyrealesed = true;
	        }

	        if(code == KeyEvent.VK_A){
	            leftPressed = false;
	            leftkeyrealesed = true;
	        }

	        if(code == KeyEvent.VK_S){
	            downPressed = false;
	            downkeyrealesed = true;
	        }

	        if(code == KeyEvent.VK_D){
	            rightPressed = false;
	            rightkeyrealesed = true;
	        }
	    }
}
