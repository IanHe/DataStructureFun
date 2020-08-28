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
###Binary Search Tree(balance binary tree)
![Image of binary_search_tree](imgs/binary_search_tree.jpg)
![Image of binary_search_tree_1](imgs/binary_search_tree_1.jpg)