import numpy as np
class Perceptron:

    def __init__(self, NombreInputs, NombreEpochs, LearningRate):
        self.NombreInputs = NombreInputs
        self.NombreEpochs = NombreEpochs
        self.LearningRate = LearningRate
        self.Poids = [0, 0, 0]

    def predict(self, a):
        y = np.dot(self.Poids, a)
        if y > 0.5:
            return 1
        else:
            return 0

    def train(self, x, y):
        t = self.calculPredictionTotal(x)
        erreur = self.calculErreur(t, y)

        for epoch in range(self.NombreEpochs):

            for i in range(len(x)):
                x2 = x[i]
                t2 = self.predict(x2)
                for j in range(len(x2)):
                    temp = (self.LearningRate * (y[i] - t2) * x2[j])
                    self.Poids[j] += temp

            t = self.calculPredictionTotal(x)
            erreur = self.calculErreur(t, y)
            print(erreur)

    def calculErreur(self, t, y):
        return np.sum((np.subtract(t, y)) ** 2) / 2

    def calculPredictionTotal(self, x):
        t = []
        for i in x:
            t.append(self.predict(i))

        return t

    def get_poids(self):
        return self.Poids