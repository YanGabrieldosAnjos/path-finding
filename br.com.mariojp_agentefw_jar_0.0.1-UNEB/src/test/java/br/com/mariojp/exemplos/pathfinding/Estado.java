package br.com.mariojp.exemplos.pathfinding;

import br.com.mariojp.ai.agent.AbstractState;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file Estado.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * <p>Classe que representa a o Ambiente para o problema do Aspirador</p>
 *
 */
public class Estado extends AbstractState {
	private int[] posicaoAtual = new int[2];
	private int[] posicaoDestino = new int[2];
	private LoadMap mapa;
	
    public Estado(LoadMap mapa){
        String[][] map = mapa.getMap();

        for(int i = 0; i < map.length; i++ ){
        for (int j = 0; j < map[i].length; j++){
            if(map[i][j].equals("@")){
                    this.posicaoAtual[0] = i;
                    this.posicaoAtual[1] = j;
            }

            if(map[i][j].equals("&")){
                this.posicaoDestino[0] = i;
                this.posicaoDestino[1] = j;
            }
        }
    }

        this.mapa = mapa;
	}
	
    public Object clone() {
        Object copia = null;
        try {
            copia = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copia;
    }
	
	public boolean equals(Object arg0) {
        Estado outro = (Estado) arg0;
        int[] posicaoAtual = this.getPosicaoAtual();
        int[] posicaoOutro = outro.getPosicaoAtual();
        return (posicaoAtual[0] == posicaoOutro[0]) && (posicaoAtual[1] == posicaoOutro[1]);
	}

	public String[][] getMapa() {
        return mapa.getMap();
    }
	
    public void setMapa(String[][] map) {
        this.mapa.setMap(map);
    }

    public int[] getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int[] posicaoAtual) {
        String[][] newMap = this.mapa.getMap();
        int oldRow = this.posicaoAtual[0];
        int oldColumn = this.posicaoAtual[1];
        int newRow = posicaoAtual[0];
        int newColumn = posicaoAtual[1];
        newMap[oldRow][oldColumn] = LoadMap.EMPTY_SPACE;
        newMap[newRow][newColumn] = LoadMap.ORIGIN;
        setMapa(newMap);
        this.posicaoAtual = posicaoAtual;
    }

    public int[] getPosicaoDestino() {
        return posicaoDestino;
    }

    public void setPosicaoDestino(int[] posicaoDestino) {
        this.posicaoDestino = posicaoDestino;
    }

	public String toString(){
		StringBuffer sb = new StringBuffer();
		// sb.append("[Posicao Atual:  " + posicaoAtual[0] + "," + posicaoAtual[1] + "]" + "\n");
		return sb.toString();
	}
}
