package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados{
    private Integer tabela[];
    
    public EstruturaHashTable() {
        tabela = new Integer[1100];

    }

    @Override
    public boolean insert(int key) {
        int tabelaIndi = CalculaInc(key); // calcular os indices para apenas as primeira 1000 casa;

        if(tabela[tabelaIndi] != null){
            
            tabelaIndi = Recalcular(key); // calcular o indice para as 100 ultimas casa adicionais.

            if(tabela[tabelaIndi] != null){
                int indice = 0;

                while(indice < 1000 && tabela[1000 - indice] != null){ // procurando o proximo indice da tabela que esteja nulo de trás pra frente.
                    indice++;
                }
                if(indice == 1000){ // significa que a tabela original está completamente cheia. 
                    return false;
                }

                tabela[1000 - indice] = key;
                return true;
            }

            tabela[tabelaIndi] = key; // inserir no porão agora como indice recalculado.
            return true;
        }

        tabela[tabelaIndi] = key;
        return true;

    }

    @Override
    public boolean delete(int chave){
        int tabelaIndi = CalculaInc(chave);

        if(tabela[tabelaIndi] != null){

            if(tabela[tabelaIndi] == chave){
                tabela[tabelaIndi] = null;
                return true;
            }

            tabelaIndi = Recalcular(chave);

            if(tabela[tabelaIndi] != null){
                if(tabela[tabelaIndi] == chave){
                    tabela[tabelaIndi] = null;
                    return true;
                }
                int i = 0;
                while(i < 1000 && tabela[1000 - i] != null){
                    i++;
                }
                if(i >= 1000){
                    return false;
                }
                else{
                    tabela[1000 - i] = null;
                    return true;
                }
            }
        }
        else{
            tabelaIndi = Recalcular(chave);

            if(tabela[tabelaIndi] != null){
                if(tabela[tabelaIndi] == chave){
                    tabela[tabelaIndi] = null;
                    return true;
                }
                int i = 0;
                while(i < 1000 && tabela[1000 - i] != null){
                    i++;
                }
                if(i >= 1000){
                    return false;
                }
                else{
                    tabela[1000 - i] = null;
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    @Override
    public int search(int chave) {

        int tabelaIndi = CalculaInc(chave);

        if(tabela[tabelaIndi] != null){
            if(tabela[tabelaIndi] == chave){
                return chave;
            }
            else{
                tabelaIndi = Recalcular(chave);

                if(tabela[tabelaIndi] != null){
                    if(tabela[tabelaIndi] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                return -1;
            }
        }
        else{
            tabelaIndi = Recalcular(chave);

                if(tabela[tabelaIndi] != null){
                    if(tabela[tabelaIndi] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                else{
                    int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }

                        return -1;
                }
        }
    }
    
    public int Recalcular(int chave){
        int indiPorao = chave % 100;
        
        return (indiPorao + 1000); // adiciona o 1000 para que eeste seja inserido nas ultimas 100 casa.
    }

    public int CalculaInc(int chave){
        int indice = chave % 1000;
        
        return indice;
    }

}