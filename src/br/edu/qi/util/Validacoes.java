package br.edu.qi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.TextField;

/**
 * Classe de validações do projeto.
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 14:46
 */
public class Validacoes {

    private static final SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date;

    /**
     * Verifica se o conteudo do campo possui apenas números.
     *
     * @param numero Valor do campo.
     * @param campo Nome do campo que será verificado.
     * @param textField Campo que será verificado.
     * @return Retorna o número do campo caso exista.
     * @throws Exception
     */
    public static String validaNumero(String numero, String campo, TextField textField) throws Exception {
        try {
            float num = Float.parseFloat(numero);
            return numero;
        } catch (Exception e) {
            textField.requestFocus();
            throw new Exception("Digite um número válido no campo " + campo + ".");
        }
    }

    /**
     * Verifica se o campo possui algum texto.
     *
     * @param texto Texto do campo.
     * @param campo Nome do campo que será verificado.
     * @param textField Campo que será verificado.
     * @return Retorna o texto caso possua.
     * @throws Exception
     */
    public static String validaTexto(String texto, String campo, TextField textField) throws Exception {
        if (texto.trim().length() != 0) {
            return texto;
        }
        textField.requestFocus();
        throw new Exception("O campo " + campo + " não pode ser vazio.");
    }

    /**
     * Verifica se a data tem 10 caracteres antes de fazer chamar
     * {@link Validacoes#parseDataIso(java.lang.String) }.
     *
     * @param data Data que sera testada
     * @return true ou false.
     * @throws Exception
     */
    public static boolean validaData(String data) throws Exception {
        return data.length() != 10;
    }

    /**
     * Converte uma data no formato ISO em formato ABNT;
     *
     * @param dataIso Argumento que recebe data no formato ISO(yyyy-MM-dd);
     * @return Uma data no formato ABNT(dd/MM/yyyy)
     * @throws java.lang.Exception
     */
    public static String parseDtaBra(String dataIso) throws Exception {
        try {
            date = formatIso.parse(dataIso);
            return (formatBra.format(date));
        } catch (ParseException e) {
            throw new Exception("Formato da data é inválido " + dataIso);
        }
    }

    /**
     * Converte uma data no formato ABNT em formato ISO;
     *
     * @param dataBra Argumento que recebe data no formato ABNT(dd/MM/yyyy);
     * @return Uma data no formato ISO(yyyy-MM-dd).
     * @throws java.lang.Exception
     */
    public static String parseDataIso(String dataBra) throws Exception {
        try {
            date = formatBra.parse(dataBra);
            return (formatIso.format(date));
        } catch (ParseException e) {
            throw new Exception("Formato da data é inválido " + dataBra);
        }
    }

}
