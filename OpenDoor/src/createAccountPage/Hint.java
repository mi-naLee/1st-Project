package createAccountPage;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class Hint {
	
	private JTextField textField;

	public Hint(JTextField textField) {
		super();
		this.textField = textField;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public void hint() {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals(textField.getToolTipText())) {
					textField.setText(null);
					textField.setForeground(null);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length()==0||textField.getText().equals(textField.getToolTipText())) {
					textField.setText(textField.getToolTipText());
					textField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
	}
	
}
