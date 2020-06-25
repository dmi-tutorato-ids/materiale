import java.awt.*;
import javax.swing.*;

public class View implements Observer {
	// View uses Swing framework to display UI to user
	private JFrame frame;
	private JLabel countLabel;
	private JLabel infoLabel;
	private JTextField valueTextField;
	private JButton addButton;
	private JButton resetButton;

	private Model model;
	private Controller controller;

	public View(String title) {
		// Set Frame Layout and Size
		frame = new JFrame(title);
		frame.setLayout(new GridLayout(5, 1));
		frame.setSize(300, 200);

		// Create UI elements
		Font hugeFont = new Font("SansSerif", Font.BOLD, 40);
		Font bigFont = new Font("SansSerif", Font.BOLD, 20);
		Font smallFont = new Font("SansSerif", Font.ITALIC, 10);

		countLabel = new JLabel();
		countLabel.setFont(hugeFont);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);

		infoLabel = new JLabel();
		infoLabel.setFont(smallFont);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		valueTextField = new JTextField();
		valueTextField.setFont(bigFont);
		
		addButton = new JButton("Add");
		resetButton = new JButton("Reset Counter");

		// Add UI element to frame
		frame.add(countLabel);
		frame.add(infoLabel);
		frame.add(valueTextField);
		frame.add(addButton);
		frame.add(resetButton);

		// Show frame (exit when all frames have been closed)
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setModel(Model model) {
		this.model = model;
		model.attach(this);

		// Update the view with the Model current state
		update();
	}

	public void setController(Controller controller) {
		this.controller = controller;
		
		// Add Listeners
		addButton.addActionListener(e -> controller.addButtonPressed());
		resetButton.addActionListener(e -> controller.resetButtonPressed());
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}

	public JTextField getValueTextField() {
		return valueTextField;
	}

	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * View updates the label as soon as 
	 * there's a change in the Model
	 */
	@Override
	public void update() {
		int value = model.getValue();
		int max = model.getMax();
		countLabel.setText(value + "/" + max);
	}

}