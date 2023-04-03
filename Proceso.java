/*
 * Daniel Machic (22118)
 * HT8
 * Esta clase almacenará la información de los procesos
 */

public class Proceso implements Comparable<Proceso> {

    private String ProssName;
    private String UserName;
    private int PrioVal;
    private int NiceVal;
    
    /**
     * Parametros de la clase
     * @param ProssName almacena el nombre del proceso
     * @param UserName almacena el nombre del usuario
     * @param NiceVal almacena el valor nice el proceso
     * @param PrioVal almacena el valor de la prioridad
     */

    public Proceso(String ProssName, String UserName, int NiceVal) { 
        this.ProssName = ProssName;
        this.UserName = UserName;
        this.NiceVal = NiceVal;
        this.PrioVal = NiceVal + 120; 
    }

        /** @return String */

        public String getProssName() {return ProssName;}
    
        /** @param ProssName */
    
        public void setProssName(String ProssName) {this.ProssName = ProssName;}
    
        /** @return String */
    
        public String getUserName() {return UserName}
    
        /**@param UserName */
        
        public void setUserName(String UserName) {this.UserName = UserName;}

        /** @return int */

        public int getNiceVal() {return NiceVal}

        
}

