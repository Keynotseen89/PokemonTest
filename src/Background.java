
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel

{
	private static final long serialVersionUID = 8534363180966005148L;

	public Background(LayoutManager l) {
		super.setLayout(l);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image image = new ImageIcon("pokemonImage\\pokedex_image.png").getImage();
		int basX = 0;
		int basY = 0;

		int bitX = getSize().width; // 320; //getSize().width;
		int bitY = getSize().height;// 480; //getSize().height;

		g.drawImage(image, basX, basY, bitX, bitY, null);

		Image image2 = new ImageIcon("pokemonImage\\Pokedex_Logo.png").getImage();

		g.drawImage(image2, basX, basY, 330, 125, null);

	}

}
