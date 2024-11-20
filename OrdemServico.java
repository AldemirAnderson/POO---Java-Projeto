import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
    private static int contadorOrdens = 1;
    private int numeroOrdem;
    private Cliente cliente;
    private String marcaAparelho;
    private String modeloAparelho;
    private String numeroSerieAparelho;

    private static List<OrdemServico> ordens = new ArrayList<>();

    public OrdemServico(Cliente cliente, String marcaAparelho, String modeloAparelho, String numeroSerieAparelho) {
        this.numeroOrdem = contadorOrdens++;
        this.cliente = cliente;
        this.marcaAparelho = marcaAparelho;
        this.modeloAparelho = modeloAparelho;
        this.numeroSerieAparelho = numeroSerieAparelho;
        ordens.add(this);
    }

    public static OrdemServico getOrdemPorNumero(int numero) {
        for (OrdemServico ordem : ordens) {
            if (ordem.numeroOrdem == numero) {
                return ordem;
            }
        }
        return null; 
    }

    @Override
    public String toString() {
        return String.format("Ordem de Serviço: %03d\nCliente: %s\nAparelho: %s %s, Número de Série: %s",
                numeroOrdem, cliente, marcaAparelho, modeloAparelho, numeroSerieAparelho);
    }
}