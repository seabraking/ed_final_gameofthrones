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
public class Cidade implements Comparable<Cidade> {

    private final int DEFAULT_CAPACITY = 8;
    private final String nome;
    private int defesa;
    private DadosTrajeto[] ligacoes;

    private double minDistance = Double.POSITIVE_INFINITY;
    private double minCusto = Double.POSITIVE_INFINITY;
    private double minDuracao = Double.POSITIVE_INFINITY;
    private int num_cidades;
    private Cidade previous;
private double totaljornada = 0.;
    private double custoMaximoemTermosUnidadeMilitar = Double.POSITIVE_INFINITY;
    private double perdasPorCombate;

    public double getTotaljornada() {
        return totaljornada;
    }

    public void setTotaljornada(double totaljornada) {
        this.totaljornada = totaljornada;
    }

    public double getCustoMaximoemTermosUnidadeMilitar() {
        return custoMaximoemTermosUnidadeMilitar;
    }

    public void setCustoMaximoemTermosUnidadeMilitar(double custoMaximoemTermosUnidadeMilitar) {
        this.custoMaximoemTermosUnidadeMilitar = custoMaximoemTermosUnidadeMilitar;
    }

    public double getPerdasPorCombate() {
        return perdasPorCombate;
    }

    public void setPerdasPorCombate(double perdasPorCombate) {
        this.perdasPorCombate = perdasPorCombate;
    }
    
    
    
    public Cidade(String nome, int defesa) {
        this.nome = nome;
        this.defesa = defesa;
        this.ligacoes = new DadosTrajeto[DEFAULT_CAPACITY];
        this.num_cidades = 0;
    }

    public String toString() {
        return nome;
    }

    public int compareTo(Cidade other) {
        return nome.compareTo(other.getNome());
    }

    public String getNome() {
        return nome;
    }

    public int getDefesa() {
        return defesa;
    }

    public DadosTrajeto[] getAdjacencies() {
        return ligacoes;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public Cidade getPrevious() {
        return previous;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAdjacencies(DadosTrajeto[] adjacencies) {
        this.ligacoes = adjacencies;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public void setPrevious(Cidade previous) {
        this.previous = previous;
    }

    public int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public int getNum_cidades() {
        return num_cidades;
    }

    public void setNum_cidades(int num_cidades) {
        this.num_cidades = num_cidades;
    }

    public boolean isEmpty() {
        return this.num_cidades == 0;
    }

    private DadosTrajeto[] expandCapacity() {
        DadosTrajeto[] novo = new DadosTrajeto[ligacoes.length*2];
        for (int i = 0; i < ligacoes.length; i++) {
            novo[i] = ligacoes[i];
        }
        return novo;
    }

    public void add_DadosTrajeto(Cidade cfinal, double km, double dur, double custo) {
        if (isEmpty()) {
            ligacoes[0] = new DadosTrajeto(km, dur, custo, cfinal);
            num_cidades++;
        } else if (num_cidades == ligacoes.length) {
            ligacoes = expandCapacity();
            ligacoes[num_cidades] = new DadosTrajeto(km, dur, custo, cfinal);
            num_cidades++;
        } else {
            ligacoes[num_cidades] = new DadosTrajeto(km, dur, custo, cfinal);
            num_cidades++;
        }
    }

    public double getMinCusto() {
        return minCusto;
    }

    public void setMinCusto(double minCusto) {
        this.minCusto = minCusto;
    }

    public double getMinDuracao() {
        return minDuracao;
    }

    public void setMinDuracao(double minDuracao) {
        this.minDuracao = minDuracao;
    }

    public void eliminarAdj(int trajeto) {

        for (int i = trajeto; i < num_cidades; i++) {
            ligacoes[i]= ligacoes[i+1];
        }
         num_cidades--;
    }

    public int getAdjIndex(Cidade segundaCidade) {
    
    int menor = -1;
    double custo = Double.POSITIVE_INFINITY;
    
   for (int i = 0; i < num_cidades; i++) {
            if(ligacoes[i].getCidadeDestino().compareTo(segundaCidade)==0 && ligacoes[i].getCusto()<custo){
                menor=i;
            }
        }
         return menor;
    
    }
  
}
