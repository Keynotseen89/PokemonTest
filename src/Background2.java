import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.LayoutManager;

public class Background2 extends JPanel

{
	private static final long serialVersionUID = 8534363180966005148L;

	public Background2(LayoutManager l2) {
		super.setLayout(l2);
	}// end of Background code

	protected void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Image image = new ImageIcon("pokemonImage\\Pokedex.png").getImage();

		int basX = 0;
		int basY = 0;

		int bitX = getSize().width;
		int bitY = getSize().height;

		g2.drawImage(image, basX, basY, bitX, bitY, null);

	}// end of paint Component code
}
