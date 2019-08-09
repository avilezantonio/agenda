package com.hcl.agenda.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hcl.agenda.model.dao.ContactDAO;
import com.hcl.agenda.model.po.Contact;

public class ViewContacts extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509018850724491213L;

	/** Swing Components **/
	private JTable contatcsTable = null;
	private JLabel nameLabel = new JLabel("Name:");
	private JLabel lastNameLabel = new JLabel("Last Name:");
	private JLabel nickLabel = new JLabel("Nick:");
	private JTextField nameText = new JTextField();
	private JTextField lastNameText = new JTextField();
	private JTextField nickText = new JTextField();
	private JButton addButton = new JButton("Add");

	/** DAO **/
	private final ContactDAO contactDAO = new ContactDAO();

	private static final String[] COLS = { "Name", "Last Name", "Nick" };

	public ViewContacts() {
		this.initComponents();
	}

	private void initComponents() {
		this.initBasics();
		this.initTable();
		this.initForm();
		this.setVisible(true);
	}

	private void initBasics() {
		this.setTitle("Agenda");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(750, 500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	private void initTable() {
		this.contatcsTable = new JTable();
		this.contatcsTable.setSize(new Dimension(700, 500));
		final JScrollPane contactsScrollPane = new JScrollPane(this.contatcsTable);
		contactsScrollPane.setMinimumSize(new Dimension(700, 500));
		this.fillTable();
		this.add(contactsScrollPane, BorderLayout.NORTH);

	}

	private void fillTable() {

		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(COLS);
		contactDAO.getAll().forEach(
				c -> model.addRow(new String[] { c.getName(), c.getLastName(), c.getNick() })
				);
		this.contatcsTable.setModel(model);

	}

	private void initForm() {
		this.nameText.setPreferredSize(new Dimension(100, 20));
		this.lastNameText.setPreferredSize(new Dimension(100, 20));
		this.nickText.setPreferredSize(new Dimension(100, 20));

		final JPanel newContactPanel = new JPanel();

		newContactPanel.add(this.nameLabel);
		newContactPanel.add(this.nameText);

		newContactPanel.add(this.lastNameLabel);
		newContactPanel.add(this.lastNameText);

		newContactPanel.add(this.nickLabel);
		newContactPanel.add(this.nickText);

		this.addButton.addActionListener(this.getAddButtonListener());

		newContactPanel.add(this.addButton);

		this.add(newContactPanel, BorderLayout.CENTER);
	}

	private ActionListener getAddButtonListener() {
		return a -> {
			final Contact contact = new Contact();
			contact.setNick(this.nickText.getText());
			contact.setName(this.nameText.getText());
			contact.setLastName(this.lastNameText.getText());

			this.contactDAO.save(contact);
			this.cleanFields();
			this.fillTable();
			JOptionPane.showMessageDialog(null, "Contact added successfully");
		};
	}

	private void cleanFields() {
		this.nameText.setText("");
		this.lastNameText.setText("");
		this.nickText.setText("");
	}

}
