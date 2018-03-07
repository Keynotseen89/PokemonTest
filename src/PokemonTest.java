
//Folder/Project Name: PokemonTest
//Programmer Name: Quinatzin Sintora
//Class Name : PokemonTest
//Date: 01/01/2015
/* This Application is used to log into a Pokedex menu then 
 * search up all 150 Pokemon with information of the type, search button 
 * or by going down the list, Then Having Pokemons Weight and Height in the pokemdex.
 * If possible, well make the pokedex speak. 
 */

import javax.swing.*;

import java.awt.BorderLayout; //needed for BorderLayout
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints; //needed for GridBagConstraint
import java.awt.GridBagLayout; //needed for GridBagLayout
import java.awt.Insets; //needed for Gridbag for insets

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*; //needed for ActionListener

public class PokemonTest extends JFrame implements ActionListener

{
	private static final long serialVersionUID = 8534363180966005148L;
	JPanel mainPanel = new JPanel(new GridBagLayout()); // mainPanel for Gui With GridBag
	JPanel centerPanel = new JPanel(new GridBagLayout()); // centerPanel for GUI with GriBag
	JPanel inputPanel = new JPanel(new GridBagLayout()); // inputPanel for GUI with GriBag
	JPanel panel = new JPanel(new GridBagLayout()); // panel for GUI with GridBag
	JPanel rightPanel = new JPanel(new GridBagLayout());
	JPanel inputPanel2 = new JPanel(new GridBagLayout());

	JLabel typeLabel = new JLabel("Type"); // Type Label for Pokemon
	JLabel typeLabelChange = new JLabel("Grass/Poision"); // Change of Type Label
	JLabel heightLabel = new JLabel("Height"); // Height of the Pokemon
	JLabel heightLabelChange = new JLabel("2'40        0.7m"); // Change Height of Pokemon
	JLabel weightLabel = new JLabel("Weight"); // Weight for the Pokemon
	JLabel weightLabelChange = new JLabel("15.2lbs    6.9kg"); // Change Weight of Pokemon
	JLabel selectedPokemonLabel = new JLabel("001-Bulbasaur"); // Displays Pokemon name and Number

	JTextField nameTxt = new JTextField(20);
	static JTextField userNameTextField = new JTextField(8); // UserName text Field
	static JTextField passwordTextField = new JTextField(8); // Password textField

	static JButton loginButton = new JButton("Login"); // Login Button
	static JButton exitButton = new JButton("Exit"); // Exit Button

	static JLabel programmerNameLabel = new JLabel("programmed by:"); // Label Name for Programmer
	static JLabel programmerNameLabel2 = new JLabel("Quinatzin Sintora"); // Programmer name Label

	JButton searchButton = new JButton("Search"); // Returns to Searches for Pokemon

	static Font taFont = new Font("Courier", Font.BOLD, 15); // Set the size of the font
	static JFrame f = new JFrame();
	static JFrame pokedexOpen = new JFrame();

	static Background2 background2 = new Background2(new BorderLayout()); // GUI with PokedexBackground

	JTextArea informationTextArea = new JTextArea(9, 10); // Information of Pokemon
	JScrollPane outputScrollPane = new JScrollPane(informationTextArea); // ScrollList for Pokemon

	JTextArea searchTextArea = new JTextArea(1, 8); // to Search for Pokemon
	JScrollPane searchScrollPanel = new JScrollPane(searchTextArea); // Scroll for searching for Pokemons

	JScrollPane pokemonScrollList;
	boolean foundPokemonBoolean = false;

	private JList<String> pokemonList; // JList for PokemonList
	private JLabel pokemonImage; // JLabe to add the PokemonImage

	// String Array for pokemonNameList
	private String[] pokemonNameList = { "001-Bulbasaur", "002-Ivysaur", "003-Venusare", "004-Charmander",
			"005-Charmeleon", "006-Charizard", "007-Squirtle", "008-Wartortle", "009-Blastoise", "010-Caterpie",
			"011-Metapod", "012-Butterfree", "013-Weedle", "014-Kakuna", "015-Beedrill", "016-Pidgey", "017-Pidgeotto",
			"018-Pidgeot", "019-Rattata", "020-Raticate", "021-Spearow", "022-Fearow", "023-Ekans", "024-Arbok",
			"025-Pikachu", "026-Raichu", "027-Sandshrew", "028-Sandslash", "029-Nidoran", "030-Nidorina",
			"031-Nidoqueen", "032-Nidoran", "033-Nidorino", "034-Nidoking", "035-Clefairy", "036-Clefable",
			"037-Vulpix", "038-Ninetales", "039-JigglyPuff", "040-Wigglypuff", "041-Zubat", "042-Golbat", "043-Oddish",
			"044-Gloom", "045-Vileplume", "046-Paras", "047-Parasect", "048-Venonat", "049-Venomoth", "050-Diglett",
			"051-Dugtrio", "052-Meowth", "053-Persina", "054-Psyduck", "055-Golduck", "056-Mankey", "057-Primeape",
			"058-Growlithe", "059-Arcanine", "060-Poliwag", "061-Poliwhirl", "062-Poliwarth", "063-Abra", "064-Kadabra",
			"065-Alakazam", "066-Machop", "067-Machoke", "068-Machamp", "069-Bellsprout", "070-Weepinbell",
			"071-Victreebel", "072-Tentacool", "073-Tentacruel", "074-Geodude", "075-Graveler", "076-Golem",
			"077-Ponyta", "078-Rapidash", "079-Slowpoke", "080-Slowbro", "081-Magnemite", "082-Magneton",
			"083-Farfetch'd", "084-Doduo", "085-Dodrio", "086-Seel", "087-Dewgong", "088-Grimmer", "089-Muk",
			"090-Shellder", "091-Clovster", "092-Gastly", "093-Hanter", "094-Gengar", "095-Onix", "096-Drowzee",
			"097-Hypno", "098-Krabby", "099-Kingler", "100-Voltorb", "101-Electrode", "102-Exeggcute", "103-Exeggutor",
			"104-Cubone", "105-Marowak", "106-Hitmonlee", "107-Hitmonchan", "108-Lickitung", "109-Koffing",
			"110-Weezing", "111-Rhyhorn", "112-Rhydon", "113-Chansey", "114-Tangela", "115-Kangaskhan", "116-Horsea",
			"117-Seadra", "118-Goldeen", "119-Seaking", "120-Staryu", "121-Starmie", "122-Mr.Mime", "123-Scyther",
			"124-Jynx", "125-Electabuzz", "126-Magmar", "127-Pinsir", "128-Tauros", "129-Magikarp", "130-Gyarados",
			"131-Lapras", "132-Ditto", "133-Eevee", "134-Vaporeon", "135-Jolteon", "136-Flareon", "137-Porygon",
			"138-Omanyte", "139-Omastar", "140-Kabuto", "141-Kabutops", "142-Aerodactyl", "143-Snorlax", "144-Articuno",
			"145-Zapdos", "146-Moltres", "147-Dratini", "148-Dragonair", "149-Dragonite", "150-Mewtwo", "151-Mew" };

	// ImageIcon array for pokemonImageList
	private ImageIcon[] pokemonImageList = {

			new ImageIcon("pokemonImage\\Bulbasaur.png"), new ImageIcon("pokemonImage\\Ivysaur.png"),
			new ImageIcon("pokemonImage\\Venusaur.png"), new ImageIcon("pokemonImage\\Charmander.png"),
			new ImageIcon("pokemonImage\\Charmeleon.png"), new ImageIcon("pokemonImage\\Charizard.png"),
			new ImageIcon("pokemonImage\\Squirtle.png"), new ImageIcon("pokemonImage\\Wartortle.png"),
			new ImageIcon("pokemonImage\\Blastoise.png"), new ImageIcon("pokemonImage\\Caterpie.png"),
			new ImageIcon("pokemonImage\\Metapod.png"), new ImageIcon("pokemonImage\\Butterfree.png"),
			new ImageIcon("pokemonImage\\Weedle.png"), new ImageIcon("pokemonImage\\Kakuna.png"),
			new ImageIcon("pokemonImage\\Beedrill.png"), new ImageIcon("pokemonImage\\Pidgey.png"),
			new ImageIcon("pokemonImage\\Pidgeotto.png"), new ImageIcon("pokemonImage\\Pidgeot.png"),
			new ImageIcon("pokemonImage\\Rattata.png"), new ImageIcon("pokemonImage\\Raticate.png"),
			new ImageIcon("pokemonImage\\Spearow.png"), new ImageIcon("pokemonImage\\Fearow.png"),
			new ImageIcon("pokemonImage\\Ekans.png"), new ImageIcon("pokemonImage\\Arbok.png"),
			new ImageIcon("pokemonImage\\Pikachu.png"), new ImageIcon("pokemonImage\\Raichu.png"),
			new ImageIcon("pokemonImage\\Sandshrew.png"), new ImageIcon("pokemonImage\\Sandslash.png"),
			new ImageIcon("pokemonImage\\Nidoran.png"), new ImageIcon("pokemonImage\\Nidorina.png"),
			new ImageIcon("pokemonImage\\Nidoqueen.png"), new ImageIcon("pokemonImage\\Nidoran.png"),
			new ImageIcon("pokemonImage\\Nidorino.png"), new ImageIcon("pokemonImage\\Nidoking.png"),
			new ImageIcon("pokemonImage\\Clefairy.png"), new ImageIcon("pokemonImage\\Clefable.png"),
			new ImageIcon("pokemonImage\\Vulpix.png"), new ImageIcon("pokemonImage\\Ninetales.jpg"),
			new ImageIcon("pokemonImage\\JigglyPuff.png"), new ImageIcon("pokemonImage\\Wigglypuff.png"),
			new ImageIcon("pokemonImage\\Zubat.png"), new ImageIcon("pokemonImage\\Golbat.jpg"),
			new ImageIcon("pokemonImage\\Oddish.png"), new ImageIcon("pokemonImage\\Gloom.png"),
			new ImageIcon("pokemonImage\\Vileplume.png"), new ImageIcon("pokemonImage\\Paras.png"),
			new ImageIcon("pokemonImage\\Parasect.png"), new ImageIcon("pokemonImage\\Venonat.png"),
			new ImageIcon("pokemonImage\\Venomoth.png"), new ImageIcon("pokemonImage\\Diglett.png"),
			new ImageIcon("pokemonImage\\Dugtrio.png"), new ImageIcon("pokemonImage\\Meowth.png"),
			new ImageIcon("pokemonImage\\Persian.png"), new ImageIcon("pokemonImage\\Psyduck.jpg"),
			new ImageIcon("pokemonImage\\Golduck.png"), new ImageIcon("pokemonImage\\Mankey.png"),
			new ImageIcon("pokemonImage\\Primeape.png"), new ImageIcon("pokemonImage\\Growlithe.png"),
			new ImageIcon("pokemonImage\\Arcanine.png"), new ImageIcon("pokemonImage\\Poliwag.png"),
			new ImageIcon("pokemonImage\\Poliwhirl.png"), new ImageIcon("pokemonImage\\Poliwrath.png"),
			new ImageIcon("pokemonImage\\Abra.png"), new ImageIcon("pokemonImage\\Kadabra.png"),
			new ImageIcon("pokemonImage\\Alakazam.png"), new ImageIcon("pokemonImage\\Machop.png"),
			new ImageIcon("pokemonImage\\Machoke.png"), new ImageIcon("pokemonImage\\Machamp.png"),
			new ImageIcon("pokemonImage\\Bellsprout.png"), new ImageIcon("pokemonImage\\Weepinbell.png"),
			new ImageIcon("pokemonImage\\Victreebel.png"), new ImageIcon("pokemonImage\\Tentacool.png"),
			new ImageIcon("pokemonImage\\Tentacruel.png"), new ImageIcon("pokemonImage\\Geodude.png"),
			new ImageIcon("pokemonImage\\Graveler.png"), new ImageIcon("pokemonImage\\Golem.png"),
			new ImageIcon("pokemonImage\\Ponyta.png"), new ImageIcon("pokemonImage\\Rapidash.png"),
			new ImageIcon("pokemonImage\\Slowpoke.png"), new ImageIcon("pokemonImage\\Slowbro.png"),
			new ImageIcon("pokemonImage\\Magnemite.png"), new ImageIcon("pokemonImage\\Magneton.png"),
			new ImageIcon("pokemonImage\\Farfetch'd.png"), new ImageIcon("pokemonImage\\Doduo.png"),
			new ImageIcon("pokemonImage\\Dodrio.png"), new ImageIcon("pokemonImage\\Seel.png"),
			new ImageIcon("pokemonImage\\Dewgong.png"), new ImageIcon("pokemonImage\\Grimer.png"),
			new ImageIcon("pokemonImage\\Muk.png"), new ImageIcon("pokemonImage\\Shellder.png"),
			new ImageIcon("pokemonImage\\Cloyster.png"), new ImageIcon("pokemonImage\\Gastly.png"),
			new ImageIcon("pokemonImage\\Haunter.jpg"), new ImageIcon("pokemonImage\\Gengar.png"),
			new ImageIcon("pokemonImage\\Onix.png"), new ImageIcon("pokemonImage\\Drowzee.png"),
			new ImageIcon("pokemonImage\\Hypno.png"), new ImageIcon("pokemonImage\\Krabby.png"),
			new ImageIcon("pokemonImage\\Kingler.png"), new ImageIcon("pokemonImage\\Voltorb.png"),
			new ImageIcon("pokemonImage\\Electrode.png"), new ImageIcon("pokemonImage\\Exeggcute.png"),
			new ImageIcon("pokemonImage\\Exeggutor.png"), new ImageIcon("pokemonImage\\Cubone.png"),
			new ImageIcon("pokemonImage\\Marowak.png"), new ImageIcon("pokemonImage\\Hitmonlee.png"),
			new ImageIcon("pokemonImage\\Hitmonchan.png"), new ImageIcon("pokemonImage\\Lickitung.png"),
			new ImageIcon("pokemonImage\\Koffing.png"), new ImageIcon("pokemonImage\\Weezing.png"),
			new ImageIcon("pokemonImage\\Rhyhorn.png"), new ImageIcon("pokemonImage\\Rhydon.png"),
			new ImageIcon("pokemonImage\\Chansey.png"), new ImageIcon("pokemonImage\\Tangela.jpg"),
			new ImageIcon("pokemonImage\\Kangaskhan.png"), new ImageIcon("pokemonImage\\Horsea.png"),
			new ImageIcon("pokemonImage\\Seadra.png"), new ImageIcon("pokemonImage\\Goldeen.png"),
			new ImageIcon("pokemonImage\\Seaking.png"), new ImageIcon("pokemonImage\\Staryu.png"),
			new ImageIcon("pokemonImage\\Starmie.png"), new ImageIcon("pokemonImage\\Mr.Mime.png"),
			new ImageIcon("pokemonImage\\Scyther.png"), new ImageIcon("pokemonImage\\Jynx.png"),
			new ImageIcon("pokemonImage\\Electabuz.png"), new ImageIcon("pokemonImage\\Magmar.png"),
			new ImageIcon("pokemonImage\\Pinsir.png"), new ImageIcon("pokemonImage\\Tauros.png"),
			new ImageIcon("pokemonImage\\Magikarp.png"), new ImageIcon("pokemonImage\\Gyarados.png"),
			new ImageIcon("pokemonImage\\Lapras.png"), new ImageIcon("pokemonImage\\Ditto.png"),
			new ImageIcon("pokemonImage\\Eevee.png"), new ImageIcon("pokemonImage\\Vaporeon.png"),
			new ImageIcon("pokemonImage\\Jolteon.png"), new ImageIcon("pokemonImage\\Flareon.png"),
			new ImageIcon("pokemonImage\\Porygon.png"), new ImageIcon("pokemonImage\\Omanyte.png"),
			new ImageIcon("pokemonImage\\Omastar.png"), new ImageIcon("pokemonImage\\Kabuto.png"),
			new ImageIcon("pokemonImage\\Kabutops.png"), new ImageIcon("pokemonImage\\Aerodactyl.jpg"),
			new ImageIcon("pokemonImage\\Snorlax.png"), new ImageIcon("pokemonImage\\Articuno.png"),
			new ImageIcon("pokemonImage\\Zapdos.png"), new ImageIcon("pokemonImage\\Moltres.png"),
			new ImageIcon("pokemonImage\\Dratini.png"), new ImageIcon("pokemonImage\\Dragonair.png"),
			new ImageIcon("pokemonImage\\Dragonite.png"), new ImageIcon("pokemonImage\\Mewtwo.png"),
			new ImageIcon("pokemonImage\\Mew.png")

	};

	public static void main(String[] args)

	{
		// This is the GUI with the background image from
		// Background class
		// new PokemonTest(new BorderLayout());

		Background background = new Background(new BorderLayout());
		PokemonTest basicGUI = new PokemonTest();
		basicGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// this is the JPanel with Gridbadlayout
		// Where the components are located at
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);

		// This is the CenterPanel2 for add the ProgammerLabel
		// at the button of the screen
		JPanel centerPanel2 = new JPanel(new GridBagLayout());

		// panel.add(centerPanel2);
		background.add(panel);

		// This creates the GridBagContstraint to display
		// the components where ever you want

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// This is where you display your components
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("User Name"), gbc);
		panel.setOpaque(false);
		centerPanel2.setOpaque(false);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(userNameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Password"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(passwordTextField, gbc);
		// panel.add(ftf1,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(loginButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(exitButton, gbc);

		background.add(centerPanel2, BorderLayout.SOUTH);
		// JPanel mainPanel2 = new JPanel (new BorderLayout());

		centerPanel2.setOpaque(false);

		gbc.gridx = 0;
		gbc.gridy = 0;
		programmerNameLabel.setFont(taFont); // adds the font to the label
		programmerNameLabel.setForeground(Color.WHITE); // changes color of the Font to White
		centerPanel2.add(programmerNameLabel, gbc); // adds ProgrammerLabel to the South

		gbc.gridx = 0;
		gbc.gridy = 1;
		programmerNameLabel2.setFont(taFont); // adds the font to the label
		programmerNameLabel2.setForeground(Color.WHITE); // changes color of the Font to White
		centerPanel2.add(programmerNameLabel2, gbc); // adds ProgammerLabel to the South

		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		f.add(background);
		f.setVisible(true);
		f.setSize(336, 510);

	}// end of main code

	public PokemonTest() {

		exitButton.addActionListener(this);
		loginButton.addActionListener(this);
		searchButton.addActionListener(this);
	}

	// Method that is active when login/exit is clicked
	// Ether opens another GUI or Exits the application
	public void actionPerformed(ActionEvent evt) {
		Object sourceObject = evt.getSource();

		if (sourceObject == loginButton) {

			// if(userNameTextField.getText().equals("guest") &&
			// passwordTextField.getText().equals("password"))
			// {
			f.setVisible(false);
			pokedexDisplay();

			// }

		}
		if (!(searchTextArea.getText()).equals("")) {
			if (sourceObject == searchButton) {
				searchPokemonItem();
			}
		}
		/*
		 * else if(sourceObject == returnButton) {
		 * pokedexOpen.setVisible(false); f.setVisible(true); if(sourceObject ==
		 * loginButton) { f.setVisible(false); pokedexDisplay(); } }
		 */
	}// end of actionPerformed code

	public void pokedexDisplay() {
		GridBagConstraints gbb = new GridBagConstraints();
		gbb.insets = new Insets(5, 5, 5, 5);

		pokemonList = new JList<String>(pokemonNameList);
		pokemonImage = new JLabel(pokemonImageList[0]);

		pokemonScrollList = new JScrollPane(pokemonList);

		pokedexOpen.add(background2);
		background2.add(mainPanel, BorderLayout.WEST);
		pokemonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pokemonList.setSelectedIndex(0);


		ListHandler handle = new ListHandler();
		pokemonList.addListSelectionListener(handle);

		gbb.gridx = 0;
		gbb.gridy = 0;
		pokemonImage.setOpaque(false);

		mainPanel.add(new JLabel("   "), gbb);

		gbb.gridx = 1;
		gbb.gridy = 0;
		mainPanel.add(selectedPokemonLabel, gbb);

		// gbb.gridx = 1;
		// gbb.gridy = 0;
		gbb.gridx = 1;
		gbb.gridy = 1;
		mainPanel.add(pokemonImage, gbb);

		mainPanel.setOpaque(false);

		background2.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setOpaque(false);
		centerPanel.setOpaque(false);
		centerDisplay();

		background2.add(inputPanel, BorderLayout.NORTH);
		inputPanel.setOpaque(false);

		background2.add(rightPanel, BorderLayout.EAST);
		rightPanel.add(inputPanel2);/// new BorderLayout());
		rightPanel.setOpaque(false);
		rightDisplay();

		pokedexOpen.setResizable(false);
		pokedexOpen.setSize(700, 630);// 590);

		pokedexOpen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pokedexOpen.setVisible(true);

	}

	public void centerDisplay() {

	}// end of center display

	public void rightDisplay() {

		// GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbb = new GridBagConstraints();
		gbb.insets = new Insets(5, 5, 2, 26);

		// First row
		gbb.gridx = 0;
		gbb.gridy = 0;
		inputPanel2.add(typeLabel, gbb);

		// First row second cell
		gbb.gridx = 1;
		gbb.gridy = 0;
		inputPanel2.add(typeLabelChange, gbb);

		gbb.gridx = 0;
		gbb.gridy = 1;
		inputPanel2.add(heightLabel, gbb);

		gbb.gridx = 1;
		gbb.gridy = 1;
		inputPanel2.add(heightLabelChange, gbb);

		gbb.gridx = 0;
		gbb.gridy = 2;
		inputPanel2.add(weightLabel, gbb);

		gbb.gridx = 1;
		gbb.gridy = 2;
		inputPanel2.add(weightLabelChange, gbb);

		gbb.gridx = 0;
		gbb.gridy = 3;
		inputPanel2.add(new JLabel("Information"), gbb);
		informationTextArea.setEditable(false);
		informationTextArea.setText("Bulbasaur is a\n" + "small, quadruped\n" + "Pokémon\n"
				+ "with green to\nbluish-green\n" + "skin and\n" + "darker green\npatches.\n");

		gbb.gridx = 1;
		gbb.gridy = 3;
		inputPanel2.add(new JLabel("Pokemon"), gbb);

		gbb.gridx = 0;
		gbb.gridy = 4;
		inputPanel2.add(outputScrollPane, gbb);

		gbb.gridx = 1;
		gbb.gridy = 4;
		inputPanel2.add(pokemonScrollList, gbb);

		// gbb.gridx = 3;
		// gbb.gridy = 4;
		// inputPanel2.add(new JLabel(" "),gbb);

		gbb.gridx = 0;
		gbb.gridy = 5;
		inputPanel2.add(searchScrollPanel, gbb);

		gbb.gridx = 1;
		gbb.gridy = 5;
		inputPanel2.add(searchButton, gbb);
		inputPanel2.setOpaque(false);
	}

	// This Method search for the pokemon and displays them
	public void searchPokemonItem() {
		String inputPokemonItemString = searchTextArea.getText();

		foundPokemonBoolean = searchPokemon(inputPokemonItemString);

	}// end of searchPokemonItem code

	// Searches for Pokemon
	public boolean searchPokemon(String inputString) {
		boolean pokemonFoundBoolean = false; // true/false statment set to false
		String pokemonListItemString = ""; // String thats empty at first
		int indexInteger = 0; // Starting integer at Zero for index 0
		int numberInListInteger = pokemonList.getModel().getSize(); // Well return the number in the JList for Pokemon

		// using a while loop to search for the pokemon one is searching for
		while (!pokemonFoundBoolean && indexInteger < numberInListInteger) {
			pokemonListItemString = pokemonList.getModel().getElementAt(indexInteger);

			int pokemonLength = pokemonListItemString.length(); // gets the lenght of the String in the Array

			// Searches line by line of each index in the String
			for (int i = 0; i <= (pokemonLength); i++) {
				// Finds the matching input in the list
				if (pokemonListItemString.regionMatches(i, inputString, 0, inputString.length()))
					pokemonFoundBoolean = true;
				pokemonList.setSelectedIndex(indexInteger);

				String nameString = pokemonList.getSelectedValue();
				selectedPokemonLabel.setText(nameString);

			} // end of for loop code

			// This user input to search for pokemon and sets it
			if (inputString.equalsIgnoreCase(pokemonListItemString)) {
				pokemonFoundBoolean = true;
				pokemonList.setSelectedIndex(indexInteger);
			}
			indexInteger++;
		}

		return pokemonFoundBoolean;

	}

	private class ListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent evt) {
			// Adds the Image to the selected JList
			pokemonImage.setIcon(pokemonImageList[pokemonList.getSelectedIndex()]);

			// Adds the Name of pokemon on top of the image
			String nameString = pokemonList.getSelectedValue();
			selectedPokemonLabel.setText(nameString);
			informationTextArea.setText("Bulbasaur is a\n" + "small, quadruped\n" + "Pokémon\n"
					+ " with green to\n bluish-green\n" + " skin and\n " + "darker green\n patches.\n");
			if (pokemonList.getSelectedIndex() == 0) {

				typeLabelChange.setText("Grass/Poision");
				heightLabelChange.setText("2'40        0.7m");
				weightLabelChange.setText("15.2lbs    6.9kg");
			}
			if (pokemonList.getSelectedIndex() == 1) {
				// String nameString = pokemonList.getSelectedValue();
				// selectedPokemonLabel.setText(nameString);
				informationTextArea.setText("Ivysaur is a quadruped\n" + "Pokémon similar to\n" + "a dinosaur. It\n"
						+ "has blue-green skin\n" + "with darker patches.\n" + "Two pointed teeth\n"
						+ "protrude from its\n" + "upper jaw, \n" + "and it has\n" + "narrow red to\n"
						+ "purple eyes. ");
				typeLabelChange.setText("Grass/Poision");
				heightLabelChange.setText("3'03        1.0m");
				weightLabelChange.setText("28.7lbs    13.0kg");

			}

			if (pokemonList.getSelectedIndex() == 2) {
				informationTextArea.setText("Venusaur is a\n" + "squat, quadruped\n" + "Pokémon with bumpy,\n"
						+ "bluish green skin.\n" + "It has small,\n" + "circular red eyes,\n" + "a short, blunt\n"
						+ "snout, and a wide\n" + "mouth with two\n" + "pointed teeth in\n" + "the upper jaw,\n"
						+ "and four\n" + "pointed teeth\n" + "in the lower jaw.");
				typeLabelChange.setText("Grass/Poision");
				heightLabelChange.setText("6'07        2.0m");
				weightLabelChange.setText("220.5lbs    100.0kg");
			}
			if (pokemonList.getSelectedIndex() == 3) {
				informationTextArea.setText("Charmander is a\n" + "bipedal, reptilian\n" + "Pokémon with an\n"
						+ "orange body,\n" + "though its\n" + "underside and\n" + "soles are\n" + "cream-colored.\n"
						+ "It has two small\n" + "fangs visible in\n" + "its upper and lower\n" + "jaws and blue\n"
						+ "eyes. Its arms\n" + "and legs are\n" + "short with four\n" + "fingers and\n"
						+ "three clawed toes.");
				typeLabelChange.setText("Fire");
				heightLabelChange.setText("2'00        0.6m");
				weightLabelChange.setText("18.7lbs    8.5kg");
			}
			if (pokemonList.getSelectedIndex() == 4) {
				informationTextArea.setText("Charmeleon is a\n" + "bipedal, reptilian\n" + "creature. It has\n"
						+ "crimson scales and\n" + "a cream underside.\n" + "There is a horn-like\n"
						+ "protrusion on the\n" + "back of its head,\n" + "and it has narrow\n" + "green eyes and a\n"
						+ "long snout. It\n" + "has relatively\n" + "long arms with\n" + "three sharp claws.\n"
						+ "Its short legs\n" + "have feet with\n" + "three claws and\n" + "cream-colored\n" + "soles.");
				typeLabelChange.setText("Fire");
				// typeLabelChange.setForeground(Color.RED);

				heightLabelChange.setText("3.07        1.1m");
				weightLabelChange.setText("41.9lbs    19.0kg");
			}
			if (pokemonList.getSelectedIndex() == 5) {
				informationTextArea.setText("Charizard is a\n" + "draconic, bipedal\n" + "Pokémon. It is\n"
						+ "primarily orange\n" + "with a cream\n" + "underside from the\n" + "chest to the tip of\n"
						+ "its tail, which\n" + "burns with a\n" + "sizable flame. \n" + "Charizard has a\n"
						+ "long neck, small\n" + "blue eyes, raised\n" + "nostrils, and two\n" + "blunt horns\n"
						+ "protruding from\n" + "the back of its\n" + "rectangular head.\n" + "There are two\n"
						+ "fangs visible in\n" + "the upper jaw\n" + "when its mouth\n" + "is closed.");
				typeLabelChange.setText("Fire/Flying");
				heightLabelChange.setText("5'01        1.7m");
				weightLabelChange.setText("199.5lbs    90.5kg");
			}
			if (pokemonList.getSelectedIndex() == 6) {
				informationTextArea.setText("Squirtle is a\n" + "small Pokémon that\n" + "resembles a light\n"
						+ "blue turtle. It\n" + "has large brown\n" + "eyes and a\n" + "slightly hooked\n"
						+ "upper lip. Each\n" + "of its hands and\n" + "feet have three\n" + "pointed digits.\n"
						+ "The end of its\n" + "long tail curls\n" + "inward. Its body\n" + "is encased by a tough\n"
						+ "shell that forms\n" + "and hardens\n" + "after birth.");
				typeLabelChange.setText("Water");
				heightLabelChange.setText("1'08        0.5m");
				weightLabelChange.setText("19.8lbs    9.0kg");
			}
			if (pokemonList.getSelectedIndex() == 7) {
				informationTextArea.setText("Wartortle is a\n" + "bipedal, indigo-blue\n" + "Pokémon similar to\n"
						+ "a turtle. It\n" + "has brown eyes,\n" + "a dark blue\n" + "streak on each\n"
						+ "cheek, and two\n" + "sharp teeth\n" + "protruding from\n" + "its upper jaw.\n"
						+ "It has three \n" + "clawed fingers\n" + "and pointed toes.");
				typeLabelChange.setText("Water");
				heightLabelChange.setText("3'03        1.0m");
				weightLabelChange.setText("49.6lbs    22.5kg");
			}
			if (pokemonList.getSelectedIndex() == 8) {
				informationTextArea.setText("Blastoise is a\n" + "large, bipedal\n" + "tortoise-like\n"
						+ "Pokémon. Its\n" + "body is dark\n" + "blue and is\n" + "mostly hidden\n" + "by its tough,\n"
						+ "brown shell. \n" + "This shell has\n" + "a pale yellow\n" + "underside and\n"
						+ "a white ridge\n" + "between the\n" + "upper and lower\n" + "halves, which\n"
						+ "also encircles\n" + "the arms.");
				typeLabelChange.setText("Water");
				heightLabelChange.setText("5'03        1.6m");
				weightLabelChange.setText("188.5lbs    85.5kg");
			}

			if (pokemonList.getSelectedIndex() == 9) {
				informationTextArea
						.setText("Caterpie is a\n" + "serpentine Pokémon\n" + "that resembles\n" + "the larvae of\n"
								+ "the Spicebush\n" + "Swallowtail. It\n" + "is a green\n" + "caterpillar with\n"
								+ "yellow ring-shaped\n" + "markings down\n" + "the sides of\n" + "its body.");
				typeLabelChange.setText("Bug");
				heightLabelChange.setText("1'00        0.3m");
				weightLabelChange.setText("6.4lbs    2.9kg");
			}

			if (pokemonList.getSelectedIndex() == 10) {
				informationTextArea.setText("Metapod resembles\n" + "a chrysalis. Its\n" + "soft body is\n"
						+ "protected by\n" + "a hard outer\n" + "shell while it\n" + "undergoes\n" + "metamorphosis. \n"
						+ "While this shell\n" + "is said to be as\n" + "hard as steel,\n" + "a sudden, powerful\n"
						+ "impact could cause\n" + "its tender body\n" + "to pop out, \n" + "leaving it \n"
						+ "completely exposed. ");
				typeLabelChange.setText("Bug");
				heightLabelChange.setText("2'05        0.7m");
				weightLabelChange.setText("21.8lbs    9.9kg");
			}
			if (pokemonList.getSelectedIndex() == 11) {
				informationTextArea.setText("Butterfree resembles\n" + "a vaguely\n" + "anthropomorphic\n"
						+ "butterfly with\n" + "a purple body. \n" + "Unlike true \n" + "insects, it \n"
						+ "only has two \n" + "body segments \n" + "and four light \n" + "blue legs.\n"
						+ "Butterfree has \n" + "two black \n" + "antennae, a \n" + "light blue \n" + "snout with two\n"
						+ "fangs underneath,\n" + " and large, \n" + "red compound eyes.");
				typeLabelChange.setText("Bug/Flying");
				heightLabelChange.setText("3'07        1.1m");
				weightLabelChange.setText("70.5lbs    32.0kg");
			}

			if (pokemonList.getSelectedIndex() == 12) {
				informationTextArea.setText("Weedle is a small\n" + "larva Pokémon \n" + "with a beige, \n"
						+ "yellow, or \n" + "rust-colored \n" + "segmented body.\n" + "Combined with \n"
						+ "its red, purple,\n" + "or fuchsia nose \n" + "and feet, \n" + "Weedle's bright\n"
						+ "coloration wards\n" + "off its enemies.");
				typeLabelChange.setText("Bug/Poison");
				heightLabelChange.setText("1'00        0.3m");
				weightLabelChange.setText("7.1lbs    3.2kg");
			}

			if (pokemonList.getSelectedIndex() == 13) {
				informationTextArea.setText("Kakuna is a yellow,\n" + "cocoon Pokémon.\n" + "Kakuna has a\n"
						+ "dome-shaped \n" + "head and black,\n" + "triangular eyes.\n" + "It has two \n"
						+ "scythe-like \n" + "arms in the \n" + "middle of its body.");
				typeLabelChange.setText("Bug/Poison");
				heightLabelChange.setText("2'00        0.6m");
				weightLabelChange.setText("22.0lbs    10.0kg");
			}
			if (pokemonList.getSelectedIndex() == 14) {
				informationTextArea.setText("Beedrill mostly \n" + "resembles a \n" + "bipedal wasp; \n"
						+ "however, it only\n " + "has four legs \n" + "instead of six\n" + "and lacks pigment\n"
						+ "pits. Beedrill's \n" + "head is round \n" + "with a slightly\n" + "pointed mouth, \n"
						+ "large, red eyes,\n" + "and antennae \n" + "in the shape \n" + "of the number\n" + "seven.");
				typeLabelChange.setText("Bug/Poison");
				heightLabelChange.setText("3'03        1.0m");
				weightLabelChange.setText("65.0lbs    29.5kg");
			}
			if (pokemonList.getSelectedIndex() == 15) {
				informationTextArea
						.setText("Pidgey is a small,\n" + "plump-bodied \n" + "avian Pokémon. \n" + "It is primarily \n"
								+ "brown with a \n" + "cream-colored \n" + "face, underside,\n" + " and flight \n"
								+ "feathers. Both \n" + "its feet and \n" + "beak are a \n" + "pinkish-gray \n"
								+ "color. It has \n" + "black, angular \n" + "markings around \n" + "its eyes and \n"
								+ "a small crest \n" + "of brown and \n" + "cream feathers \n" + "above its eyes.");
				typeLabelChange.setText("Normal/Flying");
				heightLabelChange.setText("1'00        0.3m");
				weightLabelChange.setText("4.0lbs    1.8kg");
			}
			if (pokemonList.getSelectedIndex() == 16) {
				informationTextArea.setText("Pidgeotto is a \n" + "raptor-like avian \n" + "Pokémon. It is \n"
						+ "covered with brown\n" + "feathers, and has\n" + "a cream-colored\n" + "face and underside.\n"
						+ "It has a crest\n" + "of pinkish-red\n" + "feathers on \n" + "its head and\n"
						+ "black, angular\n" + "markings behind \n" + "its eyes.");
				typeLabelChange.setText("Normal/Flying");
				heightLabelChange.setText("3'07        1.1m");
				weightLabelChange.setText("66.1lbs    30.0kg");
			}
			if (pokemonList.getSelectedIndex() == 17) {
				informationTextArea.setText("Pidgeot is an \n" + "avian Pokémon with\n" + "large wings, \n"
						+ "sharp talons, \n" + "and a short, \n" + "hooked beak. \n" + "Its glossy \n" + "plumage is \n"
						+ "mostly brown\n" + "with cream-colored\n" + "underparts and\n" + "flight feathers.");
				typeLabelChange.setText("Normal/Flying");
				heightLabelChange.setText("4'11        1.5m");
				weightLabelChange.setText("87.1lbs    39.5kg");
			}
			if (pokemonList.getSelectedIndex() == 18) {
				informationTextArea.setText("Rattata is a small,\n" + "quadruped rodent \n" + "Pokémon. Its most\n"
						+ "notable feature \n" + "is its large teeth.\n" + "Like most rodents,\n" + "its teeth grow\n"
						+ "continuously \n" + "throughout its \n" + "life and must \n" + "be worn down \n"
						+ "by gnawing. \n" + "It has long \n" + "whiskers and \n" + "a long, \n" + "slightly curled \n"
						+ "tail. ");
				typeLabelChange.setText("Normal");
				heightLabelChange.setText("1'00        0.3m");
				weightLabelChange.setText("7.7lbs    3.5kg");
			}
			if (pokemonList.getSelectedIndex() == 19) {
				informationTextArea.setText("Raticate is a large,\n" + "rodent Pokémon. \n" + "Although it is \n"
						+ "often depicted on \n" + "its hind legs, \n" + "it is a quadruped. \n" + "It is mostly \n"
						+ "tawny colored \n" + "with a cream \n" + "underside. It \n" + "has large incisors\n"
						+ "that grow constantly.\n" + " These teeth are\n" + "strong enough \n" + "to gnaw through \n"
						+ "steel.");
				typeLabelChange.setText("Normal");
				heightLabelChange.setText("2'04        0.7m");
				weightLabelChange.setText("40.8lbs    18.5kg");
			}
			if (pokemonList.getSelectedIndex() == 20) {
				informationTextArea.setText("Spearow is a brown\n" + "avian Pokémon that\n" + "is very small. \n"
						+ "It has rough, \n" + "brown plumage on\n" + "its head with a \n" + "short, hooked \n"
						+ "beak. Spearow's \n" + "underside is \n" + "beige with two \n" + "thin stripes.");
				typeLabelChange.setText("Normal/Flying");
				heightLabelChange.setText("1'00        0.3m");
				weightLabelChange.setText("4.4lbs    2.0kg");
			}
			if (pokemonList.getSelectedIndex() == 21) {
				informationTextArea.setText("Fearow is a large, \n" + "mostly brown avian \n" + "Pokémon with a \n"
						+ "vulturine neck \n" + "and broad, powerful \n" + "wings. It has \n" + "a long, pointed,\n"
						+ "pink beak, and \n" + "a decorative \n" + "red coxcomb on \n" + "top of its head. \n"
						+ "Its narrow eyes \n" + "have very small \n" + "pupils, and do \n" + "not appear to \n"
						+ "have colored irises.");
				typeLabelChange.setText("Normal/Flying");
				heightLabelChange.setText("3'11        1.2m");
				weightLabelChange.setText("83.8lbs    38.0kg");
			}
			if (pokemonList.getSelectedIndex() == 22) {
				informationTextArea.setText("Ekans is a purple, \n" + "serpentine Pokémon.\n" + "Its eyes, \n"
						+ "underbelly, stripe, \n" + "and rattle are \n" + "yellow. Ekans \n" + "has three pairs \n"
						+ "of black lines \n" + "encircling its \n" + "body, as well \n" + "as another line \n"
						+ "that connects \n" + "each slitted eye \n" + "and curves \n" + "toward its nose.");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("6'07        2.0m");
				weightLabelChange.setText("15.2lbs    6.9kg");
			}
			if (pokemonList.getSelectedIndex() == 23) {
				informationTextArea.setText("Arbok is a serpent \n" + "like Pokémon \n" + "with purple scales \n"
						+ "all over its body. \n" + "It has a large \n" + "hood just below \n" + "its head. On \n"
						+ "its hood, it \n" + "has a design \n" + "much like an \n" + "angry face, \n"
						+ "which can come \n" + "in six variations.");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("11'06        3.5m");
				weightLabelChange.setText("143.3lbs    65.0kg");
			}
			if (pokemonList.getSelectedIndex() == 24) {
				informationTextArea.setText("Pikachu is a \n" + "short, chubby \n" + "rodent Pokémon. \n"
						+ "It is covered in \n" + "yellow fur, and \n" + "its ears are \n" + "long and pointed \n"
						+ "with black tips. \n" + "It has a small \n" + "mouth, brown eyes, \n"
						+ "and two red circles\n" + "on its cheeks. \n" + "There are pouches \n"
						+ "inside its cheeks \n" + "where it stores \n" + "electricity. Its \n"
						+ "forearms are short, \n" + "with five fingers \n" + "on each paw, \n" + "and its feet \n"
						+ "have three toes.");
				typeLabelChange.setText("Electric");
				heightLabelChange.setText("1'04        0.4m");
				weightLabelChange.setText("13.2lbs    6.0kg");
			}
			if (pokemonList.getSelectedIndex() == 25) {
				informationTextArea.setText("Raichu is a bipedal, \n" + "rodent-like Pokémon. \n"
						+ "Raichu is covered \n" + "in dark orange fur \n" + "with a cream belly. \n"
						+ "Its arms and feet \n" + "have patches of \n" + "brown fur at \n" + "the end, and \n"
						+ "the soles of \n" + "its big feet \n" + "are tan with \n" + "a circular \n" + "orange pad. ");
				typeLabelChange.setText("Electric");
				heightLabelChange.setText("2'07        0.8m");
				weightLabelChange.setText("66.1lbs    30.0kg");
			}
			if (pokemonList.getSelectedIndex() == 26) {
				informationTextArea.setText("Sandshrew is a bipedal\n" + "mammalian Pokémon, \n" + "but runs on all \n"
						+ "fours in the anime. \n" + "Its yellow hide \n" + "is dry, tough, \n" + "blends in with \n"
						+ "desert sand, \n" + "and has a brick \n" + "pattern, but its \n" + "underbelly and \n"
						+ "muzzle are white. ");
				typeLabelChange.setText("Ground");
				heightLabelChange.setText("2'00        0.6m");
				weightLabelChange.setText("26.6lbs    12.0kg");
			}
			if (pokemonList.getSelectedIndex() == 27) {
				informationTextArea.setText("Sandslash is a \n" + "bipedal, ground \n" + "dwelling pholidote \n"
						+ "Pokémon. Although \n" + "Sandslash is \n" + "usually bipedal, \n" + "it can run on all \n"
						+ "fours. Its body \n" + "is mostly covered \n" + "in sharp, brown \n" + "quills formed \n"
						+ "from its tough, \n" + "dry hide. It \n" + "has two large \n" + "claws on its \n"
						+ "paws and feet.");
				typeLabelChange.setText("Ground");
				heightLabelChange.setText("3'03        1.0m");
				weightLabelChange.setText("65.0lbs    29.5kg");
			}
			if (pokemonList.getSelectedIndex() == 28) {
				informationTextArea.setText("Nidoran is a small, \n" + "quadruped, rodent-like \n"
						+ "Pokémon. It has \n" + "large, spiny ears, \n" + "oversized front \n" + "teeth, red eyes, \n"
						+ "and a pair of \n" + "whiskers on each \n" + "cheek. It is light \n" + "blue with several \n"
						+ "darker blue spots.");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("1'04        0.4m");
				weightLabelChange.setText("15.4lbs    7.0kg");
			}
			if (pokemonList.getSelectedIndex() == 29) {
				informationTextArea.setText("Nidorina is a quadruped, \n" + "light-blue Pokémon\n"
						+ "with darker blue \n" + "patches. It has \n" + "red eyes, large, \n" + "spiny ears, and \n"
						+ "has two pointed \n" + "teeth protruding \n" + "from its upper jaw.");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("2'07        0.8m");
				weightLabelChange.setText("44.1lbs    20.0kg");
			}
			if (pokemonList.getSelectedIndex() == 30) {
				informationTextArea.setText("Nidoqueen is a large, \n" + "bipedal blue Pokémon\n" + "with distinct\n"
						+ "reptilian features.\n" + "Its lower jaw, chest\n" + "plates and lower\n" + "torso are \n"
						+ "cream-colored.\n" + "It has a horn\n" + "on its forehead,\n" + "narrow black eyes,\n"
						+ "and large, spiny ears.");
				typeLabelChange.setText("Poison/Ground");
				heightLabelChange.setText("4'03        1.3m");
				weightLabelChange.setText("132.3lbs    60.0kg");
			}
			if (pokemonList.getSelectedIndex() == 31) {
				informationTextArea.setText("Nidoran is a small,\n" + "quadruped \n" + "rodent-like Pokémon. \n"
						+ "It is pinkish \n" + "purple with darker \n" + "spots, and has \n" + "large, spiny \n"
						+ "ears, oversized \n" + "front teeth, \n" + "and red eyes. ");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("1'08        0.5m");
				weightLabelChange.setText("19.8lbs    9.0kg");
			}
			if (pokemonList.getSelectedIndex() == 32) {
				informationTextArea.setText(
						"Nidorino is a light \n" + "purple, quadruped \n" + "Pokémon. It has \n" + "several darker \n"
								+ "purple spots across \n" + "its body. It has \n" + "large, spiny ears \n"
								+ "with teal insides, \n" + "narrow black eyes, \n" + "and a long snout \n"
								+ "with two pointed \n" + "teeth protruding \n" + "from the upper jaw. ");
				typeLabelChange.setText("Poison");
				heightLabelChange.setText("2'11        095m");
				weightLabelChange.setText("43.0lbs    19.5kg");
			}

		}// end of valueChange method
	}// end of listhandler code

}
