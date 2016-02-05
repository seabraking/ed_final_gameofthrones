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
        DadosTrajeto[] novo = new DadosTrajeto[this.ligacoes.length + DEFAULT_CAPACITY];
        System.arraycopy(novo, this.num_cidades, this.ligacoes, 0, this.num_cidades);
        return novo;
    }

    public void adicionar_trajeto(Cidade cidadefinal, double distancia, double duracao, double custo) {
        if (isEmpty()) {
            this.ligacoes[0] = new DadosTrajeto(distancia, duracao, custo, cidadefinal);
            this.num_cidades++;
        } else if (this.num_cidades == this.ligacoes.length) {
            this.ligacoes = expandCapacity();
            this.ligacoes[this.num_cidades] = new DadosTrajeto(distancia, duracao, custo, cidadefinal);
            this.num_cidades++;
        } else {
            this.ligacoes[this.num_cidades] = new DadosTrajeto(distancia, duracao, custo, cidadefinal);
            this.num_cidades++;
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
}
