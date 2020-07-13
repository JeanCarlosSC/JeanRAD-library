package app.services;

public final class Logica{
    
    private Logica(){
    }

    /**
     * Este metodo retorna un boolean que verifica si un string es convertible o no a int.
     * @param cadena String con el int el cual se va a verificar
     * @return 
     */
    public static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
}
