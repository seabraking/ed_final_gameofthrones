/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Vitor
 */
public class DadosTrajeto {
     private double kms,dur,custo;

    public DadosTrajeto(double kms, double dur, double custo) {
        this.kms = kms;
        this.dur = dur;
        this.custo = custo;
    }

    
    
    
    public void setKms(double kms) {
        this.kms = kms;
    }

    public void setDur(double dur) {
        this.dur = dur;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    
    
    public double getKms() {
        return kms;
    }

    public double getDur() {
        return dur;
    }

    public double getCusto() {
        return custo;
    }
    
}
