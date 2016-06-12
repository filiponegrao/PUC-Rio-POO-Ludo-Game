package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;

import javax.imageio.ImageIO;

import controller.LudoController;
import model.PinModel;
import model.Team;


public class PinView
{
	public static void drawPins(PinModel[] p, Graphics2D g, Dimension pinDimension)
	{
		for (int i = 0; i < p.length; i++)
		{
			int posx = 0;
			int posy = 0;
			
			int diam = pinDimension.width - 10;
			
			Team barrier = LudoController.sharedInstance.getBarrierOn(p[i].getX(), p[i].getY());
			
			Team[] twoPins = LudoController.sharedInstance.getTwoPins(p[i].getX(), p[i].getY());
			
			if(barrier != null)
			{
				posx = pinDimension.width * p[i].getX() + 5;
				posy = pinDimension.height * p[i].getY() + 5;
				
				drawBarrier(g,posx,posy,diam,diam, p[i].getTeam());
			}
			else if(twoPins != null)
			{
				posx = pinDimension.width * p[i].getX() + 5;
				posy = pinDimension.height * p[i].getY() + 5;
				
				drawTwoPins(g,posx,posy,diam,diam, twoPins[0], twoPins[1]);
			}
			else
			{				
				posx = pinDimension.width * p[i].getX() + 5;
				posy = pinDimension.height * p[i].getY() + 5;				
				
				drawPin(g,posx,posy,diam,diam, p[i].getTeam());
			}
		}
	}
	
	public static void drawPin(Graphics2D g, int posx, int posy, int width, int height, Team t)
	{
		Ellipse2D e = new Ellipse2D.Double(posx, posy, width, width);
		
		g.setStroke(new BasicStroke(3.0f));

		g.setPaint(t.getColor());
		
		g.fill(e);
		
		if(t.getName().equals("Azul"))
		{
			g.setPaint(MyColors.blueBoader);
			g.draw(e);
		}
		else if(t.getName().equals("Vermelho"))
		{
			g.setPaint(MyColors.redBoader);
			g.draw(e);
		}
		else if(t.getName().equals("Verde"))
		{
			g.setPaint(MyColors.greenBoader);
			g.draw(e);
		}
		else if(t.getName().equals("Amarelo"))
		{
			g.setPaint(MyColors.yellowBoader);
			g.draw(e);
		}		
	}

	public static void drawBarrier(Graphics2D g, int posx, int posy, int width, int height, Team t)
	{
		Ellipse2D e1 = new Ellipse2D.Double(posx - width/3, posy - width/3, width, width);
		Ellipse2D e2 = new Ellipse2D.Double(posx + width/3, posy + width/3, width, width);

		g.setStroke(new BasicStroke(3.0f));

		g.setPaint(t.getColor());
		g.fill(e1);
		
		if(t.getName().equals("Azul"))
		{
			g.setPaint(MyColors.blueBoader);
			g.draw(e1);
		}
		else if(t.getName().equals("Vermelho"))
		{
			g.setPaint(MyColors.redBoader);
			g.draw(e1);
		}
		else if(t.getName().equals("Verde"))
		{
			g.setPaint(MyColors.greenBoader);
			g.draw(e1);
		}
		else if(t.getName().equals("Amarelo"))
		{
			g.setPaint(MyColors.yellowBoader);
			g.draw(e1);
		}
		
		g.setPaint(t.getColor());
		g.fill(e2);
		
		if(t.getName().equals("Azul"))
		{
			g.setPaint(MyColors.blueBoader);
			g.draw(e2);
		}
		else if(t.getName().equals("Vermelho"))
		{
			g.setPaint(MyColors.redBoader);
			g.draw(e2);
		}
		else if(t.getName().equals("Verde"))
		{
			g.setPaint(MyColors.greenBoader);
			g.draw(e2);
		}
		else if(t.getName().equals("Amarelo"))
		{
			g.setPaint(MyColors.yellowBoader);
			g.draw(e2);
		}
	}
	
	public static void drawTwoPins(Graphics2D g, int posx, int posy, int width, int height, Team t1, Team t2)
	{
		Ellipse2D e1 = new Ellipse2D.Double(posx - width/3, posy - width/3, width, width);
		Ellipse2D e2 = new Ellipse2D.Double(posx + width/3, posy + width/3, width, width);

		g.setStroke(new BasicStroke(3.0f));

		g.setPaint(t1.getColor());
		g.fill(e1);
		
		if(t1.getName().equals("Azul"))
		{
			g.setPaint(MyColors.blueBoader);
			g.draw(e1);
		}
		else if(t1.getName().equals("Vermelho"))
		{
			g.setPaint(MyColors.redBoader);
			g.draw(e1);
		}
		else if(t1.getName().equals("Verde"))
		{
			g.setPaint(MyColors.greenBoader);
			g.draw(e1);
		}
		else if(t1.getName().equals("Amarelo"))
		{
			g.setPaint(MyColors.yellowBoader);
			g.draw(e1);
		}
		
		g.setPaint(t2.getColor());
		g.fill(e2);
		
		if(t2.getName().equals("Azul"))
		{
			g.setPaint(MyColors.blueBoader);
			g.draw(e2);
		}
		else if(t2.getName().equals("Vermelho"))
		{
			g.setPaint(MyColors.redBoader);
			g.draw(e2);
		}
		else if(t2.getName().equals("Verde"))
		{
			g.setPaint(MyColors.greenBoader);
			g.draw(e2);
		}
		else if(t2.getName().equals("Amarelo"))
		{
			g.setPaint(MyColors.yellowBoader);
			g.draw(e2);
		}
	}
}
