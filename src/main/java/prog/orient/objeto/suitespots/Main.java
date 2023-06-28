package prog.orient.objeto.suitespots;

import prog.orient.objeto.suitespots.controller.CRUDHelper;
import prog.orient.objeto.suitespots.models.Cliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pedro
 */
public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente(0, "Pedro Lucas", "Pedro", "05770449152", "066999425980", 'M',
                "pedrolucascaratti@gmail.com", 1, "Rua São Caetano", 1115, "Jardim Riva", "Primavera do Leste", "MT",
                "LINDO DEMAIS");

        CRUDHelper.getInstance().create(c);
    }
}
