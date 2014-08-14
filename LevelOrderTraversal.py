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

def levelOrderTravList(root):
	l=[]
	levell = [] #for each level of the tree, use list to store the nodes 
  	levell.append(root) 
	l.append(levell)
	dep = 0 	
	while True:
			currL = l[dep] # get current level nodes
			dlist = [] #create new list to store curr level nodes left/right nodes 

			for e in currL:
				if e:
					print ('current node is %s' %e.data)
					
					if e.left:
						print("l child value is %s: "%e.left.data)
						dlist.append(e.left)
					if e.right:
						print("r child value is %s: " %e.right.data)
						dlist.append(e.right)
					
		
			#must check whether the current level is the leaf level 
			if len(dlist)>0 :		
				l.insert(dep+1, dlist)
				print(len(dlist))
			else:
				break
							
			
			dep +=1 
			
			print("depth is %s"%dep)	
	
	return l
		
			
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
		
		print 
		
		print("print each level nodes : \n")
		
		l=levelOrderTravList(root)

		print(len(l))
		
		

