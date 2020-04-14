import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	protected static World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 1000;
	
	public void run(){	
		setUpWorld();
		runWorld();
		
		System.out.print(theWorld.getCreatureList().get(0));
	
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(100,100);
		
		theWorld.getCreatureList().add(new healthy(52,new Location(10,10), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new healthy(52,new Location(10,11), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new healthy(52,new Location(11,12), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new healthy(52,new Location(11,13), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new healthy(52,new Location(12,14), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new healthy(52,new Location(12,15), Color.GREEN, theWorld, 0));
		theWorld.getCreatureList().add(new aysmptomatic(52,new Location(11,15), Color.BLUE, theWorld, 1));

		
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		for(int i=0; i<25;i++){
			theWorld.letTimePass();
			pause(500);
			drawWorld();
		}
	}	
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
