#!/data/NYGC/software/python/bin/python2.7 

class StackMakeQueue:
	
	ins , outs  = None, None

        def __init__(self,ins,outs):
                # initializes the in-stack and out-stack 
                self.ins = ins
                self.outs = outs


	def enQueue(self,data):
		#put all value in out-stack back to in-stack , FI
		
		while self.outs:
			self.ins.append(self.outs.pop())
		
		self.ins.append(data)

	def deQueue(self):
		#put all value in in-stack to out-stack ,and ready to pop out , FO
		while self.ins:
			self.outs.append(self.ins.pop())

		return self.outs.pop() 

if __name__== '__main__':
	ins = []
	outs =[4,9,2]
	StQ = StackMakeQueue(ins,outs)
	data = int(raw_input("Please enter a value to enQueue: "))

	StQ.enQueue(data)
	
	print("The Queue is like: %s" %StQ.ins )
	
	print("DeQueue the value %s from Queue : " %StQ.deQueue() )
