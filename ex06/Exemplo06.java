import java.util.Scanner;

public class Exemplo06 {

    public static Scanner input = new Scanner(System.in);

    public static void main (String[] args){
        double[] notas = new double[5];
        double media, sum = 0, count = 0, std = 0;
        for (int i = 0; i < notas.length; i += 1) {
            System.out.print("Digite a " + (i+1) + "º nota: ");
            notas[i] = input.nextDouble();
            sum += notas[i];
        }
        media = sum/notas.length;
        for (int i = 0; i < notas.length; i++) {
            System.out.println("A " + (i+1) + "º nota eh: " + notas[i]);
        }

        System.out.println("A media da turma eh: " + media);
        System.out.println("As notas acima da media da turma: ");
        for(int i = 0; i < notas.length; i += 1) {
            if (notas[i] > media) {
                System.out.print(notas[i] + " ");
                count += 1;
            }
        }
        System.out.println("\nO total de notas acima da media da turma eh: " + count);
        for (int i = 0; i < notas.length; i+=1){
            std += Math.pow((notas[i]-media), 2);
        }

        std = Math.sqrt(std/(notas.length-1));

        System.out.println("O desvio padrao eh: " + std);
    }
    
}
