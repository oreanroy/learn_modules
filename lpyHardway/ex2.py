import threading 

def increment():
	
	global x
	x += 1

def thread_task():
	
	for _ in range(100000):
		increment()

def main_task():
	global x

	x = 0
	
	t1 = threading.Thread(target=thread_task)
	t2 = threading.Thread(target=thread_task)

	t1.start()
	t2.start()

	t1.join()
	t2.join()

if __name__ == "__main__":
	for i in range(10):
		main_task()
		print("Iteration {0}: x = {1}".format(i,x))



