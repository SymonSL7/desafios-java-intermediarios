import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {
    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {
    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }
}

public class DesafioCofre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de cofre: digital ou fisico?");
        String tipoCofre = scanner.nextLine();

        Cofre cofre = null;

        if (tipoCofre.equalsIgnoreCase("digital")) {
            
            System.out.println("Digite a senha:");
            int senha = scanner.nextInt();
            System.out.println("Digite a senha novamente:");
            int confirmacaoSenha = scanner.nextInt();

            if (senha == confirmacaoSenha) {
                cofre = new CofreDigital(senha);
                cofre.imprimirInformacoes();
                System.out.println("Cofre aberto!");
            } else {
                cofre = new CofreDigital(senha);
                cofre.imprimirInformacoes();
                System.out.println("Senha incorreta!");
                return;
            }
        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            cofre = new CofreFisico();
            cofre.imprimirInformacoes();
    
        } else {
            System.out.println("Tipo de cofre inválido. Use 'digital' ou 'físico'.");
            return;
        }

        
        scanner.close();
    }
}
