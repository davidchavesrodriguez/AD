package org.example;

import javax.swing.*;
import java.util.Collection;

public class Flows3 {
    public static void main(String[] args) {
        Object[] platoFavorito = {"chícharos", "doce", "churros"};
        String s = (String) JOptionPane.showInputDialog(null, "o meu prato favorito é: ",
                "Introduce tu plato favorito", JOptionPane.PLAIN_MESSAGE, null, platoFavorito, "churros");
    }
}
