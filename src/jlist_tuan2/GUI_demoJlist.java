package jlist_tuan2;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI_demoJlist extends JFrame {
	private JTextField txtListSelect;
	private JList list;

	public GUI_demoJlist() {
		super("jlist demo1");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		addControls();
		addEvents();
	}

	private void addControls() {
		JPanel pnTop = new JPanel();
		pnTop.setBorder(BorderFactory.createTitledBorder("Simple Jlist"));

		String[] entrys = { "entry1", "entry2", "entry3", "entry4", "entry5" };
		list = new JList(entrys);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrList = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnTop.add(scrList);
		this.add(pnTop, BorderLayout.CENTER);

		JPanel pnBot = new JPanel();
		JLabel lblListSelect = new JLabel("Last selection");
		pnBot.add(lblListSelect);

		txtListSelect = new JTextField(10);
		pnBot.add(txtListSelect);

		this.add(pnBot, BorderLayout.SOUTH);

	}

	private void addEvents() {

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				txtListSelect.setText(list.getSelectedValue().toString());
				
			}
		});
	}
	
	public static void main(String[] args) {
		GUI_demoJlist guiList = new GUI_demoJlist();
		guiList.setVisible(true);
		guiList.pack();
	}

}
