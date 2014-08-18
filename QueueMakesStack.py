#!/data/NYGC/software/python/bin/python2.7 
from collections import deque 

class QueueMakeStack:
	
	#using two queues to make a stack , LIFO
	q1 , q2 = None, None

	def __init__(self,q1,q2):
		self.q1 = q1 ;
		self.q2 = q2 ;

	def Push(self,data): 
		self.q2.append(data)

	def Pop(self):
		self.q1 = deque(self.q1)
		while self.q1:
			self.q2.append(self.q1.popleft()) #dequeue q1 to enqueue q2 
		
		self.q1 = list(self.q1)

		self.swapq(self.q1,self.q2)
		
		self.q1 = deque(self.q1) # pop function always work on q1 
		
		return self.q1.popleft() 

	
	def swapq(self,q1,q2):
		tmp = self.q1 
		self.q1 = self.q2 
		self.q2 = tmp 
		
if __name__ == '__main__':
		q1 = [1,2,3]
		q2 = []
		Qst = QueueMakeStack(q1,q2)
		
		data = int(raw_input("Please enter a value to make Stack: "))
		
		Qst.Push(data)
		print('after push value %s, q2 is %s : \n' %(data,Qst.q2))
	
		print('pop the value from stack is %s : ' %Qst.Pop())

		 
				
	
		
