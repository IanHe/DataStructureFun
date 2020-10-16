##AVL Tree & Black-Red Tree
<br></br>
<br></br>
###Tree
![Image of tree](imgs/tree.jpg)
<br></br>
###Binary Tree
![Image of binary_tree](imgs/binary_tree.jpg)
####Binary Tree Traversal:
#####Pre-order: root - left - right
#####In-order: left - root - right
#####Pre-order: left - right - root
```
Template:
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

def inorder(self, root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)

def postorder(self, root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
```
<br></br>
###Binary Search Tree
![Image of binary_search_tree](imgs/binary_search_tree.jpg)
![Image of binary_search_tree_1](imgs/binary_search_tree_1.jpg)
####When binary search tree is not correct inserted(unbalanced), it will become a linked list
![Image of linked_list](imgs/linked_list.jpg)
###Self-balancing Binary Search Tree: 2-3 Tree, AVL Tree, Red-Black Tree, B-Tree ...
![Image of balanced_binary_search_tree](imgs/balanced_binary_search_tree.jpg)
<br></br>
<br></br>
###AVL Tree - the search performance depends on the depth of the tree => balance factor = depth difference
![Image of avl_tree](imgs/avl_tree.jpg)<br></br>
###E.g: the root node balance factor = left height - right height = +1
![Image of avl_balance_factor](imgs/avl_balance_factor.jpg)
####E.g: add 3 into the AVL tree -> unbalanced -> have to rotate the tree to make balance
![Image of add_avl_tree](imgs/add_avl_tree.jpg)
![Image of add_avl_tree_1](imgs/add_avl_tree_1.jpg)
![Image of add_avl_tree_2](imgs/add_avl_tree_2.jpg)
![Image of add_avl_tree_3](imgs/add_avl_tree_3.jpg)
####Rotate the tree - be careful about how sub-node moves
![Image of rotate_tree](imgs/rotate_tree.jpg)
###AVL Summary - drawback: High Maintenance => introduce Approximately-balanced binary tree, less maintenance
![Image of avl_summary](imgs/avl_summary.jpg)
<br></br>
<br></br>
###Black-Red Tree(Approximately-balanced binary search tree)
![Image of black-red_tree](imgs/black-red_tree.jpg)
![Image of black-red_tree_1](imgs/black-red_tree_1.jpg)
###AVL vs Black-End Tree
![Image of avl_vs_black-red](imgs/avl_vs_black-red.jpg)
