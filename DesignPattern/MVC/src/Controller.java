import javax.swing.*;
import java.awt.*;

public class Controller implements Observer {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		model.attach(this);
	}

	public void addButtonPressed() {
		JTextField field = view.getValueTextField();
		JLabel info = view.getInfoLabel();

		try {
			int inc = Integer.parseInt(field.getText());
			
			if (inc <= 0) {
				info.setForeground(Color.RED);
				info.setText("Value must be positive");
				return;
			}

			boolean isOK = model.incCounter(inc);
			if (isOK) {
				field.setText("");
				info.setForeground(Color.BLACK);
				info.setText("");
			} else {
				info.setForeground(Color.MAGENTA);
				info.setText("Value is to high");
			}

		} catch (NumberFormatException ex) {
			info.setForeground(Color.RED);
			info.setText("Only numeric values are accepted");
		}
	}

	public void resetButtonPressed() {
		model.resetCounter();
	}

	/**
	 * Controller disables the add button
	 * as soon as the counter value inside Model
	 * has reached the max value. This is something
	 * related to the user input.
	 */
	@Override
	public void update() {
		JButton button = view.getAddButton();
		if (model.getValue() >= model.getMax())
			button.setEnabled(false);
		else
			button.setEnabled(true);
		
	}

}