package com.mycompany.contacts02.gui;

import com.mycompany.contacts02.entity.Contact;
import com.mycompany.contacts02.exception.ContactBusinessException;
import com.mycompany.contacts02.service.ContactService;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactFrame extends JFrame implements ActionListener {

    private static final String FRAME = "frame";
    private static final String C_REFRESH = "refresh";
    private static final String C_ADD = "add";
    private static final String C_UPDATE = "update";
    private static final String C_DELETE = "delete";

    private static final String LOAD = "LOAD";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";

    // private final ContactService contactService = new ContactServiceImpl();
    @Autowired
    private ContactService contactService;

    private final JTable contactTable = new JTable();

    public ContactFrame() {
    }

    public void run() {
        //выставляем у таблицы св-во кот позволяет выделить только одну строку в таблице
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        //используем layout manager
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // каждый эл-т является последним в строке
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        // эл-т раздвигается на весь размер ячейки
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        // но имеет границы - слева, сверху, справа - по 5, снизу - 0
        gridBagConstraints.insets = new Insets(5, 5, 0, 5);
        //  gridBagConstraints.
        // create panel for buttons
        JPanel btnPanel = new JPanel();
        // set layout to panel
        btnPanel.setLayout(gridBagLayout);
        //create buttons
        btnPanel.add(createButton(gridBagLayout, gridBagConstraints, GuiResource.getLabel(FRAME, C_REFRESH), LOAD));
        btnPanel.add(createButton(gridBagLayout, gridBagConstraints, GuiResource.getLabel(FRAME, C_ADD), ADD));
        btnPanel.add(createButton(gridBagLayout, gridBagConstraints, GuiResource.getLabel(FRAME, C_UPDATE), EDIT));
        btnPanel.add(createButton(gridBagLayout, gridBagConstraints, GuiResource.getLabel(FRAME, C_DELETE), DELETE));
        // создаем панель для левой колонки с кнопками
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        // button panel set in the top
        left.add(btnPanel, BorderLayout.NORTH);
        // put left column onto form to left side
        add(left, BorderLayout.WEST);
        // put into scrolling panel
        add(new JScrollPane(contactTable), BorderLayout.CENTER);
        // set coordinates of the form
        setBounds(100, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            loadContact();
        } catch (ContactBusinessException ex) {
            Logger.getLogger(ContactFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private JButton createButton(GridBagLayout gridBagLayout, GridBagConstraints constraints, String title, String action) {
        JButton button = new JButton(title);
        // действие, которое будет проверяться в обработчике
        button.setActionCommand(action);
        button.addActionListener(this);
        // выставляем св-ва для размещения кнопки
        gridBagLayout.setConstraints(button, constraints);
        return button;
    }

    // обработка нажатий кнопок
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String action = e.getActionCommand();
            if (action.equals(LOAD)) {
                loadContact();
            } else if (action.equals(ADD)) {
                addContact();
            } else if (action.equals(EDIT)) {
                editContact();
            } else {
                deleteContact();
            }
        } catch (ContactBusinessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    // загрузка списка контактов
    // @PostConstruct
    private void loadContact() throws ContactBusinessException {
        List<Contact> contacts = contactService.getAllContacts();
        // create model
        ContactModel cm = new ContactModel(contacts);
        // set model to table
        contactTable.setModel(cm);
    }

    // @PostConstruct
    private void editContact() throws ContactBusinessException {
        // get selected row
        int rowNum = contactTable.getSelectedRow();
        // if row is selected
        if (rowNum != -1) {
            Long id = Long.valueOf(String.valueOf(contactTable.getModel().getValueAt(rowNum, 0)));
            // get contact by id
            Contact c = contactService.getContact(id);
            EditContactDialog ecd = new EditContactDialog(c);
            saveContact(ecd);
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку");
        }
    }

    // @PostConstruct
    private void addContact() throws ContactBusinessException {
        // create dialog for input data
        EditContactDialog ecd = new EditContactDialog();
        saveContact(ecd);
    }

    // @PostConstruct
    private void deleteContact() throws ContactBusinessException {
        int rowNum = contactTable.getSelectedRow();
        if (rowNum != -1) {
            Long id = Long.valueOf(contactTable.getModel().getValueAt(rowNum, 0).toString());
            // delete contact by id
            contactService.deleteContact(id);
            // reload contacts after deleting
            loadContact();
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку");
        }
    }

    // save contact for update or add
    //  @PostConstruct
    private void saveContact(EditContactDialog ecd) throws ContactBusinessException {
        // if push button SAVE
        if (ecd.isSave()) {
            Contact c = ecd.getContact();
            if (c.getContactId() != null && c.getContactId() != -1) {
                contactService.editContact(c);
            } else {
                contactService.addContact(c);
            }
        }
        loadContact();
    }
}
