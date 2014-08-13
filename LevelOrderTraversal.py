#!/data/NYGC/Software/python/bin/python2.7


import Node
from Node import BTree


def leveOrderTravi(root):
	#bTree = BTree()
	l = []
	l.append(root)
  	while l:
		out = l.pop(0) # list as queue to store the visited node 
		if out :
			if out.left:
				l.append(out.left)
			if out.right:
				l.append(out.right)
		
		print(out.data)
			
if __name__=="__main__":
		bTree = BTree()
		root = bTree.addNode(100)
		
		for i in range(0,5):
			data = int(raw_input("insert the node value nr %d: " %i))
			bTree.insert(root,data) 

		print 
		
		bTree.printTree(root)
	
		print("after level order traversal : \n") 
	
		leveOrderTravi(root)	


