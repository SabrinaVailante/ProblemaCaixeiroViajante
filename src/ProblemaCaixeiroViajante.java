import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProblemaCaixeiroViajante {
    private static final String CAMINHO_ARQUIVO = "C:\\Users\\sabri\\OneDrive\\Documentos\\Projetos\\ProblemaDoCaixeiroViajante\\src\\distancias_minas_gerais.csv";
    private static final int NUM_CIDADES = 15;

    private Map<String, Integer> indicesCidades;
    private int[][] distancias;

    public ProblemaCaixeiroViajante() {
        indicesCidades = new HashMap<>();
        distancias = new int[NUM_CIDADES][NUM_CIDADES];
    }

    public void carregarDistancias(String caminhoArquivo) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linha = leitor.readLine(); // Ignorar a primeira linha (cabeçalho)

            int indiceCidade = 0;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                String nomeCidade = partes[0].replaceAll("\"", ""); // Remover as aspas duplas
                indicesCidades.put(nomeCidade, indiceCidade);

                String[] distanciasStr = Arrays.copyOfRange(partes, 1, partes.length);
                for (int i = 0; i < distanciasStr.length; i++) {
                    int distancia = Integer.parseInt(distanciasStr[i]);
                    distancias[indiceCidade][i] = distancia;
                    distancias[i][indiceCidade] = distancia; // Considere que a distância é bidirecional
                }

                indiceCidade++;
            }

            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNomeCidade(int indiceCidade) {
        for (Map.Entry<String, Integer> entrada : indicesCidades.entrySet()) {
            if (entrada.getValue() == indiceCidade) {
                return entrada.getKey();
            }
        }
        return null;
    }

    public List<Integer> encontrarRota(int cidadeInicial) {
        List<Integer> rota = new ArrayList<>();
        boolean[] visitadas = new boolean[NUM_CIDADES];
        rota.add(cidadeInicial);
        visitadas[cidadeInicial] = true;
        while (rota.size() < NUM_CIDADES) {
            int cidadeAtual = rota.get(rota.size() - 1);
            int proximaCidade = -1;
            int menorDistancia = Integer.MAX_VALUE;
            for (int cidade = 0; cidade < NUM_CIDADES; cidade++) {
                if (!visitadas[cidade] && distancias[cidadeAtual][cidade] < menorDistancia) {
                    menorDistancia = distancias[cidadeAtual][cidade];
                    proximaCidade = cidade;
                }
            }
            rota.add(proximaCidade);
            visitadas[proximaCidade] = true;
        }
        rota.add(cidadeInicial); // Retornar à cidade inicial
        return rota;
    }
    public int calcularDistanciaTotal(List<Integer> rota) {
        int distanciaTotal = 0;
        for (int i = 0; i < rota.size() - 1; i++) {
            int cidadeA = rota.get(i);
            int cidadeB = rota.get(i + 1);
            distanciaTotal += distancias[cidadeA][cidadeB];
        }
        return distanciaTotal;
    }
    public void carregarCidades() {
        List<Map.Entry<String, Integer>> listaCidades = new ArrayList<>(indicesCidades.entrySet());
        Collections.sort(listaCidades, Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entrada : listaCidades) {
            String nomeCidade = entrada.getKey();
            int indiceCidade = entrada.getValue();
            System.out.println(indiceCidade + ", " + nomeCidade);
        }
    }
    public static void main(String[] args) {
        ProblemaCaixeiroViajante pcv = new ProblemaCaixeiroViajante();
        pcv.carregarDistancias(CAMINHO_ARQUIVO);
        pcv.carregarCidades();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n \n Qual o indice da cidade de origem? ");
        int cidadeOrigem = scanner.nextInt();

        List<Integer> rota = pcv.encontrarRota(cidadeOrigem);
        int distanciaTotal = pcv.calcularDistanciaTotal(rota);

        System.out.println("Rota:");
        for (int indiceCidade : rota) {
            String nomeCidade = pcv.getNomeCidade(indiceCidade);
            System.out.println("Cidade " + nomeCidade);
        }
        System.out.println("Distância total percorrida: " + distanciaTotal + " km");

        scanner.close();
    }
}
