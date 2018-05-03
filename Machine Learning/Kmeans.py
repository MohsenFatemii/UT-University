import matplotlib.pyplot as plt
import numpy as np
import random
from numpy import sqrt

class point:
	def __init__(self,x,y):
		self.x = x
		self.y = y
		self.tag = -1
	def getX(self):
		return self.x
	def setX(self,X):
		self.x = X
	def getY(self):
		return self.y
	def setY(self,Y):
		self.y = Y
	def getTag(self):
		return self.tag
	def setTag(self,Tag):
		self.tag = Tag
	def toString(self):
		return str(self.x)+" "+str(self.y)


class KMeans:
	def __init__(self,num_of_clusters):
		self.k = num_of_clusters
		self.data = []
		self.clusters = []
		self.cost = []

	def makeData(self,address):
		turn = 0
		with open(address) as file:
			x,y=10000,10000
			for line in file:
				if turn == 0:
					x = float(line)
					turn = 1-turn
				else:
					y = float(line)
					turn = 1-turn
					Point = point(x,y)
					self.data.append(Point)

	def makeRandomClusters(self):
		for i in range(self.k):
			randPoint = point(random.random(),random.random())
			self.clusters.append(randPoint)

	def calcDistance(self,Point):
		index,ans = 0,1000
		for i in range(self.k):
			temp = sqrt(pow(Point.getX()-self.clusters[i].getX(),2)+pow(Point.getY()-self.clusters[i].getY(),2))
			if temp<ans:
				index = i
				ans = temp
		return index

	def makeTags(self):
		for i in range(len(self.data)):
			index = self.calcDistance(self.data[i])
			self.data[i].setTag(index)

	def calcMean(self):
		for i in range(len(self.clusters)):
			temp1,temp2,cnt = 0.0,0.0,0.0 
			for j in range(len(self.data)):
				if self.data[j].getTag()==i:
					temp1+=self.data[j].getX()
					temp2+=self.data[j].getY()
					cnt+=1
			if cnt>0:
				self.clusters[i].setX(temp1/cnt)
				self.clusters[i].setY(temp2/cnt)

	def calcJ(self):
		J = 0
		for i in range(len(self.data)):
			for j in range(len(self.clusters)):
				if self.data[i].getTag()==j:
					J+=pow(self.data[i].getX()-self.clusters[j].getX(),2)+pow(self.data[i].getY()-self.clusters[j].getY(),2)
		self.cost.append(J)

	def KMeansAlgorithm(self,epochs=10):
		self.makeData("C:\\Users\\COMPUTER ME\\Desktop\\old_faith_data.txt")
		self.makeRandomClusters()
		for i in range(epochs):
			self.makeTags()
			self.calcJ()
			self.calcMean()
		plt.title('KMeans with '+str(self.k)+' clusters')
		for j in range(len(self.data)):
			plt.plot(self.data[j].getX(),self.data[j].getY(),color[self.data[j].getTag()]+'o')
		for j in range(len(self.clusters)):
			plt.plot(self.clusters[j].getX(),self.clusters[j].getY(),'kx',mew=10,markersize=14)
		plt.show()
		epoch = np.arange(len(self.cost))
		plt.title("Cost Function per Epoch")
		plt.plot(epoch,self.cost)
		plt.plot(epoch,self.cost,'ro')
		plt.show()

color = ['b','r','g','c','m','y']
kmeans = KMeans(2)
kmeans.KMeansAlgorithm(10)