package br.com.ajs.macro.ragnarok;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MacroMouse extends JFrame
implements MouseListener, MouseMotionListener {

	private final int _250_MILESIMOS = 250; 
	private final int MEIO_SEGUNDO = 500;
	private final int UM_SEGUNDO = 1000;
	private final int TRES_SEGUNDO = 2000;
	private final int CINCO_SEGUNDOS = 5000;
	
	private final int TOTAL_PESCA = 600;
	private final int UM_MINUTO = UM_SEGUNDO * 60;
	private final int _50_SEGUNDOS = UM_SEGUNDO * 50;
	private final int _30_SEGUNDOS = UM_SEGUNDO * 30;
	
	public static void main(String[] args) throws AWTException {

		Robot r = new Robot();
		MacroMouse macroMouse = new MacroMouse();
//		 new MacroMouse().start(); // obter coordenatas
		macroMouse.clicarTela("APP BLUESTACKS", r, 1154, 881);
	
	macroMouse.pescar(r, macroMouse.TOTAL_PESCA, 710, 615,macroMouse.UM_MINUTO);
		
		// macroMouse.abrirPeixeGradeCinco(r, macroMouse.TOTAL_PESCA, 711,613,macroMouse.TRES_SEGUNDO); 
		 
		System.out.println("FIM GERAL - COM SUCESSO");
		
		
	}
	

	
	private void pescar(Robot robot,int qtd_pescaria, int coord_X_Linha, int coord_Y_Coluna, int espera){
		
		for(int i=0;i<qtd_pescaria;i++){
			this.clicarTela("pescaria it: "+i+" ", robot, coord_X_Linha, coord_Y_Coluna, espera);
		}
		
	}
	
	private void abrirPeixeGradeCinco(Robot robot,int qtd_pescaria, int coord_X_Linha, int coord_Y_Coluna, int espera){
		for(int i=0;i<qtd_pescaria;i++){
			this.clicarTela("peixe aberto it: "+i+" ", robot, coord_X_Linha, coord_Y_Coluna, espera);
		}
	}

	private void clicarTela(String msg, Robot robot, int coord_X_Linha, int coord_Y_Coluna, int espera){
		
		clicarTela(msg, robot, coord_X_Linha, coord_Y_Coluna);
		System.out.println("INI - TEMPO ADD: "+(espera/1000)+" SEGUNDOS");
		robot.delay(espera);
		System.out.println("FIM - TEMPO ADD");
		
	}
	private void clicarTela(String msg, Robot robot, int coord_X_Linha, int coord_Y_Coluna){
		System.out.println("INI - "+msg);
		robot.delay(_250_MILESIMOS);
		robot.mouseMove(coord_X_Linha, coord_Y_Coluna);
		robot.delay(_250_MILESIMOS);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(_250_MILESIMOS);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		System.out.println("FIM - "+msg);
		
	}
	
	private void obterCoordenataMouseTela(Robot robot){
		
		//System.out.println(robot.m);
	}

	
	      JLabel mousePosition;
	      @Override
	      public void mouseClicked(MouseEvent e) {
	          mousePosition.setText("Mouse clicado na coordenada : ["+e.getX()+","+e.getY()+"]");
	           System.out.println("Mouse clicado na coordenada : ["+e.getX()+","+e.getY()+"]");
	      }
	   
	      @Override
	      public void mouseEntered(MouseEvent e) {
	          mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");
	           
	      }
	   
	      @Override
	      public void mouseExited(MouseEvent e) {
	          mousePosition.setText("O Mouse está fora da janela de acesso");
	           
	      }
	   
	      @Override
	      public void mousePressed(MouseEvent e) {
	          mousePosition.setText("Mouse pressionado nas coordenadas : ["+e.getX()+","+e.getY()+"]");
	           
	      }
	   
	      @Override
	      public void mouseReleased(MouseEvent e) {
	          mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");
	           
	      }
	   
	      @Override
	      public void mouseDragged(MouseEvent e) {
	          mousePosition.setText("Mouse arrastado nas coordenadas : ["+e.getX()+","+e.getY()+"]");
	           
	      }
	   
	      @Override
	      public void mouseMoved(MouseEvent e) {
	          mousePosition.setText("Mouse movido para as coordenadas : ["+e.getX()+","+e.getY()+"]");
	           
	      }
	   
//	      public static void main(String args[])
//	      {
//	          new MacroMouse().start();
//	           
//	      }
	      public void start()
	      {
	          mousePosition=new JLabel();
	           addMouseListener( this );        // listens for own mouse and
	            addMouseMotionListener( this );  // mouse-motion events
	            setLayout(new FlowLayout(1));
	            add(mousePosition);
	            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	            setSize(size );
	            setUndecorated(true);
	            setVisible( true );
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	      }
}
