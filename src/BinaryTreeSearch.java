public class BinaryTreeSearch {

    Node root;
    
    public BinaryTreeSearch(){
        root = null;
    }
    
    public void insert(int key){
        root = insertRec(root, key);
    }
    
    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key){
            root.left = insertRec(root.left, key);
        }
        else if (key > root.key){
            root.right = insertRec(root.right, key);
        }

        return root;
    }
    
    public Node search(Node root, int key) {
        if (root == null || root.key == key){
            return root;
        }

        if (key < root.key){
            return search(root.left, key);
        }

        return search(root.right, key);
    }
    
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null){
            return root;
        }

        if (key < root.key){
            root.left = deleteRec(root.left, key);
        }
        else if (key > root.key){
            root.right = deleteRec(root.right, key);
        }
        else {
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }
    
    public int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    public int enesimoElemento (int n){
        Counter count = new Counter();
        Node x = searchSymmetricOrder(root, n, count);
        
        if (x != null) {
            return x.key;
        } 
        else {
            System.out.println("Elemento não encontrado!");
        }

        return -1;
    }
    
    public Node searchSymmetricOrder(Node root, int n, Counter count) {
        if(root == null){
            return null;
        }
        
        Node result = searchSymmetricOrder(root.left, n, count);
        if( result != null){
            return result;
        }
        
        count.count++;
        if(count.count == n){
            return root;
        }
        
        return searchSymmetricOrder(root.right, n, count);
    }
    
    public int posicao(int x) {
        Counter count = new Counter();
        return posicaoRec(root, x, count);
    }
    
    int posicaoRec(Node root, int x, Counter count) {
        if (root != null) {
            int posicaoEsquerda = posicaoRec(root.left, x, count);
            if (posicaoEsquerda != -1) {
                return posicaoEsquerda;
        }

        count.count++;
        if (root.key == x) {
            return count.count;
        }

        return posicaoRec(root.right, x, count);
    }

        return -1; 
    }
    
}    
