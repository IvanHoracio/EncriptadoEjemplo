package com.example.ivan_.encriptadoejemplo;

public class CifradorDescifradorSustitucion {
    private final String abc = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    private int desplazamiento;
    private String textoPlano;
    private String textoCifrado;

    public CifradorDescifradorSustitucion() {
        desplazamiento = 0;
    }

    public CifradorDescifradorSustitucion(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public String descifrar(String textoCifrado) {
        char caracterCifrado = ' ';
        char caracterPlano = ' ';

        textoCifrado = textoCifrado.toUpperCase();
        StringBuilder textoPlano = new StringBuilder(textoCifrado.length());

        for (int i = 0; i < textoCifrado.length(); i++) {
            caracterCifrado = textoCifrado.charAt(i);
            if (abc.contains(String.valueOf(caracterCifrado))) {
                int posCaracterCifrado = abc.indexOf(caracterCifrado);
                int posCaracterPlano = ((posCaracterCifrado - desplazamiento) + (abc
                        .length() + 1)) % (abc.length());
                caracterPlano = abc.charAt(posCaracterPlano);
            } else {
                caracterPlano = caracterCifrado;
            }
            textoPlano.append(caracterPlano);
        }

        return textoPlano.toString();
    }

    public String cifrar(String textoPlano) {
        char caracterCifrado = ' ';
        char caracterPlano = ' ';

        textoPlano = textoPlano.toUpperCase();
        StringBuilder textoCifrado = new StringBuilder(textoPlano.length());

        for (int i = 0; i < textoPlano.length(); i++) {
            caracterPlano = textoPlano.charAt(i);
            if (abc.contains(String.valueOf(caracterPlano))) {
                int posCaracterPlano = abc.indexOf(caracterPlano);
                int posCaracterCifrado = (posCaracterPlano + desplazamiento)
                        % (abc.length());
                caracterCifrado = abc.charAt(posCaracterCifrado);
            } else {
                caracterCifrado = caracterPlano;
            }
            textoCifrado.append(caracterCifrado);
        }
        return textoCifrado.toString();
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public String getTextoPlano() {
        return textoPlano;
    }

    public void setTextoPlano(String textoPlano) {
        this.textoPlano = textoPlano;
    }

    public String getTextoCifrado() {
        return textoCifrado;
    }

    public void setTextoCifrado(String textoCifrado) {
        this.textoCifrado = textoCifrado;
    }
}
