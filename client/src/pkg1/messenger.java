package pkg1;

import java.awt.CardLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Contact;
import model.Room;
import model.User;
import view.ClientInputHandler;
import view.IClientInputHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Radwa Manssour
 */
public class messenger extends javax.swing.JPanel {

    /**
     * Creates new form messenger
     */
    rooms room;
    chatCui window;
    int w;
    public User user;
    public int openedRoomsNum = 0;
    //messenger gui=this;
    IClientInputHandler inputHandler;
    //user object sent in constructor
    IClientInputHandler handler;
    Vector<ContactPanel> contacts = new Vector<>();
    Vector<request> requests = new Vector<>();
    Vector<message> messages = new Vector<>();
    ImageIcon stateColor[] = {new ImageIcon(""), new ImageIcon(""), new ImageIcon("src\\pkg1\\f.png")};
    JList<JLabel> contactsPanel = new JList<>();
    JList<JLabel> messagesPanel = new JList<>();
    JList<JLabel> requestsPanel = new JList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void displayUserInfo(User user) {
        name.setText(user.getUserName());
        state.setSelectedIndex(user.getUserState());
        status.setText(user.getUserStatus());
        img.setIcon(user.getUserImage());
        for (int i = 0; i < user.userContacts.size(); i++) {
            ContactPanel cont = new ContactPanel(window,user.userContacts.get(i));
            cont.name.setText(user.userContacts.get(i).getName());
            cont.status.setText(user.userContacts.get(i).getStatus());
            cont.img.setIcon(user.userContacts.get(i).getPhoto());
            cont.state.setIcon(stateColor[user.userContacts.get(i).getState()]);
            contactsPanel.add(cont);
           

        }
        //offline messages
        for (int i = 0; i < user.userRooms.size(); i++) {
            message m = new message(this);
            m.img.setIcon(user.userRooms.get(i).getImg());
            m.name.setText(user.userRooms.get(i).getName());
            String s = user.userRooms.get(i).messageVector.get(user.userRooms.get(i).messageVector.size() - 1).getTxt();
            m.message.setText(s);
            messagesPanel.add(m);
        }
        //add also saved xml messages
        
        
        for (int i = 0; i < user.userRequests.size(); i++) {
            request r = new request();
            Contact c = user.userRequests.get(i);
            r.img.setIcon(c.getPhoto());
            r.name.setText(c.getName());
            requestsPanel.add(r);
            r.accept.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   handler.acceptContact(user,c);
                   user.userRequests.remove(c);
                   requestsPanel.remove(r);
                   ContactPanel c1=new ContactPanel(window,c);
                   c1.img.setIcon(c.getPhoto());
                   c1.name.setText(c.getName());
                   c1.status.setText(c.getStatus());
                   c1.state.setIcon(stateColor[c.getState()]);
                   contactsPanel.add(c1);
                   
                }
            });
        }

    }

    public messenger(rooms room, chatCui window, User user) {
        initComponents();
        this.user = user;
        //handler=new ClientInputHandler();
        //this part take its values from user object sent in the constructor

        jButton3.setIcon(new ImageIcon("src\\pkg1\\conn.png"));
        jButton4.setIcon(new ImageIcon("src\\pkg1\\msg1.png"));
        jButton5.setIcon(new ImageIcon("src\\pkg1\\req.png"));

        this.room = room;
        this.window = window;
        w = window.getWidth();
        contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS));
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        requestsPanel.setLayout(new BoxLayout(requestsPanel, BoxLayout.Y_AXIS));

        listContainer.add(contactsPanel, "contacts");
        listContainer.add(messagesPanel, "messages");
        listContainer.add(requestsPanel, "requests");

        displayUserInfo(user);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        contactMail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listContainer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        state = new javax.swing.JComboBox();
        status = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMaximumSize(new java.awt.Dimension(32767, 10));
        setPreferredSize(new java.awt.Dimension(285, 10));

        name.setText("jLabel1");

        contactMail.setText("jTextField1");
        contactMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactMailActionPerformed(evt);
            }
        });

        listContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        listContainer.setLayout(new java.awt.CardLayout());
        jScrollPane2.setViewportView(listContainer);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton3.setMaximumSize(new java.awt.Dimension(105, 82));
        jButton3.setMinimumSize(new java.awt.Dimension(105, 82));
        jButton3.setPreferredSize(new java.awt.Dimension(105, 82));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setMaximumSize(new java.awt.Dimension(105, 80));
        jButton4.setMinimumSize(new java.awt.Dimension(105, 80));
        jButton4.setPreferredSize(new java.awt.Dimension(105, 80));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.setMaximumSize(new java.awt.Dimension(105, 80));
        jButton5.setMinimumSize(new java.awt.Dimension(105, 80));
        jButton5.setPreferredSize(new java.awt.Dimension(105, 80));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        img.setText("jLabel1");

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "available", "busy ", "away" }));
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });

        status.setText("jTextField1");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(contactMail)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name)
                                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactMail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void contactMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactMailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!room.isVisible()) {

            int x = window.getWidth();
            while (x < 800) {
                try {

                    x += 3;
                    window.setSize(x, window.getHeight());
                    window.p.setSize(x, window.getHeight());
                    room.setSize(x - w, window.getHeight());
                    Thread.sleep(1);

                } catch (InterruptedException ex) {
                    Logger.getLogger(messenger.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            room.setVisible(true);
            jButton2.setText("<<");

        } else {

            int x = window.getWidth();
            while (x > w) {
                try {
                    x -= 10;
                    window.setSize(x, window.getHeight());
                    window.p.setSize(x, window.getHeight());
                    room.setSize(x - w, window.getHeight());
                    room.rooms_tabs.setSize(x, window.getHeight());
                    Thread.sleep(5);

                } catch (InterruptedException ex) {
                    Logger.getLogger(messenger.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            room.setVisible(false);
            jButton2.setText(">>");

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout card = (CardLayout) listContainer.getLayout();
        card.show(listContainer, "contacts");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CardLayout card = (CardLayout) listContainer.getLayout();
        card.show(listContainer, "messages");
        //messagesPanel.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CardLayout card = (CardLayout) listContainer.getLayout();
        card.show(listContainer, "requests");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        handler.addContact(contactMail.getText());
        //check if there is error message
    }//GEN-LAST:event_jButton1ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
        user.setUserStatus(status.getText());
        inputHandler=new ClientInputHandler();
        inputHandler.changeStatus(user);
        
    }//GEN-LAST:event_statusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contactMail;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JPanel listContainer;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox state;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
