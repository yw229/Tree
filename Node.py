#!/data/NYGC/Software/python/bin/python2.7

class Node:
	"""
	TreeNode: left and right child + data value for current node
	"""
	left , right, data = None, None, 0

	def __init__(self,data):
        	# initializes the data members
        	self.left = None
        	self.right = None
        	self.data = data


class BTree:
	def __init__(self):
	# initialized the root 
		self.root = None
	
	def addNode(self,data):
		return Node(data)

	def insert(self,root,data):
		# insert new node and return it 
		if root is None:
			root = self.addNode(data)
		
		else:
			if data <=root.data:
				root.left = self.insert(root.left,data)
			else:
				root.right = self.insert(root.right,data)

		return root 	
	
	def lookup(self,root,target):
		if root is None:
			return 0 ;
		else:
			if root.data == target:
				return 1 
			else:
				if target < root.data:
					return self.lookup(root.left,target)
				else:
					return self.lookup(root.right,target)


	def minValue(self, root):
		while(root.left != None):
			root = root.left 
		
		return root.data 

	def MaxDepth(self,root):
		if root is None:
			return 0 ;
		else:
			ldept = self.MaxDepth(root.left);
			rdept = self.MaxDepth(root.right);
			return  max(ldept,rdept) +1 

	def size(self,root):
		if root is None:
			return 0 
		else:
			return self.size(root.left) + self.size(root.right) +1 

	def printTree(self,root):
		if root is None:
			pass
		else:
			self.printTree(root.left)
			print root.data
			self.printTree(root.right)
		

if __name__ == "__main__":	
		#create BTree
		bTree = BTree()
		root = bTree.addNode(100)
		
		for i in range(0,5):
			data = int(raw_input("insert the node value nr %d: " %i))
			
			bTree.insert(root,data)

		print 
	
		bTree.printTree(root)

		print 
	
		data = int(raw_input("insert a value to find: "))
		if bTree.lookup(root,data):
			print "found"
		else:
			print "not found"

		print("min value in the Tree is %s \n" %bTree.minValue(root))
		print("Max Depth of the Tree is %s \n" %bTree.MaxDepth(root))
		print("Total nodes in the tree is %s \n" %bTree.size(root))
