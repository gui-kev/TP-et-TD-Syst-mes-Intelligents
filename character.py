class Character:

    def __init__(self, name, firstname, age, profession, boost):
        self.name = name
        self.firstname = firstname
        self.age = age
        self.profession = profession
        self.boost = boost

    def getNom(self):
        return self.name

    def getPrenom(self):
        return self.firstname

    def getAge(self):
        return self.age

    def getProfession(self):
        return self.profession

    def getBoost(self):
        return self.boost


    def setBoost(self, boost):
        self.boost = boost

    def setNom(self, name):
        self.name = name

    def setPrenom(self, firstname):
        self.firstname = firstname

    def setAge(self, age):
        self.age = age

    def setprofession(self, profession):
        self.profession = profession

    def __repr__(self):
        return self.name + " " + self.firstname + " " + self.age + " " + self.profession + " " + self.boost
