/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Acer
 */
public class Praktikum1Controller {

    private Praktikum1 view;
    private List<Integer> list = new ArrayList<>();

    public Praktikum1Controller(Praktikum1 view) {
        this.view = view;
        this.view.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
        this.view.getBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }

    private void proses() {
        JFileChooser loadFile = view.getjFileChooser1();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(loadFile.getSelectedFile());
                int read = inputStream.read();
                doc.insertString(0, "", null);
                while (read != -1) {
                    list.add(read);// tambahkan 1 baris
                    doc.insertString(doc.getLength(), "" + read, null);
                    System.out.println("" + read);
                    read = inputStream.read();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void save() {
        JFileChooser loadFile = view.getjFileChooser1();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
            OutputStream os = null;
            try {
                if (!list.isEmpty()) {
                    os = new FileOutputStream(loadFile.getSelectedFile());
                    byte[] dt = new byte[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        dt[i] = list.get(i).byteValue();
                    }
                    os.write(dt);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (os != null) {
                    try {
                        os.flush();
                        os.close();
                        list.clear();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
