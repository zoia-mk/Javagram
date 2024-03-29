import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthSentCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InputCode extends JPanel {
    private JTextField inputCode;
    private JButton nextForm;
    private BufferedImage background;
    private BufferedImage logo;
    private JButton hide;
    private JButton exit;
    private JPanel panellogo;
    private JLabel labelText;
    private JPanel panelText;
    private JPanel panelCode;
    private JPanel panelCodaInput;
    private ContactList contactList;
    private MyFrame myFrame;
    private InputNumber inputNumber;


    public InputCode() throws IOException {

        background = ImageIO.read(new File("sources/fon-sova.jpg"));
        logo = ImageIO.read(new File("sources/GUI Components/logo-mini.png"));

        inputCode.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(1);
            }
        });

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
        TelegramApiBridge bridge = inputNumber.getBridge();
        AuthSentCode sentCode = bridge.authSendCode(String.valueOf(inputNumber.getPhoneNumber()));
        String code = inputCode.getText();
        AuthAuthorization signIn = bridge.authSignIn(code);
        // System.out.println(signIn.getUser().getFirstName());

    }


    public JPanel getPanelCode() {
        return panelCode;
    }

    public JButton getHide() {
        return hide;
    }

    private void createUIComponents() {
        panelCode = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

        panellogo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 0, null);
            }
        };
        panelCodaInput = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 40, 153, 40);
            }
        };


    }

    public void addActionListenerForSwitchAction(ActionListener actionListener) throws IOException {

        nextForm.addActionListener(actionListener);
    }
}
