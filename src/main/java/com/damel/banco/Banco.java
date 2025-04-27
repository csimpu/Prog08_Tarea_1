/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.banco;

import com.damel.objetos.CuentaBancaria;

/**
 * Clase Banco<br>
 *
 * Clase que gestiona la funcionalidad del banco.<br>
 *
 * Permite gestionar las cuentas bancarias<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Banco {

    // Defino el array y el contador de cuentas bancarias
    private CuentaBancaria[] cuentas;
    private int contador;

    /**
     * Constructor de la clase.<br>
     *
     * Inicializa el array y el contador.
     */
    public Banco() {
        cuentas = new CuentaBancaria[100];
        contador = 0;
    }

    /**
     * Abre una nueva cuenta bancaria.<br>
     *
     * Comprueba que hay espacio disponible en el array, y añade la nueva cuenta
     * en la posición indicada por el contador
     *
     * @param cuenta la cuenta bancaria
     * @return devuelve {@code true} si la cuenta se añade.<br>> devuelve (@code
     * false) si no hay espacio en el array
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        if (contador < cuentas.length) {
            cuentas[contador] = cuenta;
            contador++;
            return true;
        }
        return false;
    }

    /**
     * Genera un listado con información básica de todas las cuentas del banco
     *
     * @return devuelve la lista con el formato especificado
     */
    public String[] listadoCuentas() {
        String[] listado = new String[contador];
        for (int i = 0; i < contador; i++) {
            listado[i] = cuentas[i].getIban()
                    + "\n" + cuentas[i].getTitular().getNombre() + " " + cuentas[i].getTitular().getApellidos()
                    + "\n" + cuentas[i].getSaldo() + " Eur";
        }
        return listado;
    }

    /**
     * Busca una cuenta por su IBAN y muestra toda la información de esa cuenta,
     * comparando los IBAN de las cuentas almacenadas en el array
     * {@code cuentas} con el IBAN proporcionado.
     *
     * @param iban El IBAN de la cuenta
     * @return devuelve una {@code String} con la información completa de la
     * cuenta si encuentra el IBAN.<br>
     * devuelve {@code null} si no hay coincidencia.
     */
    public String informacionCuenta(String iban) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].devolverInfoString();
            }
        }
        return null;
    }

    /**
     * Realiza un ingreso en la cuenta.<br>
     * Busca una cuenta por su IBAN e ingresa una cantidad en esa cuenta
     *
     * @param iban El IBAN de la cuenta donde se hará el ingreso.
     * @param cantidad La cantidad que se ingresará
     * @return devuelve {@code true} si el IBAN está en el banco.<br>
     * devuelve {@code false} si no encuentra el IBAN.
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                cuentas[i].ingresar(cantidad);
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza una retirada de efectivo en la cuenta.<br>
     * Busca una cuenta por su IBAN y retira una cantidad en esa cuenta
     *
     * @param iban El IBAN de la cuenta donde se hará la retirada.
     * @param cantidad La cantidad que se retirará
     * @return devuelve {@code true} si se cumple la condición de 
     * {@link CuentaBancaria#retirar(double)}.<br>
     * devuelve {@code false} si no encuentra el IBAN.
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].retirar(cantidad);
            }
        }
        return false;
    }

    /**
     * Obtiene el saldo de una cuenta específica.<br>
     * Busca una cuenta por su IBAN y muestra el saldo que tiene esa cuenta.
     * @param iban El IBAN de la cuenta
     * @return devuelve el saldo de la cuenta si encuentra el IBAN.<br>
     * devuelve {@code -1} si no encuentra el IBAN.
     */
    public double obtenerSaldo(String iban) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].getSaldo();
            }
        }
        return -1;
    }

}
