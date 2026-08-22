package Aula_03_Iteracao_Objetos;

import exercicios.ContaBancaria;

class Produto {
    private String nomeProduto;
    private float preco;
    private int quantidadeEstoque;

    public Produto(String nomeProduto, float preco, int quantidadeEstoque) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;

        System.out.printf("Produto criado: %s | Preço: R$%.2f | Quantidade no Estoque: %d\n", this.nomeProduto,
                this.preco, this.quantidadeEstoque);
    }

    public String nome_produto() {
        return this.nomeProduto;
    }

    public float preco_produto() {
        return this.preco;
    }

    public void reduzir_estoque(int quantidadeReduzir) {
        // Verifica se tem estoque e se pode realizar a compra
        if (quantidadeReduzir <= quantidadeEstoque) {
            System.out.printf("Estoque compatível, compra pode ser efetuada.\n");
            quantidadeEstoque -= quantidadeReduzir;
        } else {
            throw new IllegalArgumentException("Quantidade indisponível em estoque. Compra não pode ser efetuada.\n");
        }
    }
}

    public class Compras {
        public static void main(String[] args) {

            ContaBancaria cc_Gabriel = new ContaBancaria(150);
            Produto cadeira = new Produto("Cadeira", 40f, 8);
            Pedido pedido1 = new Pedido("Gabriel", cadeira, 3);
            
            try {
                cc_Gabriel.comprar(pedido1);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }