package br.com.mariojp.exemplos.bestpath;

public class Main {

  public static void main(String[] args) {
    GenerateMaps genMap = new GenerateMaps();
    AgenteBestPath agente = new AgenteBestPath();

    for (int numeroDoMapa = 1; numeroDoMapa <= 100; numeroDoMapa++) {
      genMap.exec(numeroDoMapa);
      
      for (int numeroDoAgente = 0; numeroDoAgente < 5; numeroDoAgente++) {
        agente.exec(numeroDoAgente, numeroDoMapa);
      }
    }
  }
}
