package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ItemListener, ActionListener {
	
	ItemTest itemTest;
	
	public ItemLogic(ItemTest it) {
		this.itemTest  = it;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if( e.getSource() == itemTest.ch ) {
			itemTest.cbg1.setSelectedCheckbox(itemTest.cbMeal[itemTest.ch.getSelectedIndex()]);
		}
		
		Checkbox cbSelect = itemTest.cbg1.getSelectedCheckbox();
		String selectStr = cbSelect.getLabel();
		itemTest.ta.setText("---" + selectStr + "---");
		int len = itemTest.cbFruit.length;
		for (int i = 0; i < len; i++) {
			itemTest.ta.append("\n" + (i+1) + ". " + itemTest.fruit[i] + " : " + (itemTest.cbFruit[i].getState() ? "¸Ô¾ú´Ù" : "¾È¸Ô¾ú´Ù") );
		}

		itemTest.ch.select(selectStr);
	}
}
