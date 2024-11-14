/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class helperGanjilGenap {
     private JTextField genaptField;  // JTextField untuk input angka
    private JTextField hasilField;   // JTextField untuk menampilkan hasil
    
 public helperGanjilGenap() {
        // Inisialisasi komponen
        genaptField = new JTextField();
        hasilField = new JTextField();

        // Menambahkan KeyListener untuk menangani ketika tombol ditekan di genaptField
        genaptField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                // Cek apakah tombol Enter ditekan
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        int angka = Integer.parseInt(genaptField.getText());

                        // Mengecek apakah angka genap atau ganjil
                        String jenisAngka = (angka % 2 == 0) ? "genap" : "ganjil";

                        // Mengecek apakah angka adalah bilangan prima
                        boolean isPrima = isBilanganPrima(angka);
                        String statusPrima = isPrima ? "bilangan prima" : "bukan bilangan prima";

                        // Menampilkan hasil menggunakan JOptionPane
                        JOptionPane.showMessageDialog(null, 
                            "Angka " + angka + " adalah " + jenisAngka + " dan " + statusPrima + ".",
                            "Hasil Pengecekan",
                            JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException e) {
                        // Menampilkan pesan error jika input bukan angka valid
                        JOptionPane.showMessageDialog(null, 
                            "Masukkan angka yang valid!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Menambahkan FocusListener untuk membersihkan JTextField saat mendapatkan fokus
        genaptField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Kosongkan field input saat mendapatkan fokus
                genaptField.setText("");
                hasilField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Tidak perlu aksi saat kehilangan fokus
            }
        });
    }

    // Fungsi untuk memeriksa apakah suatu angka adalah bilangan prima
    private boolean isBilanganPrima(int angka) {
        if (angka <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                return false;
            }
        }
        return true;
    }    
    
}
