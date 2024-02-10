package Core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setTheme() {
        OptionPane();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
    public static boolean confirm(String str) {
        String msg = str.equals("Yes") ? "Please confirm deletion." : str;
        return JOptionPane.showConfirmDialog(null, msg, "Are you sure?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static void showMsg(String str) {
        String msg;
        String title;
        switch (str) {
            case "fill" -> {
                msg = "Please fill in the required fields !";
                title = "Error!";
            }
            case "done" -> {
                msg = "Sucess !";
                title = "Result";
            }
            case "notFound" -> {
                msg = "No record found !";
                title = "No record found";
            }
            case "error" -> {
                msg = "You have made an error !";
                title = "Error!";
            }
            default -> {
                msg = str;
                title = "Message";
            }
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }


    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    public static void OptionPane() {
        UIManager.put("Optionpane.okButtonText", "Okay");
        UIManager.put("Optionpane.yesButtonText", "Yes");
        UIManager.put("Optionpane.noButtonText", "No");
    }
}