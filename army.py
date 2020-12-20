import random
class Army:

    def __init__(self, chef):
        self.chef = chef
        self.morale_base = random.uniform(20, 100)

    def getChef(self):
        return self.chef

    def getMoraleBase(self):
        return self.morale_base

    def getTotalMorale(self):
        return self.morale_base * self.chef.getBoost()

    def setChef(self, chef):
        self.chef = chef

    def setMoraleBase(self, morale_base):
        self.morale_base = morale_base

    def __repr__(self):
        return self.chef+" "+self.morale_base