# 概念说明：
前序遍历：根节点开始-左节点-右节点顺序遍历 左右子树也属于前序遍历
中序遍历：左节点-根节点-右节点顺序遍历 左右子树也属于中序遍历
后序遍历 左节点-右节点-根节点顺序遍历 左右子树也属于后序遍历

# 解法1：直接解法
前序节点的第一个必定是根节点，根据根节点在中序遍历中可以分别找到左子树和右子树（同属于中序遍历），根据找到的左子树的长度可以找到前序遍历的左子树和右子树（同样属于前序遍历）
然后递归分别找出左子树和右子树的具体顺序（使用前序遍历-左子树、中序遍历-左子树、二叉树左节点  前序遍历-右子树、中序遍历-右子树、二叉树右节点 分别递归）

# 解法2：迭代