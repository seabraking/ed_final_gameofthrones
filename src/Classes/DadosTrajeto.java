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
public class DadosTrajeto<T> implements Comparable<T> {

    private double kms, dur, custo;
    private Cidade cidadeDestino;

    public DadosTrajeto(double kms, double dur, double custo, Cidade cidadeDestino) {
        this.kms = kms;
        this.dur = dur;
        this.custo = custo;
        this.cidadeDestino = cidadeDestino;
    }

 

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public double getDur() {
        return dur;
    }

    public void setDur(double dur) {
        this.dur = dur;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    @Override
    public int compareTo(T o) {
        DadosTrajeto dadosTrajetoCompare = (DadosTrajeto) o;
        if (dadosTrajetoCompare.kms < kms) {
            return 1;
        }
        return -1;
    }

}
