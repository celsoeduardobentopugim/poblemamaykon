
import java.util.List;

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // getters e setters
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // getters e setters
}

class LojaApp {
    private List<Produto> produtos;

    public LojaApp() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto encontrarProdutoMaisBarato() {
        Produto maisBarato = null;
        double precoMaisBarato = Double.MAX_VALUE;

        for (Produto produto : produtos) {
            if (produto.getPreco() < precoMaisBarato) {
                maisBarato = produto;
                precoMaisBarato = produto.getPreco();
            }
        }

        return maisBarato;
    }

    public double calcularDesconto(double preco) {
        return preco * 0.15;
    }

    public double calcularPrecoParcelado(double preco, int parcelas) {
        return preco / parcelas;
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Fulano", "123.456.789-10");
        LojaApp loja = new LojaApp();

        Produto cama = new Produto("Cama", 500.0);
        Produto armario = new Produto("Armário", 700.0);
        Produto celular = new Produto("Smartphone Samsung", 2999.0);

        loja.adicionarProduto(cama);
        loja.adicionarProduto(armario);
        loja.adicionarProduto(celular);

        Produto maisBarato = loja.encontrarProdutoMaisBarato();
        double descontoCelular = loja.calcularDesconto(celular.getPreco());
        double precoParcelado = loja.calcularPrecoParcelado(celular.getPreco() - descontoCelular, 5);

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Produto mais barato: " + maisBarato.getNome());
        System.out.println("Desconto no celular: " + descontoCelular);
        System.out.println("Preço parcelado do celular em 5 vezes: " + precoParcelado);
    }
}