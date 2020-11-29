
    import java.awt.Color;
	import java.awt.image.BufferedImage;
    import java.io.File;
	import java.io.IOException;
    import javax.imageio.ImageIO;

	public class Image {
		
      //lire une image pixel par pixel

		public static void main(String[] args) {
			//chemin vers l'image qu'on veut lire
		File img=new File("E:\\imgOri\\Koala.jpg");
		BufferedImage originale =null;
		try {
			originale=ImageIO.read(img);
			//pour l'image resultante
			BufferedImage imgresult=new BufferedImage (originale.getWidth(),originale.getHeight(),BufferedImage.TYPE_INT_ARGB);
			for (int i = 0; i < originale.getWidth(); i++) {
			  for (int j = 0; j < originale.getHeight(); j++) {
			     //obtenir RGB en pixel
				  Color c= new Color (originale.getRGB(i,j));
				  int r= c.getRed();
				  int g=c.getGreen();
				  int b=c.getBlue();
				  int a= c.getAlpha();
				  System.out.println(r+" "+g+" "+b);
				  //convertir au niveau de gris 
				  int ng= (r+g+b)/3;
				  //creer couleur  niveau de gris
				  Color gcol=new Color(ng,ng,ng,a);
				  imgresult.setRGB(i, j, gcol.getRGB());
				  
				  
				  
				
			}
			  //pour sauter la ligne apres l'affichage de chaque ligne de pixels
				System.out.println();
			}
			//afficher l'img resultante ds le meme endroit ou se trouve l'img originale
			ImageIO.write(imgresult, "jpg",new File( "E:\\imgOri\\imggris.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}

	}



