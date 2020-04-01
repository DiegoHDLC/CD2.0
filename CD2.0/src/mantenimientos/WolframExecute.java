package mantenimientos;

import javax.swing.ImageIcon;
import com.wolfram.jlink.*;

import classDAO.EspecialidadesDAO;


public class WolframExecute {
	public static ImageIcon barchar(String param1,String param2) {
		ImageIcon imagen=new ImageIcon();
		
		
		
		KernelLink ml = null;
	       String[] arg={"-linkmode", "launch", "-linkname", "C:\\Program Files\\Wolfram Research\\Mathematica\\12.0\\MathKernel"};
	        try {
	            ml = MathLinkFactory.createKernelLink(arg);
	        } catch (MathLinkException e3) {
	            System.out.println("Fatal error opening link: " + e3.getMessage());
	            return null;
	        }
	        

	        try {
	           
	            ml.discardAnswer();
	            ml.evaluate("<<MyPackage.m");
	            ml.discardAnswer();


	            
	            MathCanvas nuevo = new MathCanvas();
	            nuevo.setLink(ml);
	            System.out.println("BarChart[{  "+param1+"  },ChartLabels ->{"+param2+"}]");
	            nuevo.setMathCommand("BarChart[{  "+param1+"  },ChartLabels ->{"+param2+"},BarOrigin -> Left]");
	            
	            imagen= new ImageIcon(nuevo.getImage());
	            

	        } catch (MathLinkException e3) {
	            System.out.println("MathLinkException occurred: " + e3.getMessage());
	        } finally {
	            ml.close();
	            
	        }
	        return imagen;
		}
		
	
	public static ImageIcon grafo(String param1,String param2,int transformar[][],int max) {
		KernelLink ml = null;
	     String[] arg={"-linkmode", "launch", "-linkname", "C:\\Program Files\\Wolfram Research\\Mathematica\\12.0\\MathKernel"};
	      try {
	          ml = MathLinkFactory.createKernelLink(arg);
	      } catch (MathLinkException e2) {
	          System.out.println("Fatal error opening link: " + e2.getMessage());
	          return null;
	      }
	      

	      try {
	          // Get rid of the initial InputNamePacket the kernel will send
	          // when it is launched.
	          ml.discardAnswer();

	          ml.evaluate("<<MyPackage.m");
	          ml.discardAnswer();
	          MathCanvas nuevo = new MathCanvas();
	          nuevo.setLink(ml);
	          
	          int i=0;
	          String places="";
	          String especialidad=EspecialidadesDAO.getEspecialidad(transformar[i][0]);;
	          places=transformar[i][1]+"-> Placed[{\" "+especialidad+" \"},{Center}] ";
	          i++;
	          while(i<max) {
	        	  
	        	  
	        	  especialidad=EspecialidadesDAO.getEspecialidad(transformar[i][0]);
	        	  places=places+","+ transformar[i][1]+"-> Placed[{\" "+especialidad+" \"},{Center}] ";
	        	  i++;
	          }
	          
	          int k=0;
	          String centers="";
	          centers="Center,";
	          k++;
	          while(k<i) {
	        	  centers=centers+","+"Center";
	        	  k++;
	          }
	          
	          
	          nuevo.setMathCommand(
	          		"Graph[{"+param1+"},{"+param2+"},ImageSize->Large,VertexStyle->Orange,EdgeStyle->Red, "
	          		+ "VertexSize -> Medium,"
	          		+ "VertexLabels -> { "+ places +"}]  ");
	          ImageIcon nuevo2 = new ImageIcon(nuevo.getImage());
	          ml.close();
	          return nuevo2;
	          
	          
	         

	      } catch (MathLinkException e3) {
	          System.out.println("MathLinkException occurred: " + e3.getMessage());
	      } finally {
	          ml.close();
	          
	      }
		return null;
	      
	}
	public static ImageIcon grafocom(String param1,String param2,int transformar[][],int max) {
		KernelLink ml = null;
	     String[] arg={"-linkmode", "launch", "-linkname", "C:\\Program Files\\Wolfram Research\\Mathematica\\12.0\\MathKernel"};
	      try {
	          ml = MathLinkFactory.createKernelLink(arg);
	      } catch (MathLinkException e2) {
	          System.out.println("Fatal error opening link: " + e2.getMessage());
	          return null;
	      }
	      

	      try {
	          // Get rid of the initial InputNamePacket the kernel will send
	          // when it is launched.
	          ml.discardAnswer();

	          ml.evaluate("<<MyPackage.m");
	          ml.discardAnswer();
	          MathCanvas nuevo = new MathCanvas();
	          nuevo.setLink(ml);
	          
	          int i=0;
	          String places="";
	          String especialidad=EspecialidadesDAO.getEspecialidad(transformar[i][0]);;
	          places=transformar[i][1]+"-> Placed[{\" "+especialidad+" \"},{Center}] ";
	          i++;
	          while(i<max) {
	        	  
	        	  
	        	  especialidad=EspecialidadesDAO.getEspecialidad(transformar[i][0]);
	        	  places=places+","+ transformar[i][1]+"-> Placed[{\" "+especialidad+" \"},{Center}] ";
	        	  i++;
	          }
	          
	          int k=0;
	          String centers="";
	          centers="Center,";
	          k++;
	          while(k<i) {
	        	  centers=centers+","+"Center";
	        	  k++;
	          }
	          
	          
	          nuevo.setMathCommand(
	          		"CommunityGraphPlot[{"+param2+"},ImageSize->Large,VertexStyle->Orange,EdgeStyle->Red, "
	          		+ "VertexSize -> Medium,"
	          		+ "VertexLabels -> { "+ places +"}]  ");
	          ImageIcon nuevo2 = new ImageIcon(nuevo.getImage());
	          ml.close();
	          return nuevo2;
	          
	          
	         

	      } catch (MathLinkException e3) {
	          System.out.println("MathLinkException occurred: " + e3.getMessage());
	      } finally {
	          ml.close();
	          
	      }
		return null;
	      
	}
}
