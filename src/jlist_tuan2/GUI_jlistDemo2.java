package jlist_tuan2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI_jlistDemo2 extends JFrame {
	private JList list;
	private DefaultListModel dfListModel;
	private JList listName;
	private JTextField txtName;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;
	public GUI_jlistDemo2() {
		super("jlist demo2");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControls();
		addEvents();
		
	}

	private void addControls() {
		dfListModel = new DefaultListModel();
		listName = new JList(dfListModel);
		this.add(listName,BorderLayout.CENTER);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		
		JPanel pnInput = new JPanel();
		pnInput.setPreferredSize(new Dimension(0, 70));
		JLabel lblInputName = new JLabel("Input name");
		pnInput.add(lblInputName);
		
		txtName = new JTextField(10);
		pnInput.add(txtName);
		pnRight.add(pnInput,BorderLayout.NORTH);
		
		JPanel pnChucNang = new JPanel();
		
		btnAdd = new JButton("Add item");
		btnRemove = new JButton("Remove item");
		btnEdit = new JButton("Edit item");
		pnChucNang.add(btnAdd);
		pnChucNang.add(btnRemove);
		pnChucNang.add(btnEdit);
		
		pnRight.add(pnChucNang,BorderLayout.CENTER);
		
		this.add(pnRight,BorderLayout.EAST);
	}	
	private void addEvents() {
		// TODO Auto-generated method stub
		listName.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int i = listName.getSelectedIndex();
				if(i!=-1) {
					txtName.setText(dfListModel.getElementAt(i).toString());
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "enter the name");
					return;
				}
				dfListModel.addElement(name);
				txtName.setText("");
				return;
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = listName.getSelectedIndex();
				dfListModel.removeElementAt(i);
				return;
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listName.getSelectedIndex()!=-1)
				dfListModel.setElementAt(txtName.getText(),listName.getSelectedIndex());
				return;
			}
		});
	}

	public static void main(String[] args) {
		GUI_jlistDemo2 guiJlistDemo2 = new GUI_jlistDemo2();
		guiJlistDemo2.setVisible(true);
	}
}
