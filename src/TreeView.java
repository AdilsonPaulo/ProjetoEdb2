public class TreeView
{
	public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        tree.delete(40);
        
        System.out.println("Enesimo Elemento: " + tree.enesimoElemento(3));
        System.out.println("Posição do Elemento: " + tree.posicao(60));
        
	}
}
