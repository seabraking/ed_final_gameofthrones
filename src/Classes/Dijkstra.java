package Classes;

import ED_12_Parte1_Ex2.EmptyCollectionException;
import ED_12_Parte1_Ex2.LinkedQueue;





public class Dijkstra<T> {
private static String ultimaVisita="NONEVALUE";
private static int lastAdjVisited = 4;
    public static void setUltimaVisita(String ultimaVisita) {
        Dijkstra.ultimaVisita = ultimaVisita;
    }

    public static void setLastAdjVisited(int lastAdjVisited) {
        Dijkstra.lastAdjVisited = lastAdjVisited;
    }

   

    public static int getLastAdjVisited() {
        return lastAdjVisited;
    }
    
    
    
    public static void CaminhoMaisCurto(Cidade source,int exercito) {
        source.setMinDistance(0.);
        LinkedQueue<Cidade> cidadesQueue = new LinkedQueue<>();
        cidadesQueue.enqueue(source);
        int count=0;
        while (!cidadesQueue.isEmpty()) {
            Cidade u = cidadesQueue.dequeue();

            // Visit each edge exiting u
            for (DadosTrajeto e : u.getAdjacencies()) {
                if (e != null) {
                    Cidade v = e.getCidadeDestino();
                        
                    double perdaCaminho = e.getCusto()*e.getKms();
                    double weight = 100*Math.pow((e.getCidadeDestino().getDefesa()/10),1.8);
                    double tot = u.getTotaljornada() +e.getDur();
                    double distanceThroughU = u.getMinDistance() + weight + perdaCaminho;
                    if (distanceThroughU < v.getMinDistance() + weight + perdaCaminho) {
                        //cidadesQueue.remove(v);
                        v.setTotaljornada(tot);
                        v.setPerdasPorCombate(weight + perdaCaminho);
                        v.setMinDistance(distanceThroughU);
                        v.setPrevious(u);
                        cidadesQueue.enqueue(v);
                    }
                      }
                }
            cidadesQueue.remove(u);
        }
    }
    
    public static void TresCaminhosMaisCurtos(Cidade source) {
        source.setMinDistance(0.);
        LinkedQueue<Cidade> cidadesQueue = new LinkedQueue<>();
        cidadesQueue.enqueue(source);
        int count=0;
        while (!cidadesQueue.isEmpty()) {
            Cidade u = cidadesQueue.dequeue();

            // Visit each edge exiting u
            for (DadosTrajeto e : u.getAdjacencies()) {
                if (e != null) {
                    Cidade v = e.getCidadeDestino();
                    if(!v.getNome().contains(ultimaVisita)){
                        
                  
                    double weight = e.getKms();
                    double distanceThroughU = u.getMinDistance() + weight;
                    if (distanceThroughU < v.getMinDistance()) {
                        //cidadesQueue.remove(v);
                            
                        v.setMinDistance(distanceThroughU);
                        v.setPrevious(u);
                        cidadesQueue.enqueue(v);
                        
                        //testes
                        if(count==1){ 
                        ultimaVisita = e.getCidadeDestino().getNome();
                        }
                        count++;
                    }
                      }
                }
            }
            cidadesQueue.remove(u);
        }
    }
    

    public static void CaminhomaisBarato(Cidade source) {
        source.setMinCusto(0.);
        LinkedQueue<Cidade> cidadesQueue = new LinkedQueue<>();
        cidadesQueue.enqueue(source);

        while (!cidadesQueue.isEmpty()) {
            Cidade u = cidadesQueue.dequeue();

            // Visit each edge exiting u
            for (DadosTrajeto e : u.getAdjacencies()) {
                if (e != null) {
                    Cidade v = e.getCidadeDestino();

                    double custo = e.getCusto();
                    double custoPara = u.getMinCusto() + custo;
                    if (custoPara < v.getMinCusto()) {
                        cidadesQueue.remove(v);

                        v.setMinCusto(custoPara);
                        v.setPrevious(u);
                        cidadesQueue.enqueue(v);
                    }
                }
            }
        }
    }

    public static void CaminhomaisRapido(Cidade source) {
        source.setMinDuracao(0.);
        LinkedQueue<Cidade> cidadesQueue = new LinkedQueue<>();
        cidadesQueue.enqueue(source);

        while (!cidadesQueue.isEmpty()) {
            Cidade u = cidadesQueue.dequeue();

            // Visit each edge exiting u
            for (DadosTrajeto e : u.getAdjacencies()) {
                if (e != null) {
                    Cidade v = e.getCidadeDestino();

                    double duracao = e.getDur();
                    double duracaoPara = u.getMinDuracao() + duracao;
                    if (duracaoPara < v.getMinDuracao()) {
                        cidadesQueue.remove(v);

                        v.setMinDuracao(duracaoPara);
                        v.setPrevious(u);
                        cidadesQueue.enqueue(v);
                    }
                }
            }
        }
    }

    public static LinkedQueue getCaminho_calculado(Cidade target) {
        LinkedQueue<Cidade> path = new LinkedQueue<Cidade>();
        for (Cidade vertex = target; vertex != null; vertex = vertex.getPrevious()) {
            path.enqueue(vertex);
        }

        //reverter o caminho
        return path;
    }

    public LinkedQueue apresenta_caminho_barato(T cidade1, T cidade2) throws EmptyCollectionException {
        Cidade ini = (Cidade) cidade1;
        Cidade fim = (Cidade) cidade2;
        CaminhomaisBarato(ini);
        if (fim.getMinCusto() != Double.POSITIVE_INFINITY) {
            System.out.println("Custo de " + ini + " para " + fim + ": " + fim.getMinCusto());
         //   distancia = new DadosTrajeto(fim.getMinCusto(), 0, 0, ini);
            LinkedQueue<Cidade> path = getCaminho_calculado(fim);
            System.out.print("Caminho mais barato: ");
            LinkedQueue caminhos = new LinkedQueue();
            caminhos = path.listar_queue_inversa();
            System.out.println(" ");
            return caminhos;
        } else {
            System.out.println("Não existem caminhos possíveis de " + ini.getNome() + " para " + fim.getNome() + "\n");
            return null;
        }
    }

    public LinkedQueue apresenta_caminho_rapido(T cidade1, T cidade2) throws EmptyCollectionException {
        Cidade ini = (Cidade) cidade1;
        Cidade fim = (Cidade) cidade2;
        CaminhomaisRapido(ini);
        if (fim.getMinDuracao() != Double.POSITIVE_INFINITY) {
            System.out.println("Tempo de " + ini + " para " + fim + ": " + fim.getMinDuracao());
            LinkedQueue<Cidade> path = getCaminho_calculado(fim);
            System.out.print("Caminho de mais rapido: ");
            LinkedQueue caminhos = new LinkedQueue();
            caminhos = path.listar_queue_inversa();
            System.out.println(" ");
            return caminhos;
        } else {
            System.out.println("Não existem caminhos possíveis de " + ini.getNome() + " para " + fim.getNome() + "\n");
            return null;
        }

    }

    
    public LinkedQueue apresenta_caminho_curto(T cidade1, T cidade2,Double tot) throws EmptyCollectionException {
        Cidade ini = (Cidade) cidade1;
        Cidade fim = (Cidade) cidade2;
        CaminhoMaisCurto(ini,25000);
        if (fim.getMinDistance() != Double.POSITIVE_INFINITY && fim.getTotaljornada()<=tot) {
            System.out.println("Distancia de " + ini + "para " + fim + ": " + fim.getMinDistance());
           
            LinkedQueue<Cidade> path = getCaminho_calculado(fim);
            System.out.print("Caminho mais curto: ");
            LinkedQueue caminhos = new LinkedQueue();
            caminhos = path.listar_queue_inversa();
            System.out.println("");
            return caminhos;
        } else {
            System.out.println("Não existem caminhos possíveis de " + ini.getNome() + " para " + fim.getNome() + "\n");
            return null;
        }

    }
        public LinkedQueue apresenta_segundo_caminho_curto(T cidade1, T cidade2) throws EmptyCollectionException {
        Cidade ini = (Cidade) cidade1;
        Cidade fim = (Cidade) cidade2;
        TresCaminhosMaisCurtos(ini);
        if (fim.getMinDistance() != Double.POSITIVE_INFINITY) {
            System.out.println("2a Alternativa . Distancia de " + ini + "para " + fim + ": " + fim.getMinDistance());
           
            LinkedQueue<Cidade> path = getCaminho_calculado(fim);
            System.out.print("Caminho mais curto: ");
            LinkedQueue caminhos = new LinkedQueue();
            caminhos = path.listar_queue_inversa();
            System.out.println("");
            return caminhos;
        } else {
            System.out.println("Não existem caminhos possíveis de " + ini.getNome() + " para " + fim.getNome() + "\n");
            return null;
        }

    }
  

}
