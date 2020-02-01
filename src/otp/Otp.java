package otp;

/**
 * @author JLDM
 */
public class Otp {

    private static final String nlChar = System.getProperty("line.separator");
    private String cuadOtp = "";
    private long cuadLen = 0;

    // <editor-fold defaultstate="collapsed" desc="Generar Otp">                 
    Otp(int maxBlq, int maxLin, int maxCol, int maxSym, int mode) {
        int blq = 0;
        int lin = 0;
        int col = 0;
        int sym = 0;
        long rndA = 0;
        long rndB = 0;
        String chr = null;
        ParamSys Parametros = new ParamSys();
        while (blq < maxBlq) {
            blq += 1;
            lin = 0;
            while (lin < maxLin) {
                lin += 1;
                col = 0;
                while (col < maxCol) {
                    col += 1;
                    sym = 0;
                    while (sym < maxSym) {
                        sym += 1;
                        rndA = Long.valueOf(Parametros.getidRandom());
                        switch (mode) {
                            case 1:
                                chr = calcCharMix(rndA);
                                break;
                            case 2:
                                chr = calcCharAlfa(rndA);
                                break;
                            case 3:
                                chr = calcCharNum(rndA);
                                break;
                            case 4:
                                chr = calcCharPwd(rndA);
                                break;
                            default:
                                chr = calcCharMix(rndA);
                                break;
                        }
                        cuadOtp += chr;
                    }
                    if (col < maxCol) {
                        cuadOtp += " ";
                    }
                }
                cuadOtp += nlChar;
            }
            cuadOtp += nlChar;
        }
        cuadLen = cuadOtp.length();
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Calcular Caracter Otp ALFABETICO"> 
    /**
     * 
     * @param rnd
     * @param tim
     * @return un caracter ascii ALFABETICO
     */
    private String calcCharAlfa(long rndA) {
        int abcInit = 65; //Primer ascii de nuestro alfabeto
        int abcMax = 26;  //Numero de caracteres de nuestro alfabeto
        String chr = null;
        char chs = 00;
        long clc = 0;

        // Prevenir negativos
        if (rndA < 0) {
            rndA = rndA * -1;
        }

        // Calculo con numeros simbolos y letras
        clc = (rndA % abcMax);
        clc = clc + abcInit;

        // Conversion ascii
        chs = (char) clc;
        chr = String.valueOf(chs);

        return chr;

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Calcular Caracter Otp NUMERICO"> 
    /**
     * 
     * @param rnd
     * @param tim
     * @return un caracter ascii NUMERICO
     */
    private String calcCharNum(long rndA) {
        int abcInit = 48; //Primer ascii de nuestro alfabeto
        int abcMax = 10;  //Numero de caracteres de nuestro alfabeto
        String chr = null;
        char chs = 00;
        long clc = 0;

        // Prevenir negativos
        if (rndA < 0) {
            rndA = rndA * -1;
        }

        // Calculo con numeros simbolos y letras
        clc = (rndA % abcMax);
        clc = clc + abcInit;

        // Conversion ascii
        chs = (char) clc;
        chr = String.valueOf(chs);

        return chr;

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Calcular Caracter Otp ALFANUMIX"> 
    /**
     * 
     * @param rnd
     * @param tim
     * @return un caracter ascii MIX
     */
    private String calcCharMix(long rndA) {
        int abcInit = 40; //Primer ascii de nuestro alfabeto
        int abcMax = 60;  //Numero de caracteres de nuestro alfabeto
        String chr = null;
        char chs = 00;
        long clc = 0;

        // Prevenir negativos
        if (rndA < 0) {
            rndA = rndA * -1;
        }

        // Calculo con numeros simbolos y letras
        clc = (rndA % abcMax);
        clc = clc + abcInit;

        // Conversion ascii
        chs = (char) clc;
        chr = String.valueOf(chs);

        return chr;

    }// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Calcular Caracter Otp PASS"> 
    /**
     * 
     * @param rnd
     * @return un caracter ascii PWD
     */
    private String calcCharPwd(long rndA) {
        int abcInit = 48; //Primer ascii de nuestro alfabeto
        int abcMax = 74;  //Numero de caracteres de nuestro alfabeto
        String chr = null;
        char chs = 00;
        long clc = 0;

        // Prevenir negativos
        if (rndA < 0) {
            rndA = rndA * -1;
        }

        // Calculo con numeros simbolos y letras
        clc = (rndA % abcMax);
        clc = clc + abcInit;

        // Conversion ascii
        chs = (char) clc;
        chr = String.valueOf(chs);

        return chr;

    }// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Leer Otp">    
    /**
     * 
     * @return el cuaderno asignado
     */
    public String getCuadStr() {
        return cuadOtp;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Poner Otp">    
    /**
     * 
     * @param el cuaderno asignado
     * @return Asigna un cuaderno y no retorna nada
     */
    public void setCuadStr(String cuadStr) {
        this.cuadOtp = cuadStr;
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Leer longitudOtp">    
    /**
     * 
     * @return longitud del cuaderno asignado
     */
    public String getCuadLen() {
        return String.valueOf(cuadLen);
    }// </editor-fold>
}

/**
 * @author JLDM
 */
class OtpProcesador {

    private static final String nlChar = System.getProperty("line.separator");
    private String cuadOtp = "";
    private String cuadPer = "";
    private String cuadMsg = "";
    private int cuaOffset = 0;

    // <editor-fold defaultstate="collapsed" desc="Leer offset localizado por el codificador">    
    /**
     * 
     * @return offset de este cuaderno
     */
    public int getOffset() {
        return this.cuaOffset;
    }// </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Crear cuaderno de trabajo">    
    /**
     * @param Otp de claves
     * @param mensaje claro
     * @return Otp codificado
     */
    OtpProcesador(String cuad) {
        cuadOtp = cuad;
        cuadPer = "";
        cuadMsg = "";
        cuaOffset = 0;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Cancelar cuaderno de trabajo">    
    /**
     * @return  void
     */
    public void cancel() {
        cuadOtp = "";
        cuadPer = "";
        cuadMsg = "";
        cuaOffset = 0;
    }// </editor-fold>      

    // <editor-fold defaultstate="collapsed" desc="Codificar Mensaje con el cuaderno">    
    /**
     * @param mensaje Claro
     * @param offset Deseado
     * @return mensaje Codificado
     */
    public String codificar(String msgClaro, int offset) {
        String cuaCodif = "";
        String strTmp = "";
        msgClaro = msgClaro.toUpperCase();
        int cuaLen = cuadOtp.length();
        int msgLen = msgClaro.length();
        int cuaPos = 0;
        int msgPos = 0;
        char msgChr = 0;
        char cuaChr = 0;
        char cuaSpc = 32; // Caracter espacio
        char cuaPer = 35; // Caracter perforacion

        // Preparar mensaje en claro eliminando los caracteres
        // no validos (ascii <36 y ascii>100)
        while (msgPos < msgLen) {
            msgChr = msgClaro.charAt(msgPos);
            if (msgChr < 36 || msgChr > 100) {
                strTmp = strTmp;
            } else {
                strTmp = strTmp + msgChr;
            }
            msgPos++;
        }
        msgClaro = strTmp;
        strTmp = "";
        msgPos = 0;
        msgChr = 0;
        
        // Coger nueva  longitud del mensaje claro
        msgLen = msgClaro.length();
        
        // Aplicar offset si lo hay
        while (cuaPos < offset) {
            cuaChr = cuadOtp.charAt(cuaPos);
            // Comprobar si el caracter correspondiente del otp es de control
            if (cuaChr > 31) {
                // Si no lo es ponemos un espacio
                cuaCodif = cuaCodif + cuaSpc;
            } else {
                // Si lo es ponemos el de control
                cuaCodif = cuaCodif + cuaChr;
            }
            cuaPos++;
        }

        // Bucle para codificar el mensaje claro con el OTP en curso
        while (msgPos < msgLen && cuaPos < cuaLen) {
            msgChr = msgClaro.charAt(msgPos);
            cuaChr = cuadOtp.charAt(cuaPos);
  
            // Comprobar si el caracter del mensaje coincide con el del OTP
            if (msgChr == cuaChr) {

                // El caracter actual coincide con el del OTP
                // Si NO SE TRATA de un espacio añadimos una marca de perforacion
                if (msgChr != cuaSpc) {
                    cuaCodif = cuaCodif + cuaPer;
                } else {
                    // Si SE TRATA de un espacio añadimos el espacio
                    cuaCodif = cuaCodif + cuaSpc;
                }
                msgPos++;
            } 
            else 
            {
                // El caracter del mensaje no coincide con el del OTP
                // Si NO SE TRATA de un caracter de control añadimos un espacio
                if (cuaChr > 31) {
                    cuaCodif = cuaCodif + cuaSpc;
                } else {
                    // Si SE TRATA de un caracter de control lo añadimos para
                    // conservar el formato del OTP (CR+LFs)
                    cuaCodif = cuaCodif + cuaChr;
                }
            }
            cuaPos++;
        }

        // Guardar posicion primera perforacion
        cuaOffset = cuaCodif.indexOf(cuaPer);

        // Comprobar si el mensaje se ha codificado completamente
        if (msgPos < msgLen) {
            cuaCodif = cuaCodif + "!!! INCOMPLETO MSG > OTP !!!";
        } else {

            // Si HAY OFFSET hay que trimar el cuaderno codificado = cifrado
            // para ocultar el valor del offset a la vista
            if (offset > 0) {
                strTmp = cuaCodif.trim();
                cuaCodif = strTmp;
                strTmp = "";
            }
        }

        // Retornar cuaderno codificado
        return cuaCodif;
    }// </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Decodificar Mensaje con el cuaderno">    
    /**
     * @param mensaje Codificado
     * @param offset Deseado
     * @return mensaje Decodificado
     */
    public String decodificar(String msgCodif, int offset) {
        String msgClaro = "";
        String msgTmp = "";
        int cuaLen = cuadOtp.length();
        int msgLen = msgCodif.length();
        int cuaPos = 0;
        int msgPos = 0;
        char msgChr = 0;
        char cuaChr = 0;
        char cuaSpc = 32; // Caracter espacio
        char cuaPer = 35; // Caracter perforacion

        // Aplicar offset (si lo hay) saltandonos esos caracteres
        while (cuaPos < offset) {
            cuaPos++;
        }

        // Decodificar mensaje
        while (cuaPos < cuaLen) {

            // Coger el caracter correspondiente del OTP para tenerlo preparado
            cuaChr = cuadOtp.charAt(cuaPos);

            // Comprobar si el caracter a decodificar esta en el rango de la
            // longitud del mensaje codificado
            if (msgPos < msgLen) {
                // Si ESTA EN EL RANGO cogemos el caracter codificado (espacio o
                // perforacion)
                msgChr = msgCodif.charAt(msgPos);
            } else {
                // Si NO ESTA EN EL RANGO cogemos un espacio para no generar 
                // errores de strings
                msgChr = cuaSpc;
            }
            
            // Comprobar si hemos encontrado una perforacion en el mensaje
            if (msgChr == cuaPer) {
                
                // En tal caso YA TENIAMOS LEIDO el caracter decodificado que 
                // corresponde y lo añadimos al final del mensaje claro
                msgClaro = msgClaro + cuaChr;
            }

            // Incrementar punteros
            cuaPos++;
            msgPos++;
        }
        return msgClaro;
    }// </editor-fold>    
}
